package Main;

import Decode.Tree;
import Views.ChatWindow;
import Views.MainWindow;
import java.awt.Frame;
import objectssockets.Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author andre
 */
public class Controller {

    private ChatWindow chatW;

    public Controller() {
    }

    public void writeInTextField(String text) {
        chatW.read(text);
    }

    public void initializeChat(Client client, Frame parent, boolean modal, Tree tree) {
        chatW = new ChatWindow(parent, true, tree, client);
        chatW.setVisible(true);
    }

}
