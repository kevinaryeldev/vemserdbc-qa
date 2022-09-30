import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Digite o valor da base do retângulo:");
        int base = inputUser.nextInt();
        inputUser.nextLine();
        System.out.println("Digite o valor da altura do retângulo:");
        int altura = inputUser.nextInt();
        inputUser.nextLine();
        System.out.println("O valor da área é de: "+base*altura);
    }
}
