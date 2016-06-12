/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Decode.AsciiCharacter;
import Decode.Tree;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class WriteFile {
        ObjectOutputStream objectOS;

    public void open(String url) throws IOException {
        objectOS = new ObjectOutputStream(new FileOutputStream(url));
    }

  
    

    public void writeTree(Tree tree) throws IOException {
        objectOS.writeObject(tree);
    }
    
    public void writeDictionary(ArrayList<AsciiCharacter> objects) throws IOException {
        objectOS.writeObject(objects);
        }

    public void close() throws IOException {
        objectOS.flush();
        objectOS.close();
    }

}
