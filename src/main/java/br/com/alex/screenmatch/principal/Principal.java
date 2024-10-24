package br.com.alex.screenmatch.principal;



import br.com.alex.screenmatch.Model.DadosEpisodio;
import br.com.alex.screenmatch.Model.DadosSerie;
import br.com.alex.screenmatch.Model.DadosTemporada;
import br.com.alex.screenmatch.Model.Episodio;
import br.com.alex.screenmatch.service.ConsumoApi;
import br.com.alex.screenmatch.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void exibiMenu(){

        System.out.println("Digite o nome da seria para busca");
        var nomeSerie = leitura.nextLine();

        String enderecoAPi = ENDERECO + nomeSerie.replace(" ", "+") + API_KEY;

        var json = consumo.obterDados(enderecoAPi);

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();

		for(int i = 1; i<=dados.getToalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);

		}


        for(DadosTemporada temp: temporadas){
            System.out.println("Temporada " + temp.getNumero());
            for(DadosEpisodio epi: temp.getEpisodios()){
                System.out.println("Episodio " + epi.getNumeroEpisodio() + " - " + epi.getTitulo());
            }
        }

//        List<String> nome = Arrays.asList("Bianca", "Aline", "Carlos", "Mimi");
//
//        nome.stream()
//                .sorted()
//                .filter(n -> n.startsWith("M"))
//                .map(n -> n.toUpperCase())
//                .forEach(System.out::println);
//
//        nome.stream()
//                .sorted()
//                .forEach(System.out::println);

        temporadas.forEach(temp -> {
            System.out.println("Temporada: " + temp.getNumero());

            temp.getEpisodios().forEach(episodio -> {
                System.out.println("Episodio " + episodio.getNumeroEpisodio() + " - " + episodio.getTitulo());
                // Aqui você pode adicionar mais detalhes sobre o episódio, se necessário.
            });
        });


        List<DadosEpisodio> dadosEpisodios = temporadas.stream().flatMap(t -> t.getEpisodios().stream())
                .collect(Collectors.toList());

        System.out.println("\n Top 5 episodios");
        dadosEpisodios.stream()
                .filter(e -> !e.getAvaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpisodio::getAvaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.getEpisodios().stream()
                        .map(d -> new Episodio(t.getNumero(), d))
                ).collect(Collectors.toList());

        episodios.forEach(System.out::println);
    }

}
