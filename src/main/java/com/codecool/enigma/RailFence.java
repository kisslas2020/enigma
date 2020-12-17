package com.codecool.enigma;

class RailFence implements Cipher {
    int key;
    char[][] table;
    boolean down;



    public RailFence(int key) {
        this.key = key;

    }

    @Override
    public String encrypt(String message) {
        int row = 0;
        down = true;
        table = new char[key][message.length()];
        for (int i = 0; i < message.length(); i++) {
            table[row][i] = message.charAt(i);
            row = walkV(row);
        }
        return assemble();
    }

    private String assemble() {
        int row = 0;
        String encryptedText = "";
        for (int rowFrom = 0; rowFrom < key; rowFrom++) {
            for (int i = 0; i < table[0].length; i++) {
                if (row == rowFrom) {
                    encryptedText += table[row][i];
                }
                row = walkV(row);
            }
        }
        return encryptedText;
    }

    private int walkV(int row) {
        if(down) {
            row++;
            if (row == key - 1) {
                down = false;
            }
        } else {
            row--;
            if (row == 0) {
                down = true;
            }
        }
        return row;
    }



    @Override
    public String decrypt(String message) {
        table = new char[key][message.length()];
        down = true;
        disassemble(message);
        int row = 0;
        String decryptedText = "";
        for (int i = 0; i < message.length(); i++){
            decryptedText += table[row][i];
            row = walkV(row);
        }
        return decryptedText;
    }

    private void disassemble(String message) {

        int charAt = 0;
        for (int i = 0; i < key; i++) {
            int row = 0;
            for (int j = 0; j < message.length(); j++) {
                if (row == i) {
                    table[i][j] = message.charAt(charAt);
                    charAt++;
                }
                row = walkV(row);
            }
        }
    }
}
