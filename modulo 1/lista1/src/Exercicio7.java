import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Digite o código do produto");
        String code = userInput.nextLine();
        System.out.println("Digite a quantidade comprada");
        int quantity = userInput.nextInt();
        userInput.nextLine();
        float result = 0f;
        switch (code){
            case "ABCD" -> result = 5.30f*quantity;
            case "XYPK" -> result = 6.00f*quantity;
            case "KLMP" -> result = 3.20f*quantity;
            case "QRST" -> result = 2.50f*quantity;
            default -> System.out.println("Código inválido");
        }
        if (result > 0 ){
            System.out.println("O preço total é de: "+result+ "reais");
        }
    }
}
