package moeda;
import java.util.List;
abstract public class Moeda {
    public String nome;
    protected double valor;
    public double conversao;

    //Lista usada para definir moedas existentes em cada tipo de valor(Real, Euro ou Dólar)
    public abstract List<Double> getMoedasDisponiveis();

    //construtores.
    public Moeda() {}

    public Moeda(String c_Nome, double c_Conversao) {
        this.nome = c_Nome;
        this.conversao = c_Conversao;
    }
    //métodos abstratos
    public abstract String info();
    public abstract double converter();

    //métodos Get e Set
    public double getValor() {return valor;}

    public void setValor(double v_Valor) {this.valor = v_Valor;}

}
