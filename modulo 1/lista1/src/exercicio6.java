import java.util.Scanner;

public class exercicio6 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Digite o numero de eleitores do municipio");
        float eleitores = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Digite o numero de votos brancos");
        float brancos = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Digite o numero de votos nulos");
        float nulos = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Digite o numero de votos validos");
        float validos = userInput.nextInt();
        userInput.nextLine();
        float brancosPercentual = (brancos*100/eleitores);
        float nulosPercentual = (nulos*100/eleitores);
        float validosPercentual = (validos*100/eleitores);
        System.out.println("O percentual de votos válidos foi de "+validosPercentual+
                "%\nO percentual de votos nulos foi de "+nulosPercentual+
                "%\nO percentual de votos brancos foi de "+brancosPercentual+'%');
    }
}
