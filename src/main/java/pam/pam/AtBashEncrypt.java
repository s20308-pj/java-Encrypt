package pam.pam;

public class AtBashEncrypt implements ReferEncryption {

    public static String encrypt(String toEncrypt) {
        char[] word = toEncrypt.toCharArray();
        for (int i = 0; i < word.length; i++) {
            if ((97 <= word[i]) && (122 >= word[i])) {
                word[i] = (char) (122 - word[i] + 97);
            }
        }
        return String.valueOf(word);
    }
}

