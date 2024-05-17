package ExtraCredit;

import java.util.Scanner;

public class ExtraCredit {

    public ExtraCredit() {

    }


    public long binaryModularExponentiation(Byte[] byteArr, int base, int modNum) {

        return -1;
    }

    public void decimalToBinary() {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = -1;
        int exponent = 0;

        do {
            try {
                System.out.println("Please enter in a decimal: ");
                num = Integer.parseInt(in.nextLine());
                if(num <= 0)
                    System.out.println("Invalid input! Please try again.");
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
            }
        } while (num <= 0);


        //Finds the starting exponent
        while(Math.pow(2, exponent + 1) <= num) {
            exponent++;
        }

        //Iterates through all base 2 exponents to build the binary string
        for(int i = exponent; i >= 0; i--) {
            if( num - Math.pow(2, exponent) >= 0 ) {
                num -= Math.pow(2, exponent);
                sb.append("1");
            } else {
                sb.append("0");
            }
            exponent--;
        }

        System.out.println(sb.toString());
        in.close();
    }
}
