public class Main {
    public static void main(String[] args) {

        //Primeiro Cliente: ------------------------------------------------------

        //Criando os contatos do primeiro cliente

        //Primeiro contato:

        Contato telefoneCasaKevin = new Contato(1,"4002-8922","Meu número");

        Contato telefoneTrabalhoKevin = new Contato(2,"0800 777 7000",
                "Telefone de trabalho tecpix");

        //Criando endereço do primeiro cliente

        //Primeiro endereço

        Endereco enderecoKevin = new Endereco(1,"Rua bacanudona",
                1337,"Logo Ali", "41577-700", "Salvador",
                "Bahia","Brasil");

        //Criando o primeiro cliente

        Cliente kevin = new Cliente("Kevin Aryel","888.888.888-88");
        kevin.setEnderecos(enderecoKevin,0);
        kevin.setContatos(telefoneCasaKevin, 0);
        kevin.setContatos(telefoneTrabalhoKevin,1);

        //Criando a primeira conta corrente:

        ContaCorrente contaKevin = new ContaCorrente(Kevin,"1000",
                388,2500.45,700);

        // Criando a primeira conta pagamento:

        ContaPagamento pagamentoKevin = new ContaPagamento(Kevin,"1001",388,600);


        // Segundo Cliente: ----------------------------------------------------------

        //Criando os contatos do segundo cliente:

        //Primeiro Contato:

        Contato telefoneCasaJosenildo = new Contato(1,"5555-4955",
                "Numero do Josenildo");


        //Criando endereço da segundo cliente:

        //Primeiro endereço:

        Endereco enderecoJosenildo = new Endereco(1, "Rua João pé de feijão",
                142,"Perto do bar do zé","75643-700","Salinas da Margarida",
                "Bahia", "Brasil");

        //Segundo endereço:

        Endereco enderecoJosenildoTrabalho = new Endereco(2,"Rua torta",1467,
                "Ao lado do shopping", "55455-78","Nazaré das Farinhas",
                "Bahia", "Brasil");

        //Criando o segundo cliente

        Cliente josenildo = new Cliente("Josenildo Silveira","456.376.893-99");
        josenildo.setEnderecos(enderecoJosenildo,0);
        josenildo.setEnderecos(enderecoJosenildoTrabalho,1);
        josenildo.setContatos(telefoneCasaJosenildo,0);

        // Criando a conta poupanca:

        ContaPoupanca poupancaJosenildo = new ContaPoupanca(josenildo, "2001",
                388,100);

        System.out.println("Saldo Kevin: "+pagamentoKevin.getSaldo());
        pagamentoKevin.sacar(10);
        System.out.println("Saldo deve estar em 585.75, Saldo:"+pagamentoKevin.getSaldo());
        pagamentoKevin.transferir(contaKevin,500);
        System.out.println("Saldo deve estar em 85.75, Saldo:"+pagamentoKevin.getSaldo());
        System.out.println("Saldo deve estar em 3000.45, Saldo:"+contaKevin.getSaldo());
        System.out.println("Deve retornar false, retorno:"+pagamentoKevin.sacar(83));
        System.out.println("Deve retornar true, retorno:"+pagamentoKevin.transferir(poupancaJosenildo,83));
        System.out.println("Saldo deve estar em 2.75, Saldo:"+pagamentoKevin.getSaldo());
        System.out.println("Saldo deve estar em 183, Saldo:"+poupancaJosenildo.getSaldo());
        System.out.println("Deve retornar false, retorno: "+pagamentoKevin.depositar(-10));
        System.out.println("Deve retornar true, retorno: "+pagamentoKevin.depositar(10));
        System.out.println("Saldo deve estar em 12.75, Saldo:"+pagamentoKevin.getSaldo());
        pagamentoKevin.imprimir();

    }
}
