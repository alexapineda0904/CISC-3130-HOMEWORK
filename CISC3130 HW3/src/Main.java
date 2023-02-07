/* Code Reads in a file into an array and then seperates and categorizes each index by letter.
* Prints out when a receipt has been read, wood type,quantity and price.
* Calculates the sales at a randomized cost then calculates and prints the sales.
* At the end the quantity of thw wood type is posted*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args) throws FileNotFoundException {
        List<Receipt> receipt = new LinkedList<>();
        List<Promotion> promotion = new LinkedList<>();
        List<Sales> sales = new LinkedList<>();
        File file = new File("src/data.txt");
        Scanner sc = new Scanner(file);
        String[] array;
        String woodType;
        int quantity;
        double price;
        String code;
        int percentOff;
        int oakWoodQuantity = 1000;
        int cherryMapleWoodQuantity = 1500;


        while (sc.hasNextLine()) {
            array = sc.nextLine().split("\\s+");
            code = array[0];


            switch (code) {
                case "R":
                    woodType = array[1];
                    quantity = Integer.parseInt(array[2]);
                    price = Double.parseDouble(array[3]);

                    receipt.add(new Receipt(woodType, quantity, price));


                    break;
                case "S":
                    woodType = array[1];
                    quantity = Integer.parseInt(array[2]);



                    sales.add(new Sales(woodType, quantity));

                    break;
                case "P":
                    percentOff = Integer.parseInt(array[1]);

                    promotion.add(new Promotion(percentOff));
                    break;
            }

        }
        for (Receipt r : receipt) {
            System.out.print(r);
        }
        int sum = 0;
        for (Sales s : sales) {
            sum += s.getQuantity();
            switch (s.getWoodType()){
                case "O":
                    oakWoodQuantity -= s.getQuantity();

                    break;
                case "C":
                    cherryMapleWoodQuantity -= s.getQuantity();
                    break;
            }
        }
        System.out.println("\nAmount of widgets sold:" + sum+"\n");
        double totalSale=0;
        int q = 0;
        for (Sales s2:sales){
            q+=s2.getQuantity();
            totalSale+=s2.price();
            System.out.print(s2);
        }
        if(oakWoodQuantity < 0){
            System.out.println("Remainder of " + oakWoodQuantity * -1+" pieces of Oak Wood not available");
        }
        if(cherryMapleWoodQuantity < 0){
            System.out.println("Remainder of " + cherryMapleWoodQuantity * -1 +" pieces of Cherry Maple Wood not available");
        }
        totalSale *= q;
        System.out.println("Total Sales:$"+ totalSale);
        System.out.println("\nQuantity of Oak Wood left: "+ oakWoodQuantity);
        System.out.println("Quantity of Cherry Maple Wood left: "+ cherryMapleWoodQuantity);



    }
}
