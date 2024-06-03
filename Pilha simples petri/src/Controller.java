import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private Repository repository;
    private Scanner scanner;

    public Controller(Repository repository) {
        this.repository = repository;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    RemoverTodasOcorrencias();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    buscar();
                    break;
                case 6:
                    maior();
                    break;
                case 7:
                    menor();
                    break;
                case 8:
                    media();
                    break;
                case 9:
                    Tamanho();
                    break;
                case 10:
                    AumentarCapacidade();
                    break;
                case 0:
                    System.out.println("Fechando Sistema...");
                    return;
                default:
                    System.out.println("Escolha uma alternativa válida.");
            }
        }
    }

    private int getUserChoice() {
        while (true) {
            try {
                System.out.println("\nEscolha uma alternativa:");
                System.out.println("1 - Adicionar");
                System.out.println("2 - Remover");
                System.out.println("3 - Remover todas as ocorrências");
                System.out.println("4 - Listar");
                System.out.println("5 - Buscar");
                System.out.println("6 - Maior");
                System.out.println("7 - Menor");
                System.out.println("8 - Média");
                System.out.println("9 - Quantidade");
                System.out.println("10 - Aumentar capacidade");
                System.out.println("0 - Sair");
                System.out.print("Selecione uma alternativa: ");
                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= 10) {
                    return choice;
                } else {
                    System.out.println("Escolha uma alternativa válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
            }
        }
    }

    private void add() {
        System.out.print("Digite o valor para adicionar a pilha: ");
        int value = scanner.nextInt();
        repository.add(value);
    }

    private void remove() {
        Integer value = repository.remover();
        if (value != null) {
            System.out.println("Removido: " + value);
        }
    }

    private void RemoverTodasOcorrencias() {
        System.out.print("Digite o valor para remover todas as ocorrências: ");
        int value = scanner.nextInt();
        repository.RemoverTodasOcorrencias(value);
    }

    private void listar() {
        ArrayList<Integer> stack = repository.getAll();
        if (stack.isEmpty()) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.println("Elementos da pilha:");
            for (Integer value : stack) {
                System.out.println(value);
            }
        }
    }

    private void buscar() {
        System.out.print("Digite o valor para buscar: ");
        int value = scanner.nextInt();
        boolean found = repository.buscar(value);
        if (found) {
            System.out.println("Elemento existente na pilha.");
        } else {
            System.out.println("Elemento não existente na pilha.");
        }
    }

    private void maior() {
        Integer max = repository.getMaior();
        if (max != null) {
            System.out.println("Maior valor: " + max);
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    private void menor() {
        Integer min = repository.getMenor();
        if (min != null) {
            System.out.println("Menor valor: " + min);
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    private void media() {
        Double avg = repository.getMedia();
        if (avg != null) {
            System.out.println("Valor médio da pilha: " + avg);
        } else {
            System.out.println("A pilha está vazia.");
        }
    }

    private void Tamanho() {
        int size = repository.getTamanho();
        System.out.println("Tamanho da pilha: " + size);
    }

    private void AumentarCapacidade() {
        System.out.print("Digite a capacidade extra para ser adicionada a pilha: ");
        int extraCapacity = scanner.nextInt();
        repository.aumentarCapaci(extraCapacity);
    }

    public static void main(String[] args) {
        Model model = new Model(5);
        Repository repository = new Repository(model);
        Controller controller = new Controller(repository);
        controller.run();
    }
}
