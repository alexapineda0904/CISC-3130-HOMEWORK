/* Code should read in text file into an array, it then calculates
*  The average of all numbers in array. Code also creates of an array of
* numbers that is the difference between each index and the previous average
* it will then print the array, and it's average
* */


import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
    public static void main(String[]args)throws FileNotFoundException {
       int n=0;
       double[]array = new double[0];
       array = readData(n,array);
       printArray(n,array);
       double average = findAverage(n,array);
       System.out.printf("Average of all numbers in array: %3.2f%n",average);
       double[]array2 = new double[0];
       array2 = howFarAway(n,average,array,array2);
       printArray(n,array2);
       System.out.printf("Average of all numbers in array2: %3.2f%n",findAverage(n,array2));


    }
    public static double[] readData(int n, double[] numbers) throws FileNotFoundException {
        File file = new File("src/numbers.txt");
        Scanner sc = new Scanner(file);
         n=0;
        while(sc.hasNext()){
            double z = sc.nextDouble();
            n++;
        }sc.close();
        numbers = new double[n];
        sc = new Scanner(file);
        int i =0;
        while(sc.hasNext()){
            numbers[i]=sc.nextDouble();
            i++;
        }sc.close();
        return numbers;
    }
    public static void  printArray(int q, double[] numb) {
        DecimalFormat df = new DecimalFormat("#.##");
       for(q = 0;q < numb.length; q++){

           if(q % 5==0)//if 5 values have been printed starting from 0 then it
               System.out.println();//will create a new line and // continue printing the next 5 lines

           System.out.print(df.format(numb[q])+"  ");        //prints array value then tab
       }System.out.println();
        }
    public static double findAverage(int k, double[]p) {
    double sum = 0;
        for(k=0; k<p.length;k++) {
            sum += p[k]; //sum will add all the values in the array and
        }
        double average = sum/p.length;

return  average;
    }
    public static double[] howFarAway ( int m, double avg, double[] r, double[] s){
   for( m = 0; m < r.length; m++){
      m++;
   }
   s = new double[m];

   for (int i = 0; i < s.length-1; i++){
        s[i] =r[i]-avg;
   }
   return s;
    }
    }
