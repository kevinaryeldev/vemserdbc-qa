import java.util.Scanner;

public class exercicio10 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Digite o código do aluno:");
        int code = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Digite a primeira nota:");
        float n1 = userInput.nextFloat();
        userInput.nextLine();
        System.out.println("Digite a segunda nota:");
        float n2 = userInput.nextFloat();
        userInput.nextLine();
        System.out.println("Digite a terceira nota:");
        float n3= userInput.nextFloat();
        userInput.nextLine();
        System.out.println("Digite a média dos exercícios:");
        float n4 = userInput.nextFloat();
        userInput.nextLine();
        float mApr = (n1+n2*2+n3*3+n4)/7;
        char conceito;
        String situation;
        if(mApr >= 9){
            conceito ='A';
            situation = "APROVADO";
        } else if (mApr >= 7.5f){
            conceito ='B';
            situation = "APROVADO";
        } else if (mApr >= 6) {
            conceito ='C';
            situation = "APROVADO";
        } else if (mApr >= 4){
            conceito = 'D';
            situation = "REPROVADO";
        } else {
            conceito ='E';
            situation = "REPROVADO";
        }
        System.out.println("O aluno cod: "+code+" com as notas:\n" +
                "Atividade 1 = "+n1+ "\nAtividade 2 = "+n2+"\nAtividade 3 = "
                +n3+"\nMédia exercícios = "+n4+"\nFicou com Média de aproveitamento igual a :"+mApr+
                "\nTeve, portanto, conteito "+conceito+"\nAluno "+situation);
    }
}
