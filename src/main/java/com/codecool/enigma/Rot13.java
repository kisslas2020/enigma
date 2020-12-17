package com.codecool.enigma;

import java.util.HashMap;
import java.util.Map;

class Rot13 implements Cipher {

    HashMap<Character, Character> rot13 = new HashMap<Character, Character>();
    String rott13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Rot13() {
    }

    private HashMap mapMaker() {
        rot13.put('a', 'n');
        rot13.put('b', 'o');
        rot13.put('c', 'p');
        rot13.put('d', 'q');
        rot13.put('e', 'r');
        rot13.put('f', 's');
        rot13.put('g', 't');
        rot13.put('h', 'u');
        rot13.put('i', 'v');
        rot13.put('j', 'w');
        rot13.put('k', 'x');
        rot13.put('l', 'y');
        rot13.put('m', 'z');
        rot13.put('n', 'A');
        rot13.put('o', 'B');
        rot13.put('p', 'C');
        rot13.put('q', 'D');
        rot13.put('r', 'E');
        rot13.put('s', 'F');
        rot13.put('t', 'G');
        rot13.put('u', 'H');
        rot13.put('v', 'I');
        rot13.put('w', 'J');
        rot13.put('x', 'K');
        rot13.put('y', 'L');
        rot13.put('z', 'M');
        rot13.put('A', 'N');
        rot13.put('B', 'O');
        rot13.put('C', 'P');
        rot13.put('D', 'Q');
        rot13.put('E', 'R');
        rot13.put('F', 'S');
        rot13.put('G', 'T');
        rot13.put('H', 'U');
        rot13.put('I', 'V');
        rot13.put('J', 'W');
        rot13.put('K', 'X');
        rot13.put('L', 'Y');
        rot13.put('M', 'Z');
        rot13.put('N', 'a');
        rot13.put('O', 'b');
        rot13.put('P', 'c');
        rot13.put('Q', 'd');
        rot13.put('R', 'e');
        rot13.put('S', 'f');
        rot13.put('T', 'g');
        rot13.put('U', 'h');
        rot13.put('V', 'i');
        rot13.put('W', 'j');
        rot13.put('X', 'k');
        rot13.put('Y', 'l');
        rot13.put('Z', 'm');
        return rot13;
    }

    @Override
    public String encrypt(String message) {
        String encryptMessage = "";
        for (int i = 0; i < message.length(); i++) {
            encryptMessage = encryptMessage + encryptLetter(message.charAt(i));
        }
        return encryptMessage;
    }

    @Override
    public String decrypt(String message) {
        String decryptMessage = "";
        for (int i = 0; i < message.length(); i++) {
            decryptMessage = decryptMessage + decryptLetter(message.charAt(i));
        }
        return decryptMessage;
    }

    private char encryptLetter(char letter) {
        if (rott13.indexOf(letter) == -1) {
            return letter;
        }
        int num = rott13.indexOf(letter) + 13;
        if (num > 51) {
            num -= 52;
        }
        return rott13.charAt(num);
    }

    private char decryptLetter(char letter) {
        if (rott13.indexOf(letter) == -1) {
            return letter;
        }
        int num = rott13.indexOf(letter) -13;
        if (num <0) {
            num += 52;
        }
        return rott13.charAt(num);
    }
}
