public class Exercicio7 {
    public static void main(String[] args) {
        float table[][] = {
                {7,7,7,7,7,7,7,7,7,7},
                {5,5,5,5,5,5,5,5,5,5},
                {6,6,6,6,6,6,6,6,6,6},
        };
        float[] totalValues = {0,0,0};
        float minValue = 0;
        int bestPlace = 0;
        for (int i = 0; i < 3; i++) {
            float valueBuffer = 0;
            for (float element : table[i]) {
                valueBuffer += element;
            }
            totalValues[i] = valueBuffer;
            if (i == 0 || valueBuffer < minValue){
                minValue = valueBuffer;
                bestPlace = i+1;
            }
        }
        if (bestPlace == 0 ){
            System.out.println("ERRO");
        }else {
            System.out.println("O mercado mais barato é o mercado "+bestPlace);
//            System.out.println(totalValues[0]+" "+totalValues[1]+" "+ totalValues[2]);
        }
    }
}
