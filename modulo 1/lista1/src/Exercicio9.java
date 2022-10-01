import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Digite a hora de inicio:");
        int horaInicio = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Digite o minuto de inicio:");
        int minutoInicio = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Digite a hora de término:");
        int horaTermino = userInput.nextInt();
        userInput.nextLine();
        System.out.println("Digite o minuto de término:");
        int minutoTermino = userInput.nextInt();
        userInput.nextLine();
        int resultMinuto = 0;
        int resultHora = 0;
        boolean virouDia = false;
        //calculo de minutos
        if (minutoInicio > minutoTermino) {
            resultMinuto += 60 - minutoInicio;
            minutoInicio = 0;
            horaInicio++;
        }
        if (minutoInicio < minutoTermino) {
            resultMinuto += minutoTermino - minutoInicio;
        }
        if (horaInicio > 24) {
            horaInicio -= 24;
            virouDia = true;
        }
        if (horaInicio > horaTermino) {
            resultHora += 24 - horaInicio;
            virouDia = true;
            horaInicio = 00;
        }
        if (horaInicio < horaTermino) {
            resultHora += horaTermino - horaInicio;
        }
        System.out.println("O jogo acabou depois de  " + resultHora + " horas e " + resultMinuto + " minutos");
        if (virouDia == true) {
            System.out.println("O jogo virou o dia!!");
        }
    }
}