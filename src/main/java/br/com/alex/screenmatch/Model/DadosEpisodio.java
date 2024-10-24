package br.com.alex.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosEpisodio {

    @JsonAlias("Title")
    private String titulo;
    @JsonAlias("totalSeasons")
    private Integer totalTemporada;
    @JsonAlias("imdbRating")
    private String avaliacao;
    @JsonAlias("Episode")
    private Integer numeroEpisodio;



    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getTotalTemporada() {
        return totalTemporada;
    }

    public void setTotalTemporada(Integer totalTemporada) {
        this.totalTemporada = totalTemporada;
    }

    @Override
    public String toString() {
        return  "{" + "Título = '" + titulo + '\'' + ", Total de Temporadas = " + totalTemporada + ", Avaliação = '" + avaliacao + '\'' + '}';
    }

}
