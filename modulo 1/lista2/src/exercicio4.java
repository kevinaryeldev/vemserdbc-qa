import java.util.Scanner;

public class exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[20];
        for(int i = 0;i <20; i++){
            System.out.println("Digite um numero");
            numbers[i] = sc.nextInt();
            sc.nextLine();
        }
        System.out.println("----------------------");
        for(int i =19; i >=0; i--){
            System.out.println(numbers[i]);
        }
    }
}
