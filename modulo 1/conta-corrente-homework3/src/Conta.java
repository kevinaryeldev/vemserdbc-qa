abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;

    public Conta(Cliente cliente, String numeroConta, int agencia,double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public boolean sacar(double valor){
        if (saldo > valor && valor> 0){
            saldo -=valor;
            System.out.println("Saque de "+valor+" R$ feito com sucesso, novo saldo:"+saldo);
            return true;
        } else {
            System.out.println("Saque falhou.");
            return false;
        }
    };

    public boolean depositar(double valor){
        if (valor > 0){
            saldo +=valor;
            System.out.println("Depósito feito com sucesso, novo saldo:"+saldo);
            return true;
        } else {
            System.out.println("Falha durante depósito");
            return false;
        }
    }

    public boolean transferir(Conta conta, double valor){
        if (sacar(valor)){
            conta.depositar(valor);
            System.out.println("Transferecia feita com sucesso, novo saldo:"+saldo);
            return true;
        } else {
            System.out.println("Transferencia falhou.");
            return false;
        }
    };

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
