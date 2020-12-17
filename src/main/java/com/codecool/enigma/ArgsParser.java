package com.codecool.enigma;

class ArgsParser {

    private final String option;
    private final String cipher;
    private final String file;
    private final String key;

    ArgsParser(String[] args) {
        this.option = args.length >= 1 ? args[0] : null;
        this.cipher = args.length >= 2 ? args[1] : null;
        this.file = args.length >= 3 ? args[2] : null;
        this.key = args.length >= 4 ? args[3] : null;
    }

    public String getOption() {
        return option;
    }

    public String getCipher() {
        return cipher;
    }

    public String getFile() {
        return file;
    }

    public String getKey() {
        return key;
    }
}
