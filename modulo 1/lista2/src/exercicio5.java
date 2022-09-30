import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args) {
        float[][] table = new float[5][4];
        String message;
        Scanner sc = new Scanner(System.in);
        float grade;
        for (float[] line : table){
            for (int i = 0; i<3;i++){
                switch (i){
                 case 0 -> message = "o numero de matricula";
                 case 1 -> message = "a media das provas";
                 case 2 -> message = " media dos trabalhos";
                 default -> message ="a nota final";
                }
                System.out.println("Digite "+message);
                line[i] = sc.nextInt();
                sc.nextLine();
            }
        }
        for (float[]line : table){
            float sumGrades =0f;
            for(int i = 1; i<4; i++){
            switch (i){
                case 1 -> sumGrades+= line[i]*0.6;
                case 2 -> sumGrades+= line[i]*0.4;
                case 3 -> line[i] = sumGrades;
            }
            }
        }
        float highestGrade= 0;
        float sumGrades = 0;
        float bestStudent = 0;
        for(int i = 0; i<5;i++){
            sumGrades+=table[i][3];
            if( table[i][3]> highestGrade){
                highestGrade = table[i][3];
                bestStudent = table[i][0];
            }
        }
        System.out.println("O aluno com a maior media final foi "+bestStudent+" com a nota "+highestGrade);
        System.out.println("A media das notas finais foi de "+(sumGrades/5));
    }
}

 /* print table :

 for (int[] line : table){
    int 1
 }



  */