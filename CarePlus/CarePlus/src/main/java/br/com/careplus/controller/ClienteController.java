package br.com.careplus.controller;

import br.com.careplus.cliente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    @PostMapping
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados) {
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<DadosListagemCliente> listarClientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dados) {
        Cliente cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }

    public void excluirCliente(@PathVariable Long id) {
        Cliente cliente = repository.getReferenceById(id);
        cliente.excluir();
    }

}
