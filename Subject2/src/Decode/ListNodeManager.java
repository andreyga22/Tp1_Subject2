/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decode;

/**
 *
 * @author andrey
 */
public class ListNodeManager {

    private NodeList first;
    private NodeList ultimo;

    public void insertAtLast(NodeList node) {
        if(first == null) {
            first = node;
            ultimo = first;
        } else {
            ultimo.setRight(node);
            ultimo = ultimo.getRight();
        }
    }
    
    public NodeTree pull() {
        NodeTree element = first.getData();
        first = first.getRight();
        return element;
    }
}
