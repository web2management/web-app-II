package br.com.ada.programacaowebii.aula.controller.dto.RickAndMorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonagensDTO {

    private InfoDTO info;
    private List<ResultDTO> results;

}
