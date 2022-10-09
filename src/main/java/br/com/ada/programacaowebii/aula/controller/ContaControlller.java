package br.com.ada.programacaowebii.aula.controller;

import br.com.ada.programacaowebii.aula.controller.dto.ContaDTO;
import br.com.ada.programacaowebii.aula.controller.vo.ContaVO;
import br.com.ada.programacaowebii.aula.model.Cliente;
import br.com.ada.programacaowebii.aula.model.Conta;
import br.com.ada.programacaowebii.aula.service.ClienteContaService;
import br.com.ada.programacaowebii.aula.service.ContaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ContaControlller {

    @Autowired
    private ClienteContaService clienteContaService;

    @Autowired
    private ContaService contaService;


    @Operation(summary = "Criar conta", tags = "conta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ContaDTO.class))
                    }
            )

    })
    @PostMapping("/conta")
    public ResponseEntity<String> criarConta(@Valid @RequestHeader(value = "cpf") String cpf, @RequestBody ContaVO contaVO) {
        //TODO - Criar conta
        Conta conta = new Conta();
        Optional<Cliente> clienteOptional = clienteContaService.clienteRepository.findByCpf(cpf);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            conta.setNumero(contaVO.getNumero());
            conta.setDataCriacao(contaVO.getDataCriacao());
            conta.setCliente(cliente);
            contaService.criarConta(conta);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Atualizar conta", tags = "conta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ContaDTO.class))
                    }
            )

    })
    @PutMapping("/conta")
    public ResponseEntity<ContaDTO> atualizarConta(@Valid @RequestBody ContaVO contaVO) {
        //TODO - atualizar conta
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "Buscar conta pelo numero", tags = "conta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ContaDTO.class))
                    }
            )

    })
    @GetMapping("/conta-por-numero/{numero}")
    public ResponseEntity<ContaDTO> buscarContaPeloNumero(@PathVariable("numero") Long numero) {
        //TODO - buscar conta pelo numero
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "Remover conta pelo numero", tags = "conta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ContaDTO.class))
                    }
            )

    })
    @DeleteMapping("/conta-por-numero/{numero}")
    public ResponseEntity<String> removerContaPeloNumero(@PathVariable("numero") Long numero) {
        //TODO - remover conta pelo numero
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Operation(summary = "Listar contas pelo cpf do cliente", tags = "conta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ContaDTO.class))
                    }
            )

    })
    @GetMapping("/contas-por-cpf/{cpf}")
    public ResponseEntity<List<ContaDTO>> listarContasPorCpf(@PathVariable("cpf") String cpf) {
        //TODO - listar contas pelo cpf do cliente
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
