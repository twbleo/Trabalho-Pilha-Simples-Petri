import java.util.ArrayList;

public class Repository {
    private Model model;

    public Repository(Model model) {
        this.model = model;
    }

    public void add(int value) {
        model.adicionar(value);
    }

    public Integer remover() {
        return model.remover();
    }

    public void RemoverTodasOcorrencias(int value) {
        model.removerTodasOcorrencias(value);
    }

    public ArrayList<Integer> getAll() {
        return model.getPilha();
    }

    public boolean buscar(int value) {
        return model.buscar(value);
    }

    public Integer getMaior() {
        return model.maior();
    }

    public Integer getMenor() {
        return model.menor();
    }

    public Double getMedia() {
        return model.media();
    }

    public int getTamanho() {
        return model.tamanho();
    }

    public boolean estaVazio() {
        return model.estaVazio();
    }

    public boolean estaCheio() {
        return model.estaCheio();
    }

    public void aumentarCapaci(int extraCapacity) {
        model.aumentarCapaci(extraCapacity);
    }

    public int getCapacidade() {
        return model.getCapaci();
    }
}
