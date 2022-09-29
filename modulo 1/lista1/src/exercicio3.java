import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);
        System.out.println("Digite a Palavra que queira traduzir");
        String word = UserInput.nextLine();
        String result = null;
        while (result == null){
            switch (word){
                case "Cachorro"-> result = "Dog";
                case "Dog" -> result ="Cachorro";
                case "Tempo" -> result = "Time";
                case "Time" -> result = "Tempo";
                case "Amor" -> result = "Love";
                case "Love" -> result = "Amor";
                case "Cidade" -> result = "City";
                case "City" -> result = "Cidade";
                case "Feliz" -> result = "Happy";
                case "Happy" -> result = "Feliz";
                case "Triste" -> result = "Sad";
                case "Sad" -> result = "Triste";
                case "Deveria" -> result = "Should";
                case "Should" -> result = "Deveria";
                case "Poderia" -> result = "Could";
                case "Could" -> result = "Poderia";
                default -> {
                    System.out.println("Essa palavra não é valida, por favor digite outra: ");
                    word = UserInput.nextLine();
                }
            }
        }
        System.out.println("A tradução da palavra é: "+result);
        }
}
