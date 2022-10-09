package br.com.ada.programacaowebii.aula.service;
import br.com.ada.programacaowebii.aula.repository.ClienteRepository;
import br.com.ada.programacaowebii.aula.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteContaService {

    @Autowired
    public ClienteRepository clienteRepository;
    @Autowired
    public ContaRepository contaRepository;
}
