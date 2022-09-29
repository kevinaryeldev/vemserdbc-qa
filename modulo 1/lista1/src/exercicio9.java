import java.util.Scanner;

public class exercicio9 {
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);
        System.out.println("Digite a hora de inicio:");
        int horaInicio = UserInput.nextInt();
        UserInput.nextLine();
        System.out.println("Digite o minuto de inicio:");
        int minutoInicio = UserInput.nextInt();
        UserInput.nextLine();
        System.out.println("Digite a hora de término:");
        int horaTermino = UserInput.nextInt();
        UserInput.nextLine();
        System.out.println("Digite o minuto de término:");
        int minutoTermino = UserInput.nextInt();
        UserInput.nextLine();
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
        if (resultMinuto > 60) {
            resultMinuto -= 60;
            resultHora++;
        }
        if (horaInicio > 24) {
            horaInicio -= 24;
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
