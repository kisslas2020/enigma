package com.codecool.enigma;

class CipherFactory {

    static boolean isCipherAvailable(String cipherName) {
        return cipherName.equals("rot13") || cipherName.equals("rail-fence") || cipherName.equals("morse");
    }

    static Cipher getCipherForArgs(ArgsParser argsParser) throws EnigmaException {
        if (isCipherAvailable(argsParser.getCipher())) {
            switch (argsParser.getCipher()) {
                case "rot13":
                    return new Rot13();
                case "rail-fence":
                    if (argsParser.getKey() != null) {
                        return new RailFence(Integer.parseInt(argsParser.getKey()));
                    } else {
                        throw new EnigmaException("Invalid key for rail-fence cipher");
                    }
                case "morse":
                    return new MorseCode();
            }
        } else {
            throw new EnigmaException("Non-existant cipher.");
        }
        return null;
    }


}
