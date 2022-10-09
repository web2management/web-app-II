package br.com.ada.programacaowebii.aula.service;
import br.com.ada.programacaowebii.aula.controller.dto.RickAndMorty.PersonagensDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;


@Service
public class RickAndMortyService {

    public String getPersonagemPorNomeCliente(String nome){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PersonagensDTO> retorno = restTemplate.getForEntity(
                url(),
                PersonagensDTO.class);
        Random random = new Random();
        return retorno.getBody().getResults().get(random.nextInt(retorno.getBody().getResults().size())).getNome();
    }

    public String url(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PersonagensDTO> retorno = restTemplate.getForEntity(
                "https://rickandmortyapi.com/api/character",
                PersonagensDTO.class);
        Long pages =  retorno.getBody().getInfo().getPage();
        Random random = new Random();
        return String.format("https://rickandmortyapi.com/api/character/?page=%s", random.nextLong(pages));
    }

}
