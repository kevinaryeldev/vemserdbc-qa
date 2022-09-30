import java.util.Scanner;

public class exercicio2 {
    public static void main(String[] args) {
        Scanner inputUsuario = new Scanner(System.in);
        System.out.println("Selecione o código do estado que deseja:");
        System.out.println("1- Alagoas \n2- Bahia \n3- Ceará");
        int codigo = inputUsuario.nextInt();
        inputUsuario.nextLine();
        while (codigo > 3 || codigo < 1){
            System.out.println("Código inválido, digite novamente");
            codigo = inputUsuario.nextInt();
            inputUsuario.nextLine();
        }
        String capital = "";
        String abreviacao = "";
        float idh = 0f;
        String estado = "";
        switch (codigo){
            case 1 ->{
                estado = "Alagoas";
                capital = "Maceió";
                abreviacao = "AL";
                idh = 0.631f;
            }
            case 2 ->{
                estado = "Bahia";
                capital = "Salvador";
                abreviacao = "BA";
                idh = 0.631f;
            }
            case 3 ->{
                estado = "Ceará";
                capital = "Fortaleza";
                abreviacao = "CE";
                idh = 0.682f;
            }
        }
        System.out.println("O estado escolhido foi "+estado);
        System.out.println("Sua abreviação é "+abreviacao+" e sua capital é "+capital+"\nEm 2018 tinha o idh de "+idh);
    }
}
