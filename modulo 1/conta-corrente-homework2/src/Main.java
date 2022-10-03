public class Main {
    public static void main(String[] args) {

        //Primeira Conta: ------------------------------------------------------

            //Criando os contatos da primeira conta

                //Primeiro contato:

        Contato TelefoneCasaKevin = new Contato();
        TelefoneCasaKevin.tipo = 1;
        TelefoneCasaKevin.descricao = "Meu número";
        TelefoneCasaKevin.telefone = "4002-8922";


        Contato TelefoneTrabalhoKevin = new Contato();
        TelefoneTrabalhoKevin.tipo =2;
        TelefoneTrabalhoKevin.descricao ="Uma descriçao detalhada";
        TelefoneTrabalhoKevin.telefone = "0800 777 7000";

            //Criando endereço da primeira conta

                //Primeiro endereço

        Endereco EnderecoKevin = new Endereco();
        EnderecoKevin.cidade = "Salvador";
        EnderecoKevin.numero = 1337;
        EnderecoKevin.complemento = "Logo ali";
        EnderecoKevin.pais ="Brasil";
        EnderecoKevin.logradouro ="Rua massa pra caramba";
        EnderecoKevin.tipo =1;
        EnderecoKevin.cep = "41577-700";
        EnderecoKevin.estado ="Bahia";

            //Criando o primeiro cliente

        Cliente Kevin = new Cliente();
        Kevin.nome = "Kevin Aryel";
        Kevin.enderecos[0] = EnderecoKevin;
        Kevin.contatos[0] = TelefoneCasaKevin;
        Kevin.contatos[1] = TelefoneTrabalhoKevin;
        Kevin.cpf = "888.888.88-88";

        //Criando a primeira conta:

        ContaCorrente ContaKevin = new ContaCorrente();
        ContaKevin.cliente = Kevin;
        ContaKevin.saldo = 10000000.50;
        ContaKevin.chequeEspecial = 7000;
        ContaKevin.numeroConta = "3077877";
        ContaKevin.agencia = 388;


        // Segunda Conta: ----------------------------------------------------------


            //Criando os contatos da segunda conta:

                //Primeiro Contato:

        Contato TelefoneCasaJosenildo = new Contato();
        TelefoneCasaJosenildo.tipo = 1;
        TelefoneCasaJosenildo.descricao = "Numero do Josenildo";
        TelefoneCasaJosenildo.telefone = "5555-4955";

            //Criando endereço da segunda conta:

                //Primeiro endereço:

        Endereco EnderecoJosenildo = new Endereco();
        EnderecoJosenildo.cidade = "Salinas da Margarida";
        EnderecoJosenildo.numero = 142;
        EnderecoJosenildo.complemento = "Perto do bar do zé";
        EnderecoJosenildo.pais ="Brasilis";
        EnderecoJosenildo.logradouro ="Rua joão pé de feijão";
        EnderecoJosenildo.tipo =1;
        EnderecoJosenildo.cep = "75643-700";
        EnderecoJosenildo.estado ="Bahia";

                //Segundo endereço:

        Endereco EnderecoJosenildoTrabalho = new Endereco();
        EnderecoJosenildoTrabalho.cidade = "Nazaré das Farinhas";
        EnderecoJosenildoTrabalho.numero = 1467;
        EnderecoJosenildoTrabalho.complemento = "Ao lado do correios";
        EnderecoJosenildoTrabalho.pais ="Brasilis";
        EnderecoJosenildoTrabalho.logradouro ="Rua torta324";
        EnderecoJosenildoTrabalho.tipo =2;
        EnderecoJosenildoTrabalho.cep = "55455-78";
        EnderecoJosenildoTrabalho.estado ="Bahia";

            //Criando o segundo cliente

        Cliente Josenildo = new Cliente();
        Josenildo.nome = "Josenildo Silveira";
        Josenildo.enderecos[0] = EnderecoJosenildo;
        Josenildo.enderecos[1] = EnderecoJosenildoTrabalho;
        Josenildo.contatos[0] = TelefoneCasaJosenildo;
        Josenildo.cpf = "456.376.89-99";

            //Criando a segunda conta:

        ContaCorrente ContaJosenildo = new ContaCorrente();
        ContaJosenildo.cliente = Josenildo;
        ContaJosenildo.saldo = 1289.75;
        ContaJosenildo.chequeEspecial = 500;
        ContaJosenildo.numeroConta = "504589";
        ContaJosenildo.agencia = 388;

        ContaKevin.transferir(ContaJosenildo,1000.25);
        ContaJosenildo.sacar(2700.60);
        ContaJosenildo.sacar(7000);

        ContaJosenildo.imprimirContaCorrente();
        ContaKevin.imprimirContaCorrente();


    }
}
