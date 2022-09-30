import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner inputUsuario = new Scanner(System.in);
        System.out.println("Selecione o código do estado que deseja:");
        System.out.println("1- Alagoas \n2- Bahia \n3- Ceará");
        int codigoEstado = inputUsuario.nextInt();
        int codigoCidade;
        inputUsuario.nextLine();
        while (codigoEstado > 3 || codigoEstado < 1){
            System.out.println("Código inválido, digite novamente");
            codigoEstado = inputUsuario.nextInt();
            inputUsuario.nextLine();
        }
        String city = "";
        float idh = 0f;
        String area = "";
        String population = "";
        String estado = "";
        switch (codigoEstado) {
            case 1 -> {
                estado = "Alagoas";
                System.out.println("Agora escolha o código da cidade, 1 para Maceió ou 2 para Arapiraca.");
                codigoCidade = inputUsuario.nextInt();
                inputUsuario.nextLine();
                switch (codigoCidade) {
                    case 1 -> {
                        city = "Maceió";
                        idh = 0.735f;
                        population = "1.031.597";
                        area = "509.320";
                    }
                    case 2 -> {
                        city = "Arapiraca";
                        idh = 0.649f;
                        population = "234.309";
                        area = "345.655";
                    }
                }
            }
            case 2 -> {
                estado = "Bahia";
                System.out.println("Agora escolha o código da cidade, 1 para Salvador ou 2 para Feira de Santana.");
                codigoCidade = inputUsuario.nextInt();
                inputUsuario.nextLine();
                switch (codigoCidade) {
                    case 1 -> {
                        city = "Salvador";
                        idh = 0.759f;
                        population = "2.900.319";
                        area = "693.453";
                    }
                    case 2 -> {
                        city = "Feira de Santana";
                        idh = 0.712f;
                        population = "624.107";
                        area = "1.304.425";
                    }
                }
            }
            case 3 -> {
                estado = "Ceará";
                System.out.println("Agora escolha o código da cidade, 1 para Fortaleza ou 2 para Juazeiro do Norte.");
                codigoCidade = inputUsuario.nextInt();
                inputUsuario.nextLine();
                switch (codigoCidade) {
                    case 1 -> {
                        city = "Fortaleza";
                        idh = 0.754f;
                        population = "2.703.391";
                        area = "312.353";
                    }
                    case 2 -> {
                        city = "Juazeiro do Norte";
                        idh = 0.694f;
                        population = "278.264";
                        area = "258.788";
                    }
                }
            }
        }
        System.out.println("O estado escolhido foi "+estado);
        System.out.println("A cidade escolhida foi "+city+", ela tem uma população de "+population+
                " habitantes, sua area territorial é de "+area+"km² e o idhm de "+idh);
    }
}