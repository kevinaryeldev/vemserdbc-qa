import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero a ser adivinhado :");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        boolean acertou = false;
        int response;
        while (!acertou){
            System.out.println("Tente acertar o número:");
            response = sc.nextInt();
            sc.nextLine();
            if( response == num ){
                acertou = true;
                System.out.println("Parabéns, você acertou");
            } else {
                System.out.println("Infelizmente você errou");
                if( response > num){
                    System.out.println("O numero a ser encontrado é menor do que você digitou");
                } else {
                    System.out.println("O numero a ser encontrado é maior do que você digitou");
                }
            }
        }

    }
}
