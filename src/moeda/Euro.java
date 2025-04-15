package moeda;
import java.util.List;

public class Euro extends Moeda {
    static final String tipo = "Euro";

    // //Mantendo um valor fixo para o euro em relação ao Real.
    public Euro() {super(tipo,6.64);}

    public List<Double> getMoedasDisponiveis() {
        return List.of(0.01,0.02, 0.05, 0.10, 0.20, 0.50, 1.00, 2.00);
    }
    //aplicando a conversao para o Real com o valor do Euro
    public double converter() {
        return this.getValor() * this.conversao ;
    }

    public String info(){
        return "€ " + this.valor;}
}
