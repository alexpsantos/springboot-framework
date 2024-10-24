package br.com.alex.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosSerie {

    @JsonAlias("Title")
    private String titulo;

    @JsonAlias("totalSeasons")
    private Integer toalTemporadas;

    @JsonAlias("imdbRating")
    private String avaliacao;

    @JsonAlias("Released")
    private String dataLancamento;

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Integer getToalTemporadas() {
        return toalTemporadas;
    }

    public void setToalTemporadas(Integer toalTemporadas) {
        this.toalTemporadas = toalTemporadas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Total de Temporadas: " + toalTemporadas + ", Avaliação: " + avaliacao +", Data de Lançamento: " + dataLancamento;
    }

}
