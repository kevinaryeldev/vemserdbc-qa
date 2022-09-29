import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args) {
        Scanner InputUser = new Scanner(System.in);
        System.out.println("Digite o valor da base do retângulo:");
        int base = InputUser.nextInt();
        InputUser.nextLine();
        System.out.println("Digite o valor da altura do retângulo:");
        int altura = InputUser.nextInt();
        InputUser.nextLine();
        System.out.println("O valor da área é de: "+base*altura);
    }
}
