package Decode;

import java.io.Serializable;

public class AsciiCharacter implements Serializable {

    private int weight;
    private char character;
    private String code;

    public AsciiCharacter(int weight, char nombre) throws IllegalArgumentException {
        this.weight = weight;
        this.character = nombre;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Character{" + "peso=" + weight + ", char=" + character + '}';
    }
}
