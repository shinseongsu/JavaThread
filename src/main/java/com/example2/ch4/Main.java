package com.example2.ch4;

public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaveThread("SaveThread", data).start();
    }
}
