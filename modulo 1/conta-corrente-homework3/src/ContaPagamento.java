public class ContaPagamento extends Conta implements Impressao {

    public ContaPagamento(Cliente cliente, String numeroConta, int agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    final double TAXA_SAQUE = 4.25;

    @Override
    public boolean sacar(double valor){
        if (getSaldo()-TAXA_SAQUE > valor && valor> 0){
            setSaldo(getSaldo()-valor-TAXA_SAQUE);
            System.out.println("Saque de "+valor+" R$ feito com sucesso, novo saldo:"+getSaldo());
            return true;
        } else {
            System.out.println("Saque falhou.");
            return false;
        }
    }

    public void imprimir(){
        System.out.println("Detalhes da conta de pagamento n."+this.getNumeroConta()+"-"+this.getAgencia()+"\n");
        System.out.println("Cliente "+this.getCliente().getNome());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Taxa de saque atual: "+TAXA_SAQUE+"\n\nFim dos Detalhes da conta corrente\n");
        this.getCliente().imprimirCliente();
    }

    @Override
    public boolean transferir(Conta conta,double valor){
        if (super.sacar(valor)){
            conta.depositar(valor);
            System.out.println("Transferencia feita com sucesso, novo saldo:"+getSaldo());
            return true;
        } else {
            System.out.println("Não foi possivel transferir "+valor+" para "+conta.getCliente().getNome());
        }
        return false;
    };
}
