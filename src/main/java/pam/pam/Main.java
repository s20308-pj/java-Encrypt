package pam.pam;

public class Main {

    public static void main(String[] args) {
        String chose = "decrypt";
        String metod = "unicode";
        String sentence = "";
        int key = 0;
        String patchToFile = null;
        String whetherToSave = null;
        String modifiedText = null;

        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    chose = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    sentence = args[i + 1];
                    break;
                case "-out":
                    whetherToSave = "save";
                    patchToFile = args[i + 1];
                    break;
                case "-in":
                    whetherToSave = "load";
                    patchToFile = args[i + 1];
                    break;
                case "-alg":
                    metod = args[i + 1];
                default:
                    System.out.println("zly argument");
                    System.exit(1);
            }
        }
        System.out.println(chose + " " + key + " " + sentence);
        if (whetherToSave == "load") {
            sentence = ReadWrite.toRead(patchToFile);
        }
        switch (metod) {
            case "shift":
                switch (chose) {
                    case "encrypt":
                        modifiedText = ShiftEncrypt.encrypt(sentence, key);
                        break;
                    case "decrypt":
                        modifiedText = ShiftEncrypt.decrypt(sentence, key);
                        break;
                    default:
                        System.out.println("Bad method parameters\n use encrypt or decrypt");
                        System.exit(1);
                }
                break;
            case "unicode":
                switch (chose) {
                    case "encrypt":
                        modifiedText = UnicodEncrypt.encrypt(sentence, key);
                        break;
                    case "decrypt":
                        modifiedText = UnicodEncrypt.decrypt(sentence, key);
                        break;
                    default:
                        System.out.println("Bad method parameters\n use encrypt or decrypt");
                        System.exit(1);
                        break;
                }
                break;
            case "atbash":
                modifiedText = AtBashEncrypt.encrypt(sentence);
                break;
            default:
                System.out.println("Bad algorithm parameters\n use shift, unicode or atbash");
                System.exit(1);
        }
        if (whetherToSave == "save") {
            ReadWrite.toWrite(modifiedText, patchToFile);
        } else {
            System.out.println(modifiedText);
        }
    }
}
