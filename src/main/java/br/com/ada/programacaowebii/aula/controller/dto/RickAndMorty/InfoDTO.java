package br.com.ada.programacaowebii.aula.controller.dto.RickAndMorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoDTO {
    private Long cont;
    private Long page;
    private String next;
    private String prev;
}
