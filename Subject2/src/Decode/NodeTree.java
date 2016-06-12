/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decode;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class NodeTree implements Serializable{
    private AsciiCharacter data;
    private NodeTree right;
    private NodeTree left;

    public NodeTree(AsciiCharacter dato) {
        this.data = dato;
    }

    public AsciiCharacter getData() {
        return data;
    }

    public void setData(AsciiCharacter data) {
        this.data = data;
    }

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + data + ", derecho=" + right + ", izquierdo=" + left + '}';
    }
    
    
}
