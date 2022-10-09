package br.com.ada.programacaowebii.aula.controller.dto.RickAndMorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO {
    private String name;
    private String url;
}
