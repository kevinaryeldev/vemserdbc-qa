import java.util.Scanner;

public class exercicio1 {
    public static void main(String[] args) {
        Scanner InputUsuario = new Scanner(System.in);
        System.out.println("Por favor digite seu nome:");
        String nome = InputUsuario.nextLine();
        System.out.println("Digite agora sua idade:");
        int idade = InputUsuario.nextInt();
        InputUsuario.nextLine();
        System.out.println("Digite a cidade em que você mora:");
        String cidade = InputUsuario.nextLine();
        System.out.println("E, para finalizar, o nome do estado que você mora:");
        String estado = InputUsuario.nextLine();
        System.out.println("\n Processando ...");
        System.out.println("Olá, seu nome é "+nome+" você tem "+idade+" anos, é da cidade de "
                +cidade+" situada no estado de "+estado+'.');
    }
}