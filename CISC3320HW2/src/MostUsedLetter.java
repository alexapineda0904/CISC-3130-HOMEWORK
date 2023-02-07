/*Code finds the most used letter n a list*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostUsedLetter implements Runnable{

private ArrayList<String>list;

    public MostUsedLetter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        ArrayList<Character> c = new ArrayList<>();
        for(int i = 0 ; i < list.size();i++){
            String word = list.get(i);
            char[] chars = word.toCharArray();
            for(char y: chars){
                c.add(y);
            }
        }
        HashMap<Character, Integer> frequency = new HashMap();
        for (char y:c) {
            if(frequency.containsKey(y)){
                frequency.put(y,frequency.get(y)+1);
            }
            else{
                frequency.put(y,1);
            }

        }
        Map.Entry<Character, Integer> maxEntry = null;

        for (Map.Entry<Character, Integer> entry : frequency.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        System.out.println("Most Frequent Letter: "+maxEntry.getKey());

    }
}
