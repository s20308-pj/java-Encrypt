package pam.pam;

public class UnicodEncrypt implements ReferEncryption{
    public static String encrypt(String toEncrypt, int key) {
        char[] word = toEncrypt.toCharArray();
        for (int i = 0; i < word.length; i++) {
            if (65 <= word[i] && 90 >= word[i]) {
                word[i] = (char) checkCappitolLetter((int) (word[i] + key));
            }
            if (97 <= word[i] && 122 >= word[i]) {
                word[i] = (char) checkSmallLetter((int) (word[i] + key));
            }
            word[i] += 191;
            System.out.print((int)word[i]+",");
        }
        return String.valueOf(word);
    }

    public static String decrypt(String toDecrypt, int key) {
        char[] word = toDecrypt.toCharArray();
        for (int i = 0; i < word.length; i++) {
            word[i] -= 191;
            if (65 <= word[i] && 90 >= word[i]) {
                word[i] = (char) checkCappitolLetter((int) (word[i] - key));
            }
            if (97 <= word[i] && 122 >= word[i]) {
                word[i] = (char) checkSmallLetter((int) (word[i] - key));
            }
        }
        return String.valueOf(word);
    }

    private static int checkCappitolLetter(int letter) {
        if (letter < 65) {
            letter += 26;
        }
        if (letter > 90 && letter < 97) {
            letter -= 26;
        }
        return letter;
    }

    private static int checkSmallLetter(int letter) {
        if (letter < 97) {
            letter += 26;
        }
        if (letter > 122) {
            letter -= 26;
        }
        return letter;
    }
}

