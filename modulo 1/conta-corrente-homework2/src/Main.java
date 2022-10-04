public class Main {
    public static void main(String[] args) {

        //Primeira Conta: ------------------------------------------------------

            //Criando os contatos da primeira conta

                //Primeiro contato:

        Contato TelefoneCasaKevin = new Contato(1,"4002-8922","Meu número");

        Contato TelefoneTrabalhoKevin = new Contato(2,"0800 777 7000", "Telefone de trabalho tecpix");

            //Criando endereço da primeira conta

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

        // Criando a primeira conta poupanca:

        ContaPoupanca PoupaKevin = new ContaPoupanca(Kevin,"1001",388,600);


        // Segunda Conta: ----------------------------------------------------------

            //Criando os contatos da segunda conta:

                //Primeiro Contato:

        Contato TelefoneCasaJosenildo = new Contato(1,"5555-4955",
                "Numero do Josenildo");


            //Criando endereço da segunda conta:

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

            //Criando a segunda conta corrente:

        ContaCorrente ContaJosenildo = new ContaCorrente(Josenildo, "2000",388,
                1289.75, 500);
        // Criando a segunda conta poupanca:

            ContaPoupanca PoupancaJosenildo = new ContaPoupanca(Josenildo, "2001",
                    388,100);

        System.out.println(PoupancaJosenildo.getSaldo());
        PoupancaJosenildo.creditarTaxa();
        System.out.println(PoupancaJosenildo.getSaldo());
        PoupancaJosenildo.transferir(ContaJosenildo,100.25);
        System.out.println("Novo saldo conta corrente Josenildo:"+ContaJosenildo.getSaldo());
        ContaKevin.sacar(2700.60);
        ContaKevin.transferir(PoupaKevin, 1000.50);

    }
}
