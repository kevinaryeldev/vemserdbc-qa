import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        int[] vector = {10, 9, 8, 7, 4, 4, 3, 2, 11, 25};
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero que deseja pesquisar:");
        int number = sc.nextInt();
        sc.nextLine();
        int countLow = 0;
        int countHigh= 0;
        int count = 0;
        for(int element : vector){
            if (element == number){
                count++;
            } else {
                if (element > number){
                    countHigh++;
                }else {
                    countLow++;
                }
            }
        }
        System.out.println("O numero "+ number+ " aparece no vetor "+count+" vezes");
        System.out.println("O vetor tem "+countHigh+" numeros maiores que ele, e "+countLow+
                " numeros menores que ele");
    }
}
