public class Receipt {

   private String woodType;
   private int quantity;
   private double price;

    public Receipt(String woodType,int quantity,double price) {
        this.woodType = woodType;
        this.quantity = quantity;
        this.price = price;
    }

    public String getWoodType() {
        return woodType;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        double markup = price*.4;
        return price+markup;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "Receipt Recorded  WoodType:"+getWoodType()+"\tQuantity:"+getQuantity()+"\t\tPrice: " +
                ""+ quantity*getPrice()+"\n";
    }


}
