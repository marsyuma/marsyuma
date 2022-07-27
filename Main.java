import java.util.Scanner;

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
public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan harga awal= ");
        int harga = scan.nextInt();
        float diskon;
        System.out.print("Masukan harga akhir= ");
        int hargaDiskon = scan.nextInt();

        Driver gojek = new Driver();
        diskon = gojek.getDiscountPercentage(harga, hargaDiskon);
        System.out.println("Besar diskon = " + diskon);
        System.out.println("Harga yang didiskon = " + gojek.getDiscountedPrice(harga,diskon));
        System.out.println("Harga asli = " + gojek.getOriginalPrice(hargaDiskon, diskon));
        System.out.println("Harga setelah komisi = " + gojek.getAdjustedPrice(hargaDiskon));
        System.out.println("Besar komisi = " + gojek.getAdminFee(hargaDiskon));


    }
}
