package algorithms.demos.ex3;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        // Comparação baseada na idade
        return Integer.compare(this.idade, outraPessoa.getIdade());
    }

    @Override
    public String toString() {
        String str = " ";
        str += "Nome: " + this.nome + " ";
        str += "Idade: " + this.idade;
        return str;
    }
}

