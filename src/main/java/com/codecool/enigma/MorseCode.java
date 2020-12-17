package com.codecool.enigma;

class MorseCode implements Cipher {
    String abc = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
    String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---",
            "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};



    @Override
    public String encrypt(String message) {
        String encode = "";
        message = message.toUpperCase();
        for(int i = 0; i < message.length(); i++){
            String s = message.substring(i, i + 1);
            if (s.equals(" ")) {
                encode = encode.concat(" / ");
            } else {
                try {
                    encode = encode.concat(morse[abc.indexOf(s)]).concat(" ");
                } catch (Exception ex) {
                    continue;
                }
            }
        }
        return encode.trim();
    }

    @Override
    public String decrypt(String message) {
        String decode = "";
        message = message.toUpperCase();
        String[] msg = message.split(" ");
        for (int i = 0; i < msg.length; i++) {
            if (msg[i].equals("/")) {
                decode = decode.concat(" ");
            } else {
                for (int j = 0; j < morse.length; j++) {
                    if (msg[i].equals(morse[j])) {
                        decode = decode.concat(abc.substring(j, j + 1));
                        break;
                    }
                }
            }
        }
        return decode;
    }
}
