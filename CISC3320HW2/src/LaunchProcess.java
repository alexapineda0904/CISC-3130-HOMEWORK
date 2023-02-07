/*Code launches AnalyzeWords.java along with a text file*/
import java.io.*;
public class LaunchProcess {
    public static void main(String[]args) throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("Launching Process...");
        Process p = Runtime.getRuntime().exec(" java AnalyzeWords english_words.txt");
        BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = is.readLine()) != null){
            System.out.println(line);}

        long finishTime = System.currentTimeMillis();
        long totalTime = (finishTime-startTime);
        System.out.println("Time it takes to finish tasks: "+ totalTime +"ms");
    }


}
