package algoritmo;

/**
 *
 * @author Leandro
 * @author Cristiano
 * @author Elison
 */
public class Produto {

    private String nome;
    private Double espaco;
    private Double valor;

    /**
     *
     * @param nome
     * @param espaco
     * @param valor
     */
    public Produto(String nome, Double espaco, Double valor) {
        this.nome = nome;
        this.espaco = espaco;
        this.valor = valor;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public Double getEspaco() {
        return espaco;
    }

    /**
     *
     * @param espaco
     */
    public void setEspaco(Double espaco) {
        this.espaco = espaco;
    }

    /**
     *
     * @return
     */
    public Double getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

}
