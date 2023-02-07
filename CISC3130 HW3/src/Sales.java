import java.util.*;
public class Sales {

    private String woodType;
    private int quantity;

    public Sales(String woodType, int quantity) {

        this.woodType = woodType;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    public String getWoodType() {
        return woodType;
    }
    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double price(){
    Random rand = new Random();
    int price = rand.nextInt(15);
    double markup = price *.4;

        return price+markup;
    }
    public String toString(){
        double price = price();
        return "Quantity: " + getQuantity() + " at " + price + " Sales: $"+ price*getQuantity()+"\n";
    }
}
