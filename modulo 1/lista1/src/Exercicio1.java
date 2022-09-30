import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        System.out.println("Por favor digite seu nome:");
        String name = inputUser.nextLine();
        System.out.println("Digite agora sua idade:");
        int age = inputUser.nextInt();
        inputUser.nextLine();
        System.out.println("Digite a cidade em que você mora:");
        String city = inputUser.nextLine();
        System.out.println("E, para finalizar, o nome do estado que você mora:");
        String state = inputUser.nextLine();
        System.out.println("\n Processando ...");
        System.out.println("Olá, seu nome é "+name+" você tem "+age+" anos, é da cidade de "
                +city+" situada no estado de "+state+'.');
    }
}