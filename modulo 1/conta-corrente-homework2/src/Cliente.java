public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos(){
        System.out.println("Contatos do cliente "+nome+":\n");
        for (Contato i : contatos) {
            if (i != null){
                i.imprimirContato();
            }
        }
        System.out.println("Fim dos contatos\n");
    }

    public  void imprimirEnderecos(){
        System.out.println("Enderecos do cliente "+nome+":\n");
        for (Endereco i : enderecos){
            if (i != null){
                i.imprimirEnderecos();
            }
        }
        System.out.println("\nFim dos endereços\n");
    }

    public void imprimirCliente(){
        System.out.println("\n\nImprimindo Dados do Cliente:\n");
        System.out.println("Dados do cliente:");
        System.out.println("Cliente "+nome+"\nCPF: "+cpf+"\n---------------------");
        this.imprimirContatos();
        this.imprimirEnderecos();
    }
}
