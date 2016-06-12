/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Decode.AsciiCharacter;
import Decode.Tree;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class ReadFile {

    ObjectInputStream objectIS;

    public void open(File file) throws IOException {
        objectIS = new ObjectInputStream(new FileInputStream(file));
    }

    public Tree readTree() throws ClassNotFoundException, IOException {
        Tree e = (Tree) objectIS.readObject();
        return e;
    }

    public ArrayList<AsciiCharacter> readDictionary() throws IOException, ClassNotFoundException {
        ArrayList<AsciiCharacter> element = (ArrayList<AsciiCharacter>) objectIS.readObject();
        return element;
    }

    public void close() throws IOException {
        objectIS.close();
    }

}
