import java.util.*;
import java.io.*;
public class ReplacePage {
    public static void main (String[]args){
       String tRefString ="70120304230321201701";
       String tRefString2 = "123412512345";
       int frame = 3;
       int frame2 = 4;
       System.out.println("FIFO");
       System.out.println("Test String: "+ tRefString + " with 3 pages");
       FIFO(tRefString,frame);
        System.out.println("LRU");
       System.out.println("Test String: "+ tRefString + " with 3 pages");
       LRU(tRefString,frame2);
        System.out.println("FIFO");
       System.out.println("Test String: "+ tRefString2 + " with 3 pages");
       FIFO(tRefString2,frame);
       System.out.println("Test String: "+ tRefString2 + " with 4 pages");
       FIFO(tRefString2,frame);

    }
  public static void FIFO(String testRef, int f){
  char c[] = new char[testRef.length()];
 for(int q = 0; q <c.length;q++)
     c[q] = testRef.charAt(q);

String str[]  = new String[testRef.length()];
String frames[] = new String[f];
for(int i = 0; i < str.length;i++)
    str[i] = testRef.substring(i, i+1);
for(int i = 0; i < frames.length; i++)
    frames[i] = "";
int page = 0,x=0,y=0;
while(x<str.length){
    while(y < frames.length){
  if(compare(frames, str[x])==true){
      System.out.println(c[x]+": ");
      x++;
      if(x == str.length)
          y = frames.length;
  }
  else{
      frames[y] = str[x];
     System.out.print(c[x]+": ");
      for(int i = 0; i < frames.length;i++){
          System.out.print(frames[i]);}
System.out.println();

      x++;
      y++;
      page++;
      if(x==str.length)
          y = frames.length;
  }

    } y=0;

}

System.out.println("Total FIFO page fault:"+ page);

  }
  public static void LRU(String testRef, int f){
      char c[] = new char[testRef.length()];
      for(int q = 0; q <c.length;q++)
          c[q] = testRef.charAt(q);

      String str[]  = new String[testRef.length()];
      String frames[] = new String[f];
      String LRU[] = new String[f];
      for(int i = 0; i < str.length;i++)
          str[i] = testRef.substring(i, i+1);
      for(int i = 0; i < frames.length; i++){
          frames[i] = "";
          LRU[i] = "";
      }
      int page = 0,x=0,y=0;
      while(x<str.length){
          while(y < frames.length){
              if(compare(frames, str[x])==true){
                  System.out.println(c[x]+": ");
                  LRU[0] = LRU[1];
                  LRU[1] = LRU[2];
                  LRU[2] = str[x];
                  x++;
                  if(x == str.length)
                      y = frames.length;
              else if(compare(LRU,frames[y])==true){
                      LRU[0] = LRU[1];
                      LRU[1] = LRU[2];
                      LRU[2] = str[x];
                      y++;
                  }
              }
              else{
                  LRU[0] = LRU[1];
                  LRU[1] = LRU[2];
                  LRU[2] = str[x];
                  frames[y] = str[x];
                  System.out.print(c[x]+": ");
                  for(int i = 0; i < frames.length;i++){
                      System.out.print(frames[i]);}
                  System.out.println();

                  x++;
                  y++;
                  page++;
                  if(x==str.length)
                      y = frames.length;
              }
          } y=0;
      }
      System.out.println("Total LRU page fault:"+ page);
  }
  public static boolean compare(String[] arr, String str) {

      for (int i = 0; i < arr.length; i++)
          if (str.compareTo(arr[i])==0)
              return true;

              return false;

  }
}
