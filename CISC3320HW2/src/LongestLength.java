/*Code Finds the Longest Word in the list and prints it*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LongestLength implements Runnable{

private ArrayList<String> list;
 private String current;
 private String longestWord ="";


    public LongestLength(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public void run(){

        for(int i = 0;i<list.size();i++){
            current = list.get(i);
            if(current.length() > longestWord.length()){
                longestWord = current;
            }
        }
        System.out.println("Longest word's length: " + longestWord.length());

    }

}
