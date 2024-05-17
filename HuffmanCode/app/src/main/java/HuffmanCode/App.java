package HuffmanCode;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = "";

        while(true) {
            System.out.println("Enter message to encode (-1 to exit): ");
            boolean isValid = false;
            while(!isValid) {
                message = in.nextLine();

                if(message.equals("-1")) {
                    return;
                }

                System.out.println("Your message: " + message);

                for(int i = 0; i < message.length(); i++)  {
                    char c = message.charAt(i);
                    //check if the character is a letter or space
                    if(c >= 256) {
                        System.out.println("Text contains invalid characters, try again! \n");
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

            byte[] bytes = message.getBytes();
            StringBuilder binary = new StringBuilder();
            for(byte b : bytes) {
                int val = b;
                for (int i = 0; i < 8; i++)
                {
                    binary.append((val & 128) == 0 ? 0 : 1);
                    val <<= 1;
                }
                binary.append(' ');
            }

            System.out.println("Without huffman encoding: " + binary.toString());
            System.out.println("Saved " + ((float)encoded.length()-binary.toString().length())/encoded.length()*100 + "%");
            System.out.println("Huffman: " + encoded.length() + ", Reg: " + binary.toString().length());
        }
    }
}
