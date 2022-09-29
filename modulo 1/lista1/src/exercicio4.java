public class exercicio4 {
    public static void main(String[] args) {
        int A = 10;
        int B = 20;
        int buffer = A;
        A = B;
        B = buffer;
        System.out.println("A variavel A agora é: "+A+" e a variavel B é: "+B);
    }
}
