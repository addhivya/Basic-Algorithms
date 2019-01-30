package Ques;
import java.util.Scanner;

public class Vowels {

    public static void main(String args[]) {
        System.out.print("Please Enter the Sentence : ");
        Scanner s = new Scanner(System.in);
        StringBuffer buf=new StringBuffer();
        String line = s.nextLine();
        String res = "";
        char[] len = line.toCharArray();
        for (int i = 0; i < len.length; i++) {
            Boolean Isvowel = false;
            switch (len[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    Isvowel = true;
            }
            if (!Isvowel) {
              //  res = res + len[i];
                buf.append(len[i]);
            }
        }
        System.out.println(buf);

    }
}
