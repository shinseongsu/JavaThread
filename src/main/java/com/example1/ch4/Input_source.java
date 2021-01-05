package com.example1.ch4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Input_source extends Frame {

    int[] text_has_been_entered = new int[1];   // 조건 변수

    TextField input = new TextField();

    public Input_source() {
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (text_has_been_entered) {
                    text_has_been_entered.notify();     // 조건 변수를 참으로 설정한다.
                }
            }
        });

        add(input);
        pack();
        show();
    }

    synchronized String read_line() throws InterruptedException {
        synchronized (text_has_been_entered) {
            text_has_been_entered.wait();
        }

        String entered = input.getText();
        input.setText("");
        return (entered.length() == 0) ? null : entered;
    }

    public static void main(String[] args) throws Exception {
        Input_source source = new Input_source();
        String input;

        while( (input = source.read_line()) != null) {
            System.out.println("Got:" + input);
        }

        System.exit(0);
    }

}
