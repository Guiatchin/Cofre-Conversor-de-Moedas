package moeda;

import java.util.List;

public class Real extends Moeda {
    static final String tipo = "Real";

    //Construtor definindo os atributos para serem utilizados no metodo de adição.
    public Real() {super( tipo, 1);}

    public List<Double> getMoedasDisponiveis() {
        return List.of(0.01,0.05, 0.10, 0.25, 0.50, 1.00);
    }
    public String info(){
        return "R$" + this.valor;
    }

    public double converter() {
            return this.getValor() * this.conversao ;
        }

}
