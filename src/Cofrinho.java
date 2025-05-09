import moeda.Dolar;
import moeda.Euro;
import moeda.Moeda;
import moeda.Real;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Cofrinho {
    Scanner digito = new Scanner(System.in);
    private final ArrayList<Moeda>ListaMoedas = new ArrayList<>();

    //Metodo para adicionar moedas no cofrinho
    public void adicionar(Moeda moeda) {
        System.out.println("Digite um valor");
        Scanner entrada = new Scanner(System.in);
        double valor = entrada.nextDouble();
        if (!moeda.getMoedasDisponiveis().contains(valor)) { //Verifica se o valor inserido existe como moeda.
            System.out.println("ATENÇÃO: MOEDA INDISPONÍVEL");
        } else {
            moeda.setValor(valor);
            this.ListaMoedas.add(moeda);
        }
    }
    //metodo para remover as moedas do cofre
    public void remover(Moeda moeda) {
        this.ListaMoedas.remove(moeda);
    }
    //detalhar conteúdo do cofrinho (opção 4. Listar moedas).
    public void detalhesCofrinho(){
        System.out.println("MOEDAS DISPONIVEIS");
        System.out.println("_________________________");
        System.out.println("| Indice | Valor | Tipo |");
        for (int i = 0; i < this.ListaMoedas.size(); i++){
        Moeda moeda = this.ListaMoedas.get(i);

        String posicao = String.format("%-5s", i);
        String nomeMoeda = String.format("%7s", moeda.nome);
        String valor = String.format("%.2f",moeda.getValor());

            System.out.println(" | " + posicao + " | " + String.format("%7s", valor) + " | " + nomeMoeda + "| " + moeda.info());
        }
    }
    //Exibindo valor total do cofrinho com a conversão
    public double totalConvertido(){
        double soma = 0;
        for (int i = 0; i < this.ListaMoedas.size(); i++) {
            Moeda moeda = this.ListaMoedas.get(i);
            soma += moeda.converter();
        }
        return soma;
    }
    public String menu() {

        //Opções do Menu
        HashMap<Integer, String> opcoes = new HashMap<Integer, String>();
        opcoes.put(1, "adicionar");
        opcoes.put(2, "remover");
        opcoes.put(3,"detalhes");
        opcoes.put(4,"total");
        opcoes.put(5, "sair");
        int digitoSelecionado = 0;

        while(true) {
            System.out.println("Selecione uma opção: ");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Total convertido");
            System.out.println("5. Sair");

            if (digito.hasNextInt()) {
                digitoSelecionado = digito.nextInt();
                if (digitoSelecionado < 1 ||digitoSelecionado > 5) {
                    System.out.println("Selecione um do números acima.");
                } else {
                    break;
                }
            }
        }
        return opcoes.get(digitoSelecionado);

    }

    //Iniciando funções do cofrinho
    public void inicializar() { //Menu Inicial
        String acao = "";
        while(!acao.equals("sair")) {
            acao = this.menu();

            switch (acao) {
                case "adicionar":
                    this.menuAdicionar();
                    break;
                case "remover":
                    this.menuRetirar();
                    break;
                case "detalhes":
                    this.detalhesCofrinho();
                    break;
                case "total":
                    System.out.printf("Você possui R$ %.2f convertido \n", this.totalConvertido());
                    break;
                case "sair" :
                    digito.close();
                    break;
            }
        }
    }
    protected Number selecionarQuantia(boolean Int) {
        Scanner valorIn = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        if (Int) {
            return valorIn.nextInt();
        }
        return valorIn.nextDouble();
    }
    public void menuAdicionar(){
        String opcao = "";

        while (!opcao.equals("voltar")) {
            opcao = this.menuTipoMoeda(false);
            switch(opcao) {
                case "dolar":
                    this.adicionar(new Dolar());
                    break;
                case "euro" :
                    this.adicionar(new Euro());
                    break;
                case "real":
                    this.adicionar(new Real());
                    break;

            }
        }
    }

    public void menuRetirar() {


        if (ListaMoedas.isEmpty()) {
            System.out.println("nenhuma moeda disponível para retirada");
        } else {
            this.detalhesCofrinho();
            System.out.println("Selecione o indice da moeda que vai ser retirada");
            int opcao = (int) this.selecionarQuantia(true);
            this.remover(this.ListaMoedas.get(opcao));
            System.out.println("Moeda removida.");
        }
    }

    protected String menuTipoMoeda(boolean remover) {
        Scanner digito = new Scanner(System.in);
        //Definindo opções disponíveis.
        HashMap<Integer, String> opcoes = new HashMap<>();
        opcoes.put(1, "dolar");
        opcoes.put(2, "euro");
        opcoes.put(3, "real");
        opcoes.put(4, "voltar");
        int digitoSelecionado = 0;

        while (digitoSelecionado < 1 || digitoSelecionado > 4) {

            System.out.println("1. Dólar");
            System.out.println("2. Euro");
            System.out.println("3. Real");
            System.out.println("4. Voltar");

            if (digito.hasNextInt()) {
                digitoSelecionado = digito.nextInt();
                if (digitoSelecionado < 1 || digitoSelecionado > 4) {
                    System.out.println("Selecione um dos valores acima:");
                } else {
                    break;
                }

            }
        }
        return opcoes.get(digitoSelecionado);
    }
}


