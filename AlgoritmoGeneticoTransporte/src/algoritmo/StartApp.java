package algoritmo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro
 * @author Cristiano
 * @author Elison
 */
public class StartApp {

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {

        // cria uma lista de Produto que vai receber todos os produtos
        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("Geladeira Dako", 0.751, 999.90));
        listaProdutos.add(new Produto("IPhone 6", 0.0000899, 2199.12));
        listaProdutos.add(new Produto("TV 55'", 0.400, 4346.99));
        listaProdutos.add(new Produto("TV 50'", 0.290, 3999.90));
        listaProdutos.add(new Produto("TV 42'", 0.200, 2999.90));
        listaProdutos.add(new Produto("Notebook Dell", 0.00350, 2499.90));
        listaProdutos.add(new Produto("Ventilador Panasonic", 0.496, 199.90));
        listaProdutos.add(new Produto("Microondas Eletrolux", 0.0424, 308.66));
        listaProdutos.add(new Produto("Microondas LG", 0.0544, 429.90));
        listaProdutos.add(new Produto("Microondas Panasonic", 0.0319, 299.29));
        listaProdutos.add(new Produto("Geladeira Brastemp", 0.635, 849.00));
        listaProdutos.add(new Produto("Geladeira Consul", 0.870, 1199.89));
        listaProdutos.add(new Produto("Notebook Lenovo", 0.498, 1999.90));
        listaProdutos.add(new Produto("Notebook Asus", 0.527, 3999.00));

        //cria as lista para trabalhar com a classe Individuo
        List espacos = new ArrayList<>();
        List valores = new ArrayList<>();
        List nomes = new ArrayList<>();

        for (Produto produto : listaProdutos) {
            // adiciona o valor do espaço do produto a variavel espaço
            espacos.add(produto.getEspaco());
            // adiciona o valor do produto na varialvel valor
            valores.add(produto.getValor());
            // adiociona o nome do produto  a variavel nome
            nomes.add(produto.getNome());

        }

        //limite total da carga que seria de 3m³
        Double limite = 3.0;

        int tamanhoPopulacao = 20;

        AlgoritmoGenetico ag = new AlgoritmoGenetico(tamanhoPopulacao);
        ag.inicializaPopulacao(espacos, valores, limite);

        for (Individuo individuo : ag.getPopulacao()) {
            //inicia a avalição de cada individuo da população
            individuo.avaliacao();
        }

        ag.ordenaPopulacao();

        for (int i = 0; i < ag.getTamanhoPopulacao(); i++) {
            System.out.println("*** Individuo " + i + "****\n Espaços " + ag.getPopulacao().get(i).getEspacos()
                    + "\n Valores " + ag.getPopulacao().get(i).getValores()
                    + "\n Cromossomo " + ag.getPopulacao().get(i).getCromossomo()
                    + "\n Nota " + ag.getPopulacao().get(i).getNotaAvaliacao());
        }

//        Individuo individuo1 = new Individuo(espacos, valores, limite);
//        System.out.println("Espaços " + individuo1.getEspaços());
//        System.out.println("Valores " + individuo1.getValores());
//        System.out.println("Cromossomo " + individuo1.getCromossomo());
//        System.out.println("\n Componentes da carga:");
//
//        //for para imprimir o nome do objeto que vai ser levado na carga
//        for (int i = 0; i < listaProdutos.size(); i++) {
//            if (individuo1.getCromossomo().get(i) == "1") {
//                System.out.println("Nome " + listaProdutos.get(i).getNome()
//                        + " valor " + listaProdutos.get(i).getValor());
//            }
//        }
//        Individuo individuo1 = new Individuo(espacos, valores, limite);
//        System.out.println("Individuo 1 " + individuo1.getCromossomo());
//        individuo1.avaliacao();
//        System.out.println("Nota : " + individuo1.getNotaAvaliacao());
//        System.out.println("Espaço usado: " + individuo1.getEspacoUsado());
//        
//        Individuo individuo2 = new Individuo(espacos, valores, limite);
//        System.out.println("Individuo 2 " + individuo2.getCromossomo());
//        individuo2.avaliacao();
//        System.out.println("Nota : " + individuo2.getNotaAvaliacao());
//        System.out.println("Espaço usado: " + individuo2.getEspacoUsado());
//        
//        individuo1.crossover(individuo2);//passo os individuos que vao fazer o crossover
//        
//        individuo1.mutacao(0.05);// limite de 5 % de mutação
//        individuo2.mutacao(0.05);
    }

}
