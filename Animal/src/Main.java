import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Animal> curral = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        popularCurral();

        boolean rodando = true;
        while (rodando) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    verAnimais();
                    break;
                case 2:
                    comercio();
                    break;
                case 3:
                    System.out.println("\nAté a próxima colheita!");
                    rodando = false;
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void popularCurral() {
        curral.add(new VacaMae(101, "Mimosa", "Jersey", 7, true, 15));
        curral.add(new Bezerro(102, "Ferdinando", "Jersey", 1));
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Ver animais do curral");
        System.out.println("2. Comércio (Coletar/Retirar produtos)");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void verAnimais() {
        System.out.println("\n====================================================");
        System.out.println("||               ANIMAIS NO CURRAL:               ||");
        System.out.println("====================================================");
        for (Animal animal : curral) {
            System.out.println(animal.getInfo());
            System.out.println();
        }
        System.out.println("====================================================");
    }

    private static void comercio() {
        System.out.println("\n=== COMÉRCIO: coletando produtos ===");
        for (Animal animal : curral) {
            System.out.println(animal.coletarProduto());
            animal.emitirSom();
        }
    }
}