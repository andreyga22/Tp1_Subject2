/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decode;

import File.ReadFile;
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
    private WriteFile write = new WriteFile();
    private ArrayList<AsciiCharacter> dictionary = new ArrayList<>();
    private static final int MAX_CHAR = 468;

    public void insertElement(AsciiCharacter ascii) throws DuplicatedElement {
        root = insert(ascii, root);
    }

    private NodeTree insert(AsciiCharacter ascii, NodeTree t) throws DuplicatedElement {

        if (t == null) {
            t = new NodeTree(ascii);
        } else //            System.out.println("Raiz: " + t.getData() + "    ascii: " + ascii.getWeight());
        {
            if (ascii.getWeight() < t.getData().getWeight()) {
                t.setLeft(insert(ascii, t.getLeft()));
            } else if (ascii.getWeight() > t.getData().getWeight()) {
                t.setRight(insert(ascii, t.getRight()));
            } else {
                ascii.setWeight((int) (Math.random() * 12000));
                insert(ascii, t);
            }
        }
        return t;
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

    public void writeInTheFile() throws IOException {
        write.open("key.bin");
        writeTree();
        writeKey();
        write.close();
    }

    private void writeTree() throws IOException {
        write.writeTree(this);
    }

    private void writeKey() throws IOException {
        write.writeDictionary(dictionary);
    }

    public void setDictionary(ArrayList<AsciiCharacter> element) {
        this.dictionary = element;
    }

    public void createDictionary() {
        for (int i = 32; i < MAX_CHAR; i++) {
            String actualKey = findKey((char) i, root, "");
            AsciiCharacter element = new AsciiCharacter(0, (char) i);
            element.setCode(actualKey);
            System.out.println(element);
            dictionary.add(element);
        }
    }

    public String findKey(char ascii) {
        return findKey(ascii, root, "");
    }

    private String findKey(char ascii, NodeTree r, String code) {
        while (r != null) {
            if (ascii > r.getData().getCharacter()) {
                code += 1;
                r = r.getRight();
            } else if (ascii < r.getData().getCharacter()) {
                code += 0;
                r = r.getLeft();
            } else {
                return code;
            }
        }
        return null;
    }

    public void hexa() {
    }

}
