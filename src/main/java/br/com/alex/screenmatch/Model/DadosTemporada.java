package br.com.alex.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosTemporada {

    @JsonAlias("Season")
    private Integer numero;
    @JsonAlias("Episodes")
    private List<DadosEpisodio> episodios;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<DadosEpisodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<DadosEpisodio> episodios) {
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Temporada {" + "Número da temporada = " + numero + ", Episódios = " + episodios + '}';
    }

}
