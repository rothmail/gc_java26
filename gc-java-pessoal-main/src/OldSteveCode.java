/**
 * Classe que representa uma Picareta.
 * Reúne os atributos (material, durabilidade, força) e os métodos
 * (minerar, reparar) que antes eram funções soltas e variáveis separadas
 * no código procedural do velho Steve.
 */
class Picareta {

    // Atributos privados: só a própria classe pode acessá-los diretamente (encapsulamento)
    private String material;
    private int durabilidade;
    private final int forca;

    /**
     * Construtor: garante que toda Picareta nasça em um estado íntegro,
     * validando os dados antes de criar o objeto.
     */
    public Picareta(String material, int durabilidade, int forca) {
        if (durabilidade <= 0 || forca <= 0) {
            throw new IllegalArgumentException("Durabilidade e força devem ser positivas!");
        }
        this.material = material;
        this.durabilidade = durabilidade;
        this.forca = forca;

        System.out.println("\n=== FABRICANDO PICARETA ===");
        System.out.println("Material: " + material);
        System.out.println("Durabilidade: " + durabilidade);
        System.out.println("Força: " + forca);
        System.out.println("Picareta de " + material + " fabricada com sucesso!");
    }

    /**
     * Minera uma quantidade de blocos, reduzindo a durabilidade da própria
     * picareta a cada bloco. Não precisa mais receber material/durabilidade/força
     * como parâmetros: o objeto já "sabe" esses dados sobre si mesmo.
     */
    public int minerar(int blocos) {
        System.out.println("\n=== MINERANDO COM PICARETA DE " + material.toUpperCase() + " ===");
        System.out.println("Durabilidade atual: " + durabilidade);
        System.out.println("Força: " + forca);
        System.out.println("Blocos a minerar: " + blocos);

        if (durabilidade <= 0) {
            System.out.println("Picareta quebrada!");
            return 0;
        }

        int blocosMinerados = 0;
        for (int i = 0; i < blocos; i++) {
            if (durabilidade <= 0) {
                System.out.println(" Picareta quebrou no bloco " + (i + 1));
                break;
            }
            durabilidade--;
            blocosMinerados++;
        }

        System.out.println("\nMinerados " + blocosMinerados + " blocos");
        System.out.println("Durabilidade restante: " + durabilidade);

        if (durabilidade <= 0) {
            System.out.println(" A picareta de " + material + " quebrou completamente!");
        }

        return blocosMinerados;
    }

    /**
     * Repara a picareta, respeitando o limite máximo de durabilidade
     * de acordo com o material (regra que não depende de nenhum objeto
     * específico, por isso é um método static).
     */
    public void reparar(int quantidade) {
        System.out.println("\n=== REPARANDO PICARETA DE " + material.toUpperCase() + " ===");
        System.out.println("Durabilidade atual: " + durabilidade);
        System.out.println("Quantidade a reparar: " + quantidade);

        int limiteMaximo = limiteMaximoPara(material);
        int durabilidadeNova = durabilidade + quantidade;

        if (durabilidadeNova > limiteMaximo) {
            System.out.println(" Reparo limitado a " + limiteMaximo);
            durabilidadeNova = limiteMaximo;
        }

        this.durabilidade = durabilidadeNova;
        System.out.println(" Durabilidade nova: " + durabilidade);
    }

    /**
     * Método static: calcula o limite máximo de durabilidade por material.
     * Não depende de nenhuma instância existir para ser usado.
     */
    private static int limiteMaximoPara(String material) {
        switch (material.toLowerCase()) {
            case "madeira": return 50;
            case "pedra":   return 70;
            case "ferro":   return 100;
            case "ouro":    return 30;
            default:        return 60;
        }
    }

    public String getMaterial() {
        return material;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public int getForca() {
        return forca;
    }

    // toString() troca o antigo "String p1 = ..." por uma representação do próprio objeto
    @Override
    public String toString() {
        return "Picareta de " + material + " (D: " + durabilidade + ", F: " + forca + ")";
    }
}

/**
 * Classe de teste: instancia objetos Picareta e usa seus métodos,
 * reproduzindo o comportamento original do arquivo procedural.
 */
public class OldSteve {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║   VELHO STEVE - FÁBRICA DE PICARETAS (agora orientada a objetos) ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        Picareta p1 = new Picareta("madeira", 50, 5);
        Picareta p2 = new Picareta("pedra", 70, 8);
        Picareta p3 = new Picareta("ferro", 100, 12);

        System.out.println("\nPicaretas fabricadas:");
        System.out.println("  • " + p1);
        System.out.println("  • " + p2);
        System.out.println("  • " + p3);

        System.out.println("\n  Usando picaretas para minerar...");
        p3.minerar(30);
        p3.minerar(20);

        System.out.println("\n Criando picareta de ouro...");
        Picareta p4 = new Picareta("ouro", 30, 15);

        System.out.println("\n Reparando a picareta de ferro...");
        p3.reparar(50);

        System.out.println("\nEstado final das picaretas:");
        System.out.println("  • " + p1);
        System.out.println("  • " + p2);
        System.out.println("  • " + p3);
        System.out.println("  • " + p4);
    }
}