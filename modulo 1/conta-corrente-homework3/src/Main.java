public class Main {
    public static void main(String[] args) {

        //Primeiro Cliente: ------------------------------------------------------

        //Criando os contatos do primeiro cliente

        //Primeiro contato:

        Contato TelefoneCasaKevin = new Contato(1,"4002-8922","Meu número");

        Contato TelefoneTrabalhoKevin = new Contato(2,"0800 777 7000",
                "Telefone de trabalho tecpix");

        //Criando endereço do primeiro cliente

        //Primeiro endereço

        Endereco EnderecoKevin = new Endereco(1,"Rua bacanudona",
                1337,"Logo Ali", "41577-700", "Salvador",
                "Bahia","Brasil");

        //Criando o primeiro cliente

        Cliente Kevin = new Cliente("Kevin Aryel","888.888.888-88");
        Kevin.setEnderecos(EnderecoKevin,0);
        Kevin.setContatos(TelefoneCasaKevin, 0);
        Kevin.setContatos(TelefoneTrabalhoKevin,1);

        //Criando a primeira conta corrente:

        ContaCorrente ContaKevin = new ContaCorrente(Kevin,"1000",
                388,2500.45,700);

        // Criando a primeira conta pagamento:

        ContaPagamento PagamentoKevin = new ContaPagamento(Kevin,"1001",388,600);


        // Segundo Cliente: ----------------------------------------------------------

        //Criando os contatos do segundo cliente:

        //Primeiro Contato:

        Contato TelefoneCasaJosenildo = new Contato(1,"5555-4955",
                "Numero do Josenildo");


        //Criando endereço da segundo cliente:

        //Primeiro endereço:

        Endereco EnderecoJosenildo = new Endereco(1, "Rua João pé de feijão",
                142,"Perto do bar do zé","75643-700","Salinas da Margarida",
                "Bahia", "Brasil");

        //Segundo endereço:

        Endereco EnderecoJosenildoTrabalho = new Endereco(2,"Rua torta",1467,
                "Ao lado do shopping", "55455-78","Nazaré das Farinhas",
                "Bahia", "Brasil");

        //Criando o segundo cliente

        Cliente Josenildo = new Cliente("Josenildo Silveira","456.376.893-99");
        Josenildo.setEnderecos(EnderecoJosenildo,0);
        Josenildo.setEnderecos(EnderecoJosenildoTrabalho,1);
        Josenildo.setContatos(TelefoneCasaJosenildo,0);

        // Criando a conta poupanca:

        ContaPoupanca PoupancaJosenildo = new ContaPoupanca(Josenildo, "2001",
                388,100);

        System.out.println("Saldo Kevin: "+PagamentoKevin.getSaldo());
        PagamentoKevin.sacar(10);
        System.out.println("Saldo deve estar em 585.75, Saldo:"+PagamentoKevin.getSaldo());
        PagamentoKevin.transferir(ContaKevin,500);
        System.out.println("Saldo deve estar em 85.75, Saldo:"+PagamentoKevin.getSaldo());
        System.out.println("Saldo deve estar em 3000.45, Saldo:"+ContaKevin.getSaldo());
        System.out.println("Deve retornar false, retorno:"+PagamentoKevin.sacar(83));
        System.out.println("Deve retornar true, retorno:"+PagamentoKevin.transferir(PoupancaJosenildo,83));
        System.out.println("Saldo deve estar em 2.75, Saldo:"+PagamentoKevin.getSaldo());
        System.out.println("Saldo deve estar em 183, Saldo:"+PoupancaJosenildo.getSaldo());
        System.out.println("Deve retornar false, retorno: "+PagamentoKevin.depositar(-10));
        System.out.println("Deve retornar true, retorno: "+PagamentoKevin.depositar(10));
        System.out.println("Saldo deve estar em 12.75, Saldo:"+PagamentoKevin.getSaldo());
        PagamentoKevin.imprimir();

    }
}
