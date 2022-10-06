import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Contato> contatos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente (String nome, String cpf){
    this.nome = nome;
    this.cpf = cpf;
    }

    public void imprimirContatos(){
        System.out.println("Contatos do cliente "+nome+":\n");
        if (contatos != null){
            for (Contato i : contatos) {
                if (i != null){
                    i.imprimirContato();
                }
            }
            System.out.println("Fim dos contatos\n");
        }
    }

    public  void imprimirEnderecos(){
        System.out.println("Enderecos do cliente "+nome+":\n");
        if (contatos != null){
            for (Endereco i : enderecos){
                if (i != null){
                    i.imprimirEnderecos();
                }
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

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(Contato contato, int index) {
        if (index > contatos.size()-1 || contatos.size() == 0 ){
            contatos.add(contato);
        }
        if( index <= contatos.size()-1 && index >=0) {
            contatos.set(index, contato);
        }
    }

    public void setContatos(Contato contato){
        contatos.add(contato);
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco endereco, int index) {
        if (index > enderecos.size()-1 || contatos.size() == 0){
            enderecos.add(endereco);
        } else if( index <= enderecos.size()-1 && index >=0){
            enderecos.set(index, endereco);
        }
    }

    public void  setEnderecos(Endereco endereco){
        enderecos.add(endereco);
    }

}
