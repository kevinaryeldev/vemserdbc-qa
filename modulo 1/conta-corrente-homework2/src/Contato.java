public class Contato {
    private String descricao;
    private String telefone;
    private int tipo;

    public  Contato (int tipo, String telefone, String descricao){
        this.tipo = tipo;
        this.telefone = telefone;
        this.descricao = descricao;
    }
    public void imprimirContato(){
        String text = "";
        switch (tipo){
            case 1-> text = "residencial";
            case 2 -> text = "comercial";
        }
        System.out.println("Contato: "+descricao+"\nTelefone "+text+": "+telefone);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
