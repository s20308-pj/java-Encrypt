package pam.pam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Podaj rodzaj dzialania:\n1. szyfrowanie atBasha\n2. szyfrowanie cezara\n3. rozszwfrowywanie cezara");
        int chose = stringToInt(take());
        switch (chose) {
            case 1:
                System.out.println("Podaj zdanie: ");
                System.out.println(AtBashEncrypt.encrypt(take().toLowerCase()));
                break;
            case 2:
                System.out.println("Podaj zdanie: ");
                String sentence = take().toLowerCase();
                System.out.println("Podaj przesuniecie: ");
                int redeploy = stringToInt(take());
                System.out.println(CesarEncrypt.encrypt(sentence, redeploy));
                break;
            case 3:
                System.out.println("Podaj zdanie: ");
                sentence = take().toLowerCase();
                System.out.println("Podaj przesuniecie: ");
                redeploy = stringToInt(take());
                System.out.println(CesarEncrypt.decrypt(sentence, redeploy));
        }
    }

    static String take() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static int stringToInt(String s) {
        return Integer.parseInt(s);
    }
}
