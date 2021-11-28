package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {

        JFrame window=new JFrame("Game");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        FileWriter write = new FileWriter("map.txt");
        PrintWriter pw=new PrintWriter(write);

        pw.print("hasdfsf");
        System.out.println();
    }


}
