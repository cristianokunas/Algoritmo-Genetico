package algoritmo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro
 * @author Cristiano
 * @author Elison
 */
public class Individuo implements Comparable<Individuo> { // assim é possivel fazer a compração de um individuo com o outro

    // recebe todos os espaços que os procutos ocupam
    private List espacos = new ArrayList<>(); 
    // recebe todos os valores dos produtos
    private List valores = new ArrayList<>();
    private Double limiteEspacos;
    private Double notaAvaliacao;
    private Double espacoUsado;
    private int geracao;
    // aqui ficara a solução do problema
    private List cromossomo = new ArrayList<>(); 

    /**
     *
     * @param espacos
     * @param valores
     * @param limiteEspacos
     */
    public Individuo(List espacos, List valores, Double limiteEspacos) {
        this.espacos = espacos;
        this.valores = valores;
        this.limiteEspacos = limiteEspacos;
        this.notaAvaliacao = 0.0;
        this.espacoUsado = 0.0;
        this.geracao = 0;

        /**
         * inicializa o cromossomo a primeira vez, pois ele é criado
         * aleatoriamente na primeira vez
         */
        for (int i = 0; i < this.espacos.size(); i++) {
            //pega o tamanho da lista de espaços para definir como o tamanho final
            if (java.lang.Math.random() < 0.5) {
            //inicializa com 50% de probalidade
                this.cromossomo.add("0");
            } else {
                this.cromossomo.add("1");
            }
        }

    }

    /**
     * Método de avaliação (ou fitness)
     */
    public void avaliacao() {
        Double nota = 0.0;
        Double somaEspacos = 0.0;

        /**
         * Percorre todos os itens do cromossomo
         */
        for (int i = 0; i < cromossomo.size(); i++) {
            if (this.cromossomo.get(i).equals("1")) {
                nota += (Double) this.valores.get(i);
                somaEspacos += (Double) this.espacos.get(i);
            }
        }

        /**
         * Verifica se ele não estourou a capacidade total da carga
         */
        if (somaEspacos > limiteEspacos) {
        // neste caso esta solução não é boa 
            nota = 1.0;
        }

        this.notaAvaliacao = nota;
        this.espacoUsado = somaEspacos;
    }

    /**
     * Método de crossover (ou reprodução)
     *
     * @param outroIndividuo
     * @return
     */
    public List crossover(Individuo outroIndividuo) {
        /**
         * define o ponto de corte do cromossomo do individuo
         */
        int corte = (int) Math.round(Math.random() * cromossomo.size());
        List filho1 = new ArrayList<>();
        /**
         * pega da posição 0 ate a posição de corte
         */
        filho1.addAll(outroIndividuo.getCromossomo().subList(0, corte));
        filho1.addAll(this.cromossomo.subList(corte, this.cromossomo.size()));

        List filho2 = new ArrayList<>();
        filho2.addAll(outroIndividuo.getCromossomo().subList(0, corte));
        filho2.addAll(this.cromossomo.subList(corte, this.cromossomo.size()));

        /**
         * Aqui criamos um novo individuo
         */
        List<Individuo> filhos = new ArrayList<>();
        filhos.add(new Individuo(this.espacos, this.valores, this.limiteEspacos));
        filhos.add(new Individuo(this.espacos, this.valores, this.limiteEspacos));

        /**
         * Setando o cromossomo de cada filho
         */
        filhos.get(0).setCromossomo(filho1);
        filhos.get(0).setGeracao(this.geracao + 1);
        filhos.get(1).setCromossomo(filho2);
        filhos.get(1).setGeracao(this.geracao + 1);

        return filhos;

    }

    /**
     *
     * @param taxaMutacao
     * @return
     */
    public Individuo mutacao(Double taxaMutacao) {
        System.out.println("Antes da mutação " + this.cromossomo);

        for (int i = 0; i < cromossomo.size(); i++) {
            if (Math.random() < taxaMutacao) {
                if (this.cromossomo.get(i).equals("1")) {
                    this.cromossomo.set(i, "0");
                } else {
                    this.cromossomo.set(i, "1");
                }
            }
        }
        System.out.println("Depois da mutação " + this.cromossomo);
        return this;// retorna o próprio objeto
    }

    /**
     *
     * @return
     */
    public Double getEspacoUsado() {
        return espacoUsado;
    }

    /**
     *
     * @param espacoUsado
     */
    public void setEspacoUsado(Double espacoUsado) {
        this.espacoUsado = espacoUsado;
    }

    /**
     *
     * @return
     */
    public List getEspacos() {
        return espacos;
    }

    /**
     *
     * @param espacos
     */
    public void setEspacos(List espacos) {
        this.espacos = espacos;
    }

    /**
     *
     * @return
     */
    public List getValores() {
        return valores;
    }

    /**
     *
     * @param valores
     */
    public void setValores(List valores) {
        this.valores = valores;
    }

    /**
     *
     * @return
     */
    public Double getLimiteEspacos() {
        return limiteEspacos;
    }

    /**
     *
     * @param limiteEspacos
     */
    public void setLimiteEspacos(Double limiteEspacos) {
        this.limiteEspacos = limiteEspacos;
    }

    /**
     *
     * @return
     */
    public Double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    /**
     *
     * @param notaAvaliacao
     */
    public void setNotaAvaliacao(Double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    /**
     *
     * @return
     */
    public int getGeracao() {
        return geracao;
    }

    /**
     *
     * @param geracao
     */
    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }

    /**
     *
     * @return
     */
    public List getCromossomo() {
        return cromossomo;
    }

    /**
     *
     * @param cromossomo
     */
    public void setCromossomo(List cromossomo) {
        this.cromossomo = cromossomo;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Individuo o) {
        if (this.notaAvaliacao > o.getNotaAvaliacao()) {
            return -1;
        }
        if (this.notaAvaliacao < o.getNotaAvaliacao()) {
            return 1;
        }
        return 0;
    }
}
