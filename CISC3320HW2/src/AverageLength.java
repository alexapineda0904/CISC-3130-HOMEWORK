/* Finds the Average Length of all the words and prints it */
import java.io.*;
import java.util.ArrayList;

public class AverageLength implements Runnable{
private File file;

    public AverageLength(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    private ArrayList<String> list;
private double avg;


    @Override
    public void run() {
        double sum = 0;
        double count= 0;
        for(int i = 0; i<list.size();i++){
            String word = list.get(i);
            double wordcount = word.length();
            sum += wordcount;
            count++;

        }

        avg = sum/count;
        System.out.println("Average Length: " + avg);

    }




}
