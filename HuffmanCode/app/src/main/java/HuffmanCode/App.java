package HuffmanCode;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isValid = false;
        System.out.println("Enter message to encode: ");
        String message = "";

        while(!isValid) {
            message = in.nextLine().toLowerCase();
            System.out.println("Your message (lower case): " + message);

            for(int i = 0; i < message.length(); i++)  {
                char c = message.charAt(i);
                //check if the character is a letter or space
                if(!(c == 32 || (c>=65 && c<=90) || (c>=97 && c<=122))) {
                    System.out.println("Invalid input, try again! \n");
                    break;
                } else if (i == message.length() - 1) {
                    isValid = true;
                }
            }

        }

        HuffmanTree tree = new HuffmanTree(message);
        System.out.println("Table: " + tree.getTableString());

        String encoded = tree.getEncoded();
        System.out.println("Encoded message: " + encoded);

        String decoded = tree.decodeMessage(encoded);
        System.out.println("Decoded message: " + decoded);
        System.out.println("Original message: " + message);
        System.out.println("Matching: " + message.equals(decoded));
    }
}
