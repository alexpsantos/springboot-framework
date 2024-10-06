package br.com.alex.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosSerie {

    @JsonAlias("Title")
    private String titulo;
    @JsonAlias("totalSeasons")
    private Integer totalTemporada;
    @JsonAlias("imdbRating")
    private String avaliacao;



}
