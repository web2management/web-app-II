package br.com.ada.programacaowebii.aula.controller.dto.RickAndMorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDTO {
    private Long id;
    private String nome;
    private String status;
    private String species;
    private String type;
    private String gender;
    private OriginDTO origin;
    private LocationDTO location;
    private String image;
    private List<String> episode;



}
