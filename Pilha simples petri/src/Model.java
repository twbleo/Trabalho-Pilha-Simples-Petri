import java.util.ArrayList;

public class Model {
    private ArrayList<Integer> pilha;
    private int capacidade;

    public Model(int capacidade) {
        this.capacidade = capacidade;
        this.pilha = new ArrayList<>(capacidade);
    }

    public void adicionar(int valor) {
        if (estaCheio()) {
            System.out.println("Capacidade máxima atingida. Aumente a capacidade para adicionar mais elementos.");
        } else {
            pilha.add(valor);
        }
    }

    public Integer remover() {
        if (!estaVazio()) {
            return pilha.remove(pilha.size() - 1);
        }
        return null;
    }

    public void removerTodasOcorrencias(int valor) {
        pilha.removeIf(v -> v == valor);
    }

    public ArrayList<Integer> getPilha() {
        return pilha;
    }

    public boolean buscar(int valor) {
        return pilha.contains(valor);
    }

    public Integer maior() {
        if (estaVazio()) return null;
        int maior = pilha.get(0);
        for (int num : pilha) {
            if (num > maior) maior = num;
        }
        return maior;
    }

    public Integer menor() {
        if (estaVazio()) return null;
        int menor = pilha.get(0);
        for (int num : pilha) {
            if (num < menor) menor = num;
        }
        return menor;
    }

    public Double media() {
        if (estaVazio()) return null;
        int soma = 0;
        for (int num : pilha) {
            soma += num;
        }
        return (double) soma / pilha.size();
    }

    public int tamanho() {
        return pilha.size();
    }

    public boolean estaVazio() {
        return pilha.isEmpty();
    }

    public boolean estaCheio() {
        return pilha.size() >= capacidade;
    }

    public void aumentarCapaci(int capacidadeExtra) {
        this.capacidade += capacidadeExtra;
    }

    public int getCapaci() {
        return capacidade;
    }
}
