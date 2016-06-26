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
public class NodeList {

    private NodeTree data;
    private NodeList right;

    public NodeList(NodeTree dato) {
        this.data = dato;
    }

    public NodeTree getData() {
        return data;
    }

    public void setData(NodeTree data) {
        this.data = data;
    }

    public NodeList getRight() {
        return right;
    }

    public void setRight(NodeList right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "NodeList{" + "data=" + data + ", right=" + right + '}';
    }

}
