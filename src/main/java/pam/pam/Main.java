package pam.pam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Podaj rodzaj szyfrowania:\n1. atBash\n2. cesar");
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
