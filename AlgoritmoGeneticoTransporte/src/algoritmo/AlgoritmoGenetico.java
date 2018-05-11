package algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Leandro
 * @author Cristiano
 * @author Elison
 */
public class AlgoritmoGenetico {

    private int tamanhoPopulacao;
    /**
     * amrmaza dentro da lista todos os individuos da população
     */
    private List<Individuo> populacao = new ArrayList<>();

    private int geracao;
    private Individuo melhorSolucao;

    /**
     *
     * @param tamanhoPopulacao
     */
    public AlgoritmoGenetico(int tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
    }

    /**
     * Método para inicializar a população
     *
     * @param espacos
     * @param valores
     * @param limiteEspacos
     */
    public void inicializaPopulacao(List espacos, List valores, Double limiteEspacos) {
        for (int i = 0; i < tamanhoPopulacao; i++) {
            this.populacao.add(new Individuo(espacos, valores, limiteEspacos));
        }
        this.melhorSolucao = this.populacao.get(0);
    }

    /**
     * Método que ordena a população.
     */
    public void ordenaPopulacao() {
        Collections.sort(this.populacao);
    }

    /**
     * Método pque retorna o tamanho da população
     *
     * @return
     */
    public int getTamanhoPopulacao() {
        return tamanhoPopulacao;
    }

    /**
     * Método que seta tamanho da população
     *
     * @param tamanhoPopulacao
     */
    public void setTamanhoPopulacao(int tamanhoPopulacao) {
        this.tamanhoPopulacao = tamanhoPopulacao;
    }

    /**
     * Método que retorna a população
     *
     * @return
     */
    public List<Individuo> getPopulacao() {
        return populacao;
    }

    /**
     *
     * @param populacao
     */
    public void setPopulacao(List<Individuo> populacao) {
        this.populacao = populacao;
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
     * Método que retorna a melhor solução
     *
     * @return
     */
    public Individuo getMelhorSolucao() {
        return melhorSolucao;
    }

    /**
     *
     * @param melhorSolucao
     */
    public void setMelhorSolucao(Individuo melhorSolucao) {
        this.melhorSolucao = melhorSolucao;
    }

}
