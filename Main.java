import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.print("Pick a number between 1 to 10: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if(input <= 5){
            System.out.println("Hoki");
        }
        else{
            System.out.println("Bapak kau");
        }
    }
}
