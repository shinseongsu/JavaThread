package com.example1.ch1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hang extends JFrame {
    public Hang() {
        JButton b1 = new JButton("Sleep");
        JButton b2 = new JButton("Hello");

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    Thread.currentThread().sleep(5000);
                } catch(Exception e) {

                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello world");
            }
        });

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(b1);
        getContentPane().add(b2);
        pack();
        show();
    }

    public static void main(String[] args) {
        new Hang();
    }
}
