package br.edu.unifacear.jogodavelha_android.entity;

public class Jogada
{
    private Integer id;
    private Integer posicao;
    private Boolean jogada;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public Boolean getJogada() {
        return jogada;
    }

    public void setJogada(Boolean jogada) {
        this.jogada = jogada;
    }
}
