/*Code Analyze a list of words*/
import java.util.*;
import java.io.*;

public class AnalyzeWords {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();
        while(sc.hasNext()){
            list.add(sc.next());
        }

            Runnable averageLength = new AverageLength(list);
        Thread thread1 = new Thread(averageLength);
        thread1.start();

            Runnable longestLength = new LongestLength(list);
        Thread thread2 = new Thread(longestLength);
        thread2.start();

            Runnable mostUsedLetter = new MostUsedLetter(list);
        Thread thread3 = new Thread(mostUsedLetter);
        thread3.start();

}}






