public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEnderecos(){
        String text ="";
        switch (tipo){
            case 1-> text = "residencial";
            case 2 -> text = "comercial";
        }
        System.out.println("Endereço "+text+":\n"+logradouro+
                ", "+numero+"\n"+complemento+"\n"+cep+" "+cidade+
                "/"+estado+" "+pais+"\n");
    }
}
