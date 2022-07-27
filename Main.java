class PriceTag {
    double COMMISION_MULTIPLIER = 0.05f;
    double BOTTOM_PRICE = 20000.0f;
    double BOTTOM_FEE = 1000.0f;
    double instancePrice;
    double discount;
    double tempPrice;

    PriceTag(double price, double discount) {
        instancePrice = price;
        discount = discount;
    }

    double getAdminFee(){
        tempPrice = DiscountedPrice();
        if(tempPrice < BOTTOM_PRICE){
            tempPrice = BOTTOM_FEE;
            return tempPrice;
        }
        return tempPrice * COMMISION_MULTIPLIER;
    }

    double DiscountedPrice(){
        if(discount > 100){
            discount = 100;
            return 0;
        }
        tempPrice = instancePrice - (instancePrice * discount/100);
        return tempPrice;
    }

    double getAdjustedPrice(){
        instancePrice = DiscountedPrice() + getAdminFee();
        return instancePrice;
    }
}


public class Main {
    public static void main(String[] args) throws Exception{
        PriceTag tag = new PriceTag(100000, 20);
        System.out.println("Harga akhir = " + tag.DiscountedPrice());
    }
}