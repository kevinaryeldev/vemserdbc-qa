public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public void imprimirContaCorrente(){
        System.out.println("Detalhes da conta corrente n."+numeroConta+"-"+agencia+"\n");
        System.out.println("Cliente "+cliente.nome);
        System.out.println("Saldo: "+saldo);
        System.out.println("Limite do cheque especial: "+chequeEspecial+"\n\nFim dos Detalhes da conta corrente\n");
        this.cliente.imprimirCliente();
    }

    public boolean sacar(double valor){
        if (this.retornarSaldoComChequeEspecial() > valor && valor > 0){
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso, novo saldo:"+saldo+" R$");
            return true;
        } else {
            System.out.println("Não foi possivel realizar o saque...");
            return false;
        }
    }

    public boolean depositar(double valor){
        if (valor > 0){
            this.saldo +=valor;
            System.out.println("Depósito realizado com sucesso, novo saldo:"+saldo+" R$");
            return true;
        }else {
            System.out.println("Nao se pode depositar valores negativos...");
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial(){
        return saldo+chequeEspecial;
    }

    public boolean transferir(ContaCorrente conta,double valor){
        if (retornarSaldoComChequeEspecial() > valor && valor > 0){
            saldo -= valor;
            conta.saldo+=valor;
            return true;
        }else {
            System.out.println("Não foi possivel realizar a transferência");
            return false;
        }
    }
}