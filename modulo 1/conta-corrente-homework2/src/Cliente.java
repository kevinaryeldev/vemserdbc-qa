public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente (String nome, String cpf){
    this.nome = nome;
    this.cpf = cpf;
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato contato, int index) {
        this.contatos[index] = contato;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco endereco, int index) {
        this.enderecos[index] = endereco;
    }
}
