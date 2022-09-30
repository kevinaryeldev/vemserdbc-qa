import java.util.Scanner;

public class exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String name = sc.nextLine();
        System.out.println("Digite o valor do produto:");
        float price = sc.nextFloat();
        sc.nextLine();
        System.out.println("Produto.: "+name+"\nPreço R$.: "+price+"\n\nPromoção: "+name+"\n---------------");
        for(int i=1;i<=10;i++){
            float discountPrice = (1-(i*0.05f))*price;
            System.out.println(i+" x R$ "+discountPrice+" = R$ "+(discountPrice*i));
        }
    }
}