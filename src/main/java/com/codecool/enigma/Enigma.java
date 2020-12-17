package com.codecool.enigma;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Scanner;

class Enigma {

    private static String MENU = "Enigma Manual\n" +
            "Run options: [-h | -e | -d] {CipherName} {FileName} {EncryptionKey}\n" +
            "   -h : displays this menu; other arguments are ignored.\n" +
            "   -e : encrypt and display\n" +
            "   -d : decrypt and display\n" +
            "   CipherName      : cipher to use when encrypting/decrypting; [rot13, rail-fence, morse]\n" +
            "   FileName        : path to file to encrypt/decrypt\n" +
            "   EncryptionKey   : Optional -> must be provided if cipher requires a key";

    public static void main(String[] args) {
        ArgsParser argsParser = new ArgsParser(args);
        if (argsParser.getOption().equals("-h") || argsParser.getOption() == null) {
            System.out.println(MENU);
            System.exit(0);
        }
        try {
            handleCipherOperation(argsParser);
        } catch (EnigmaException ex) {
            System.out.println(ex.getMessage());
            System.out.println(MENU);
            System.exit(0);
        }

    }

    private static void handleCipherOperation(ArgsParser argsParser) throws EnigmaException {
        Cipher cipher = CipherFactory.getCipherForArgs(argsParser);
        String text = readFile(argsParser);
        if (argsParser.getOption().equals("-e")) {
            System.out.println(cipher.encrypt(text));
        } else if (argsParser.getOption().equals("-d")) {
            System.out.println(cipher.decrypt(text));
        } else {
            throw new EnigmaException("Invalid argument.");
        }
    }

    private static String readFile(ArgsParser argsParser) throws EnigmaException {
        File file = new File(argsParser.getFile());
        try {
            Scanner fileReader = new Scanner(file);
            return fileReader.nextLine();
        } catch (FileNotFoundException ex) {
            throw new EnigmaException("File not found");
        }
    }
}
