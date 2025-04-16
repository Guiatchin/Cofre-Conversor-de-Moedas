package moeda;

import java.util.List;
public class Dolar extends Moeda{
    static final String tipo = "Dólar";

    //Mantendo um valor fixo para o dólar em relação ao Real.
    public Dolar() {super(tipo, 5.89);}

    public List<Double> getMoedasDisponiveis() {
        return List.of(0.01,0.05, 0.10, 0.25, 0.50, 1.00);
    }
    public String info(){
        return "U$D" + this.valor;
    }
    //Aplicando a conversao com o valor do dólar
    public double converter() {
        return this.getValor() * this.conversao ;
    }
    }

