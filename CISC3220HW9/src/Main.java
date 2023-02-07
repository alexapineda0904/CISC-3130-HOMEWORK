/*Code is created to do the hiring assistant problem*/
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String []args){

        int[] array = new int[5];
        int[] array2 = new int[5];
        int[] array3 = new int[5];
        int[] array4 = new int[5];
        int[] array5 = new int[5];

   array = RandomArray(array);
   array2 = RandomArray(array2);
   array3 = RandomArray(array3);
   array4 = RandomArray(array4);
   array5 = RandomArray(array5);
   System.out.println(Arrays.toString(array));
   System.out.println("Cost of hiring process is $"+HireAssistant(array)+"\n");
   System.out.println(Arrays.toString(array2));
   System.out.println("Cost of hiring process is $"+HireAssistant(array2)+"\n");
   System.out.println(Arrays.toString(array3));
   System.out.println("Cost of hiring process is $"+HireAssistant(array3)+"\n");
   System.out.println(Arrays.toString(array4));
   System.out.println("Cost of hiring process is $"+HireAssistant(array4)+"\n");
   System.out.println(Arrays.toString(array5));
   System.out.println("Cost of hiring process is $"+HireAssistant(array5)+"\n");
   




    }
    public static int []RandomArray(int [] arr){
        //Randomly creates numbers in an array
        Random rd = new Random();
        arr = new int[5];
        for(int i = 0; i<arr.length;i++){
            arr[i] = (int)(Math.random()*100 + 1);// numbers between 0-100
        }
        return arr;
    }
 public static int HireAssistant(int[] arr){
        int interview = 0;
        int cost;
        int sum = 0;
        int best = 0;
        int difference = 0;
        for(int i = 0; i < arr.length;i++){
            //cost of interview 1 dollar per candidate
            interview++;
         if(arr[i]>best){
             best = arr[i];
             cost = best-difference;// cost is the difference between candidates
             sum+=cost;// added to total process
             System.out.println("Candidate "+(i+1)+" is hired");
             difference = arr[i];// this will be the integer before the next
         }
        }
     sum+=interview;// adds the cost of interview process: 5

     return sum;
 }
}


