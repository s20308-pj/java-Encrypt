package pam.pam;

public class CesarEncrypt {
    public static String encrypt(String toEncrypt, int redeploy) {
        char[] word = toEncrypt.toLowerCase().toCharArray();
        for (int i = 0; i < word.length; i++) {
            if ((97 <= word[i]) && (122 >= word[i])) {
                word[i] = (char) (word[i] + redeploy);
                if (word[i] > 122) {
                    word[i] -= 26;
                }
                if (word[i] < 97) {
                    word[i] += 26;
                }
            }
        }
        return String.valueOf(word);
    }
}

