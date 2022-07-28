import java.util.Scanner;

class PriceTag {
    double COMMISION_MULTIPLIER = 0.05;
    double BOTTOM_PRICE = 20000.0;
    double BOTTOM_FEE = 1000.0;
    double price;
    double discount;
    double tempPrice;
    PriceTag(double inputPrice, double inputDiscount) {
        price = inputPrice;
        discount = inputDiscount;
    }
    double getAdminFee(){
        tempPrice = 0;
        tempPrice = discountedPrice();
        if(tempPrice < BOTTOM_PRICE){
            tempPrice = BOTTOM_FEE;
            return tempPrice;
        }
        return tempPrice * COMMISION_MULTIPLIER;
    }
    double discountedPrice(){
        if(discount > 100){
            discount = 100;
            return 0;
        }
        tempPrice = price - (price * discount/100);
        return tempPrice;
    }
    double getAdjustedPrice(){
        tempPrice = 0;
        tempPrice = discountedPrice() + getAdminFee();
        return tempPrice;
    }
}

class Driver {
    int getPromo(){
        return 0;
    }
    String getCustomer(){
        return "oop";
    }
    float getDiscountPercentage(int before, int after){
        float selisih;
        float persen;
        if(before<after){
            return 0;
        }
        else {
            selisih = before - after;
            persen = (selisih / before) * 100;
            return persen;
        }
    }
    float getDiscountedPrice(int price, float discountedPercentage){
        if(discountedPercentage > 100){
            discountedPercentage = 100;
        }
        return price * ((100-discountedPercentage)/100);
    }

    float getOriginalPrice(int discountedPrice, float discountPercentage){
        if(discountedPrice < 0){
            return 0;


        }
        return (100/(100-discountPercentage))*discountedPrice;
    }
    double getCommissionMultiplier(){
        return 0.05;
    }

    double getAdjustedPrice(int price){
        double back;
        back = price + (price * 0.05);
        return back;
    }
    float getAdminFee(int price){
        return price * 0.05f;
    }

}

class ProductRating{
    int total, count;
    ProductRating(){
        total = 0;
        count = 0;
    }
    void insert(int rating){
        total += rating;
        count++;
    }
    double getAverage(){
        if(count <= 0){
            return 0;
        }
        return total/count;
    }
    int getCount(){
        return count;
    }

    int getTotal(){
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        //Class PriceTag
        System.out.println("Ngetes class PriceTag");
        PriceTag tag = new PriceTag(100000, 20);
        System.out.println("Harga admin = " + tag.getAdminFee());
        System.out.println("Harga akhir = " + tag.getAdjustedPrice());
        System.out.println("Harga terdiskon = " + tag.discountedPrice());

        //Class Driver
        System.out.println("\nNgetes class Driver");
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan harga awal = ");
        int harga = scan.nextInt();
        float diskon;
        System.out.print("Masukan harga akhir = ");
        int hargaDiskon = scan.nextInt();

        Driver gojek = new Driver();
        diskon = gojek.getDiscountPercentage(harga, hargaDiskon);
        System.out.println("Besar diskon = " + diskon);
        System.out.println("Harga yang didiskon = " + gojek.getDiscountedPrice(harga,diskon));
        System.out.println("Harga asli = " + gojek.getOriginalPrice(hargaDiskon, diskon));
        System.out.println("Harga setelah komisi = " + gojek.getAdjustedPrice(hargaDiskon));
        System.out.println("Besar komisi = " + gojek.getAdminFee(hargaDiskon));

        //Class ProductRating
        System.out.println("\nNgetes class ProductRating");
        ProductRating rate = new ProductRating();
        rate.insert(10);
        System.out.println("Rating saat ini = " + rate.getAverage());
        System.out.println("Count saat ini = " + rate.getCount());
        System.out.println("Total saat ini = " + rate.getTotal());
    }
}