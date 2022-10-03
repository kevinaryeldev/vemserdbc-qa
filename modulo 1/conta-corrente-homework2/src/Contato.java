public class Contato {
    String descricao;
    String telefone;
    int tipo;
    public void imprimirContato(){
        String text = "";
        switch (tipo){
            case 1-> text = "residencial";
            case 2 -> text = "comercial";
        }
        System.out.println("Contato: "+descricao+"\nTelefone "+text+": "+telefone);
    }
}
