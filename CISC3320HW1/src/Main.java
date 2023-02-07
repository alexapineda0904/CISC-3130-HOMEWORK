/*Code Prompts user to input file it, if file does not exist it will display a message
 and terminate the code. If file is found then it will prompt the user for an outfile
file 1 contains non-ASCII characters. It will then count the non-ASCII characters and delete it,
Printing out text without non-ASCII characters, number of lines and number of non-ASCII characters*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        String inputFile;
        String outputFile;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter input File name");
        inputFile = sc.nextLine();//test.txt
        System.out.println("Enter output File name");
        outputFile = sc.nextLine();//outfile.txt

        try {
            int count = 0;
            int nonASCII = 0;
            File file = new File (inputFile);
            Scanner read = new Scanner(file);
            PrintWriter write = new PrintWriter(new File(outputFile));
            while(read.hasNextLine()){
                String data = read.nextLine();

                for(int i=0;i<data.length();i++){
                    char a = data.charAt(i);

                    if(Character.isLetter(a) == false && a !=' '){
                        nonASCII++;
                        data = data.replace(a, ' ');
                    }
                }

                write.write(data+"\n");
                count++;

            }
            write.println("\nAmount of lines printed: "+count);
            write.println("\nAmount of nonASCII characters:"+nonASCII);
            write.flush();
            write.close();


        } catch (Exception e) {
            System.out.println("File not found");

        }
    }
}
