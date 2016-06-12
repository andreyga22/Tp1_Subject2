/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decode;
/**
 *
 * @author andre
 */
public class ArrayAscii {
    private final AsciiCharacter[] list = new AsciiCharacter[468];
    private int counter = 0;
        private static final int MAX_CHAR = 468;

    
    public void fill() {
        for (int i = 32; i < MAX_CHAR; i++) {
            int random = (int) (Math.random() * 12000);
            list[counter] = new AsciiCharacter(random, (char)i);
            counter++;
        }
    }
    
    public AsciiCharacter getByIndex(int i) {
            if(list[i] != null) {
                return list[i];
            }
            return null;
    }
}
