    public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;

    public ContaCorrente(Cliente cliente,String numeroConta,int agencia,double saldo, double chequeEspecial){
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimir(){
        System.out.println("Detalhes da conta corrente n."+this.getNumeroConta()+"-"+this.getAgencia()+"\n");
        System.out.println("Cliente "+this.getCliente().getNome());
        System.out.println("Saldo: "+this.getSaldo());
        System.out.println("Limite do cheque especial: "+chequeEspecial+"\n\nFim dos Detalhes da conta corrente\n");
        this.getCliente().imprimirCliente();
    }

    @Override
    public boolean sacar(double valor){
        if (this.retornarSaldoComChequeEspecial() > valor && valor > 0){
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque realizado com sucesso, novo saldo:"+this.getSaldo()+" R$");
            return true;
        } else {
            System.out.println("Não foi possivel realizar o saque...");
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial(){
        return this.getSaldo()+chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}