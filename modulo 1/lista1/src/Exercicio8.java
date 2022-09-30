import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Digite o código de cargo do colaborador");
        int code = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Digite o salário do colaborador");
        float oldSalary = userInput.nextFloat();
        userInput.nextLine();
        String cargo;
        float factor;
        switch (code){
            case 101 -> {
                cargo = "Gerente";
                factor = 1.1f;
            }
            case 102 -> {
                cargo = "Engenheiro";
                factor = 1.2f;
            }
            case 103 -> {
                cargo = "Tecnico";
                factor = 1.3f;
            }
            default -> {
                cargo = "Outro";
                factor = 1.4f;
            }
        }
        System.out.println("O funcionário com cargo "+cargo+" recebia antes "+oldSalary+
                " reais, e depois do aumento receberá "+oldSalary*factor+" reais, uma diferença de ");
    }
}
