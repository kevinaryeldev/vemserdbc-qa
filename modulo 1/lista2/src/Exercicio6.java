public class Exercicio6 {
    public static void main(String[] args) {
        int[][] table = {
                {5,5,5,5},
                {4,4,4,4},
                {10,10,10,10},
                {8,8,8,8},
                {9,9,9,9},
        };
        float[] finalGrades = {0,0,0,0,0};
        for(int i = 0; i <5; i++ ){
            int sumGrade = 0;
            for (int element : table[i]){
                sumGrade+= element;
            }
            finalGrades[i] = sumGrade/4;
        }
        float finalGradeTotal = 0;
        for(float element: finalGrades){
            finalGradeTotal+=element;
        }
        finalGradeTotal/=5;
        System.out.println("A média das disciplinas é:");
        for(int i = 0; i<5; i++){
            System.out.println("Disciplina "+(i+1)+": média ="+finalGrades[i]);
        }
        System.out.println(" A média geral das disciplinas é de: "+finalGradeTotal);
    }
}
