public class Bezerro extends VacaMae {

    public Bezerro(int id, String nome, String raca, int idade) {
        super(id, nome, raca, idade, false, 0);
    }

    @Override
    public String getStatus() {
        return "Filhote - ainda mama";
    }

    @Override
    public String coletarProduto() {
        return getNome() + " é um filhote e ainda não produz leite.";
    }
}