package br.com.alex.screenmatch.Model;

import java.time.LocalDate;

public class Episodio {

    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.getTitulo();
        this.numeroEpisodio = dadosEpisodio.getNumeroEpisodio();
        try {
            this.avaliacao = Double.valueOf(dadosEpisodio.getAvaliacao());
        } catch (NumberFormatException ex ){
            this.avaliacao = 0.0;
        }

    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEpisoido() {
        return numeroEpisodio;
    }

    public void setEpisoido(Integer episoido) {
        this.numeroEpisodio = episoido;
    }

    public Double getAvaliação() {
        return avaliacao;
    }

    public void setAvaliação(Double avaliação) {
        this.avaliacao = avaliação;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }


    @Override
    public String toString() {
        return "Episodio {temporada=" + temporada + ", titulo='" + titulo + "', numeroEpisodio=" + numeroEpisodio + ", avaliacao=" + avaliacao + ", dataLancamento=" + dataLancamento + "}";
    }



}
