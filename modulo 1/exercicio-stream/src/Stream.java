import java.util.ArrayList;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro Paulo", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Enzo", 2350, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        //1- listar todas as pessoas
//        lista.stream()
//                .forEach();

        //2- filtrar todas as pessoas com salario maior do que 5 mil (filter)

        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente (filter, sorted)

        //4- fazer a média salarial de todos

        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil

        //6- retornar uma lista de todos os ids das pessoas

        //7- criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto

        //8- retornar um HashMap (estrutura de dados, e não uma função map) contendo os ids e os nomes dos colaboradores

        //9- com o mapa da 8, retornar o nome com o id=2

        //10- verificar se tem alguém que contenha o nome "Paulo" (containsignorecase) na lista e retornar o primeiro elemento que encontrar (findFirst).
        //    Imprimir o nome e salário dessa pessoa
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        @Override
        public String toString(){
          return "Pessoa {" +
                  "id="+id+
                  ", nome ="+nome+
                  ", salario="+salario+
                  ", cargo ="+cargo;
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }
    }
}