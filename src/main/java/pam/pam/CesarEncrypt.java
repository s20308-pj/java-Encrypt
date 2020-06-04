package pam.pam;

public class CesarEncrypt {
    public static String encrypt(String toEncrypt, int redeploy) {
        char[] word = toEncrypt.toLowerCase().toCharArray();
        for (int i = 0; i < word.length; i++) {
            if ((97 <= word[i]) && (122 >= word[i])) {
                word[i] = (char) checkLetter((int) (word[i] + redeploy));
            }
        }
        return String.valueOf(word);
    }

    public static String decrypt(String toDecrypt, int redeploy) {
        char[] word = toDecrypt.toLowerCase().toCharArray();
        for (int i = 0; i < word.length; i++) {
            if ((97 <= word[i]) && (122 >= word[i])) {
                word[i] = (char) checkLetter((int) (word[i] - redeploy));
            }
        }
        return String.valueOf(word);
    }

    private static int checkLetter(int letter) {
        if (letter > 122) {
            letter -= 26;
        }
        if (letter < 97) {
            letter += 26;
        }
        return letter;
    }
}
