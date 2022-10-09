package br.com.ada.programacaowebii.aula.service;
import br.com.ada.programacaowebii.aula.controller.vo.ContaVO;
import br.com.ada.programacaowebii.aula.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    ClienteContaService clienteContaService;

    public Conta criarConta(Conta conta){
        return clienteContaService.contaRepository.save(conta);
    }

    public Conta atualizarConta(ContaVO dadosAtualizadosConta) {
        Optional<Conta> optionalConta = this.clienteContaService.contaRepository.findByNumero(dadosAtualizadosConta.getNumero());
        if (optionalConta.isPresent()) {
            Conta cliente = optionalConta.get();
            Conta contaAtualizado = new Conta();
            contaAtualizado.setId(cliente.getId());
            contaAtualizado.setNumero(dadosAtualizadosConta.getNumero());
            contaAtualizado.setDataCriacao(dadosAtualizadosConta.getDataCriacao());
            return clienteContaService.contaRepository.save(contaAtualizado);
        }
        return null;
    }

    public List<Conta> buscarTodasAsContas(){
        return clienteContaService.contaRepository.findAll();
    }

    public Optional<Conta> buscarContaPorNumero(Long numero) {
        return clienteContaService.contaRepository.findByNumero(numero);
    }

    public List<Conta> buscarContasPorCpf(String cpf){
        return clienteContaService.contaRepository.findContasByCliente_Cpf(cpf);
    }

    public void deletarContaPorNumero(Long numero) {
        clienteContaService.contaRepository.deleteByNumero(numero);
    }
}
