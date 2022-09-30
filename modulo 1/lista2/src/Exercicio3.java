import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "";
        int count = 0;
        int sumHeight = 0;
        int maxHeight = 0;
        String oldest = "";
        int maxAge = 0;
        String heaviest = "";
        float maxWeight = 0;
        boolean execute = true;
        while (execute){
            System.out.println("Digite o nome do jogador, ou SAIR para fechar o programa :");
            name = sc.nextLine();
            switch (name){
                case "SAIR" -> {
                    execute = false;
                }
                default -> {
                    System.out.println("Digite a altura do jogador em centimetros:");
                    int currHeight = sc.nextInt();
                    sc.nextLine();
                    if (count == 0 || currHeight > maxHeight ){
                        maxHeight = currHeight;
                    }
                    sumHeight += currHeight;
                    System.out.println("Digite a idade do jogador:");
                    int age = sc.nextInt();
                    sc.nextLine();
                    if (count == 0 || age > maxAge ){
                        maxAge = age;
                        oldest = name;
                    }
                    System.out.println("Digite o peso do jogador em quilos:");
                    float weight = sc.nextFloat();
                    sc.nextLine();
                    if(count == 0 || weight > maxWeight){
                        maxWeight = weight;
                        heaviest = name;
                    }
                    count++;
                }
            }
        }
        if(count > 0){
            System.out.println("Foram cadastrados "+count+" jogadores");
            System.out.println("O jogador mais alto tem "+maxHeight+"cm, e a média de altura é de: "
                    +(sumHeight/count)+"cm");
            System.out.println("O jogador mais velho é "+oldest+" com "+maxAge+" anos");
            System.out.println("O jogador mais pesado é "+heaviest+" com "+maxWeight+"kg");
        }else {
            System.out.println("Ninguem foi adicionado!");
        }

    }
}
