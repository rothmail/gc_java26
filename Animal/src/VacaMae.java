public class VacaMae implements Animal {

    private int id;
    private String nome;
    private String raca;
    private int idade;
    private boolean temFilhote;
    private int litrosLeite;

    public VacaMae(int id, String nome, String raca, int idade, boolean temFilhote, int litrosLeite) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.temFilhote = temFilhote;
        this.litrosLeite = litrosLeite;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public int getLitrosLeite() {
        return litrosLeite;
    }

    public String getStatus() {
        return temFilhote ? "Com filhote" : "Sem filhotes";
    }

    public String getSom() {
        return "Muuu!";
    }

    @Override
    public String coletarProduto() {
        return nome + " produziu " + litrosLeite + "L de leite!";
    }

    @Override
    public void emitirSom() {
        System.out.println(nome + " diz: " + getSom());
    }

    @Override
    public String getInfo() {
        String sufixoIdade = (idade == 1) ? "ano" : "anos";
        return String.format(
                "[ID: %d] %s (Vaca)%n - Raça: %s%n - Idade: %d %s | Status: %s%n - Som: %s",
                id, nome, raca, idade, sufixoIdade, getStatus(), getSom()
        );
    }
}