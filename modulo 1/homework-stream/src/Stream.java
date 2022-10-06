import java.util.*;
import java.util.stream.Collectors;

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

        System.out.println("\n--------------------- Resposta Atividade 1 ---------------------\n");

        lista.stream().
                forEach(pessoa-> System.out.println(pessoa));

        //2- filtrar todas as pessoas com salario maior do que 5 mil (filter)

        System.out.println("\n--------------------- Resposta Atividade 2 ---------------------\n");

        lista.stream()
                .filter(pessoa -> pessoa.getSalario() > 5000).forEach(System.out::println);

        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente (filter, sorted)

        System.out.println("\n--------------------- Resposta Atividade 3 ---------------------\n");

        lista.stream()
                .filter(pessoa -> pessoa.getCargo() == "Desenvolvedor")
                .sorted(Comparator.comparing(Pessoa::getSalario))
                .forEach(System.out::println);

        //4- fazer a média salarial de todos

        System.out.println("\n--------------------- Resposta Atividade 4 ---------------------\n");

        Double exercicioStream4 = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();

        System.out.println(exercicioStream4);

        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil

        System.out.println("\n--------------------- Resposta Atividade 5 ---------------------\n");

        boolean exercicioStream5 = lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() >20000);

        System.out.println(exercicioStream5);

        //6- retornar uma lista de todos os ids das pessoas

        System.out.println("\n--------------------- Resposta Atividade 6 ---------------------\n");

        lista.stream()
                .map(pessoa -> pessoa.getId())
                .toList()
                .forEach(System.out::println);


        //7- criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream,
        // retornar uma lista desse novo objeto

        System.out.println("\n--------------------- Resposta Atividade 7 ---------------------\n");

        lista.stream()
                .map(pessoa-> new Salario(pessoa.getId(), pessoa.getSalario()))
                .toList()
                .forEach(System.out::println);

        //8- retornar um HashMap (estrutura de dados, e não uma função map) contendo os ids e os nomes dos colaboradores

        System.out.println("\n--------------------- Resposta Atividade 8 ---------------------\n");

        Map<Integer,String> exercicioStream8 = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));

        System.out.println(exercicioStream8);

        //9- com o mapa da 8, retornar o nome com o id=2

        System.out.println("\n--------------------- Resposta Atividade 9 ---------------------\n");

        System.out.println(exercicioStream8.get(2));

        //10- verificar se tem alguém que contenha o nome "Paulo" (containsignorecase) na lista e retornar o primeiro elemento que encontrar (findFirst).
        //    Imprimir o nome e salário dessa pessoa

        System.out.println("\n--------------------- Resposta Atividade 10 ---------------------\n");

           Optional<Pessoa> exercicioStream9 = lista.stream()
                   .filter(pessoa -> pessoa.getNome().toLowerCase().contains("paulo"))
                   .findFirst();

           if (exercicioStream9.isPresent()){
               Pessoa pessoa1 = exercicioStream9.get();
               System.out.println(pessoa1.getNome()+", "+pessoa1.getSalario());
        }
    }

    static class Salario{

        private int id;
        private double salario;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public Salario(int id, double salario){
            this.id = id;
            this.salario = salario;
        }


        @Override
        public String toString(){
            return "Salario {" +
                    "id = "+id+
                    ", salario = "+salario+
                    '}';
        };

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
                  "id = "+id+
                  ", nome = "+nome+
                  ", salario = "+salario+
                  ", cargo = "+cargo+'}';
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