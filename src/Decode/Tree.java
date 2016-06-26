/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decode;

import File.WriteFile;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Tree implements Serializable {

    private NodeTree root = null;
//    private WriteFile write = new WriteFile();
    private ArrayList<AsciiCharacter> dictionary = new ArrayList<>();
    private static final int MAX_CHAR = 468;

    public void insertElement(AsciiCharacter ascii) throws DuplicatedElement {
        root = insert(ascii, root);
    }

    private NodeTree insert(AsciiCharacter ascii, NodeTree t) throws DuplicatedElement {
        if (t == null) {
            t = new NodeTree(ascii);
            return t;
        } else {
            if (ascii.getWeight() < t.getData().getWeight()) {
                t.setLeft(insert(ascii, t.getLeft()));
            } else if (ascii.getWeight() > t.getData().getWeight()) {
                t.setRight(insert(ascii, t.getRight()));
            } else {
                ascii.setWeight((int) (Math.random() * 12000));
                insert(ascii, root);
            }
            return t;
        }
    }

    public AsciiCharacter find(int ascii) {
        return find(ascii, root);
    }

    private AsciiCharacter find(int ascii, NodeTree r) {
        while (r != null) {
            if (ascii > r.getData().getWeight()) {
                r = r.getRight();
            } else if (ascii < r.getData().getWeight()) {
                r = r.getLeft();
            } else {
                return r.getData();
            }
        }
        return null;
    }

    public AsciiCharacter findMin() {
        return findMin(root);
    }

    private AsciiCharacter findMin(NodeTree root) {
        if (root != null) {
            while (root.getLeft() != null) {
                root = root.getLeft();
            }
            return root.getData();
        }
        return null;
    }

    public AsciiCharacter findMax() {
        return findMax(root);
    }

    private AsciiCharacter findMax(NodeTree root) {
        if (root != null) {
            while (root.getRight() != null) {
                root = root.getRight();
                return root.getData();
            }
        }
        return null;
    }

    public void postOrdenPrint() {
        postOrden();
    }

    public void preOrdenPrint() {
        preOrden();
    }

    public void enOrdenPrint() {
        enOrden();
    }

    private void postOrden() {
        postOrden(root);
    }

    private void preOrden() {
        preOrden(root);
    }

    private void enOrden() {
        enOrden(root);
    }

    public void postOrden(NodeTree root) {
        if (root != null) {
            postOrden(root.getLeft());
            postOrden(root.getRight());
            System.out.println(root.getData().toString());
        }
    }

    public void preOrden(NodeTree root) {
        if (root != null) {
            System.out.println(root.getData().toString());
            preOrden(root.getLeft());
            preOrden(root.getRight());
        }
    }

    public void enOrden(NodeTree root) {
        if (root != null) {
            enOrden(root.getLeft());
            System.out.println(root.getData().toString());
            enOrden(root.getRight());
        }
    }

    public void deleteMin() throws DuplicatedElement {
        root = deleteMin(root);
    }

    private NodeTree deleteMin(NodeTree root) throws DuplicatedElement {
        if (root == null) {
            throw new DuplicatedElement("No existe la raiz");
        }
        if (root.getLeft() == null) {
            return root.getRight();
        }

        root.setLeft(deleteMin(root.getLeft()));
        return root;
    }

    public void delete(int ascii) throws DuplicatedElement {
        root = deleteAscii(ascii, root);
    }

    private NodeTree deleteAscii(int ascii, NodeTree root) throws DuplicatedElement {
        if (root == null) {
            throw new DuplicatedElement("No existe la raiz");
        }
        if (ascii < root.getData().getWeight()) {
            root.setLeft(deleteAscii(ascii, root.getLeft()));
        } else if (ascii > root.getData().getWeight()) {
            root.setRight(deleteAscii(ascii, root.getRight()));
        } else if (root.getLeft() != null && root.getRight() != null) {
            root.setData(findMin(root.getRight()));
            root.setRight(deleteMin(root.getRight()));
        } else {
            return (root.getLeft() != null) ? root.getLeft() : root.getRight();
        }
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void vaciar() {
        root = null;
    }

    public void writeInTheFile(WriteFile wf) throws IOException {
        wf.open("key.bin");
        writeTree(wf);
//        writeKey(wf);
        wf.close();
    }

    private void writeTree(WriteFile wf) throws IOException {
        wf.writeTree(this);
    }

    public void createDictionaryAndTree() throws DuplicatedElement {
        for (int i = 32; i < MAX_CHAR; i++) {
            int random = (int) (Math.random() * 12000);
            AsciiCharacter auxA = new AsciiCharacter(random, (char) i);
            System.out.println((char) i);
            insertElement(auxA);
            String code = findKey(auxA);
            auxA.setCode(code);
            dictionary.add(auxA);
        }
    }

    private String findKey(AsciiCharacter ascii) {
        String code = "";
        code = findKey(ascii, root, code);
        return code;
    }

    private String findKey(AsciiCharacter ascii, NodeTree r, String code) {
        if (r != null) {
            if (r.getData().getWeight() == ascii.getWeight()) {
                return code;
            } else if (ascii.getWeight() > r.getData().getWeight()) {
                code += 1;
                return findKey(ascii, r.getRight(), code);
            } else if (ascii.getWeight() < r.getData().getWeight()) {
                code += 0;
                return findKey(ascii, r.getLeft(), code);
            }
        }
        return code;
    }

    public String makeHexa(String text) {
        char[] chars = text.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString();
    }

    public String decodeHexa(String text) {
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < text.length(); i += 2) {
            String str = text.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }

    public String encode(String text) {
        String code = "";
        System.out.println("Palabra sin codificar " + text);
        for (int i = 0; i < text.length(); i++) {
            String searched = searchInDictionary(text.charAt(i));
            if (i != text.length() - 1) {
                code += searched + ",";
            } else {
                code += searched;
            }
        }
        System.out.println("codigo despues de codigicar " + code);
        code = makeHexa(code);
        return code;
    }

    public String decode(String text) {
        System.out.println("Variable que se recibe en el decode " + text);
        text = decodeHexa(text);
        System.out.println("Variable que se recibe en el decodeHJexa " + text);
        String ready = "";
        String[] reText = text.split(",");
        for (int i = 0; i < reText.length; i++) {
            String temp = searchCode(reText[i]);
            if (temp != null) {
                ready += temp;
            }
        }
        return ready;
    }

    public String searchInDictionary(char letter) {
        String text = "";
        for (AsciiCharacter aux : dictionary) {
            if (aux != null && aux.getCharacter() == letter) {
                System.out.println("aux.getCode() " + aux.getCode());
                text += aux.getCode();
            }
        }
        return text;
    }

    private String searchCode(String text) {
        System.out.println("text en searchCode " + text);
        for (AsciiCharacter aux : dictionary) {
            if (aux != null && aux.getCode().equalsIgnoreCase(text)) {
                return aux.getCharacter() + "";
            }
        }
        return null;
    }
}
