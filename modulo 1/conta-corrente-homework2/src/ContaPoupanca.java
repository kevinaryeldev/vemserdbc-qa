public class ContaPoupanca extends Conta implements Impressao {

    public ContaPoupanca(Cliente cliente, String numeroConta, int agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    private static final double JUROS_MENSAL =1.01;

    public void creditarTaxa(){
        this.setSaldo(this.getSaldo()* JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println("Detalhes da conta poupanca n."+this.getNumeroConta()+"-"+this.getAgencia()+"\n");
        System.out.println("Cliente "+this.getCliente().getNome());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Rendimento mensal da poupanca: "+JUROS_MENSAL+"\n\nFim dos Detalhes da conta corrente\n");
        this.getCliente().imprimirCliente();
    }
}
