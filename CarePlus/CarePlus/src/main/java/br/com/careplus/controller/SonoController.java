package br.com.careplus.controller;

import br.com.careplus.sono.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/clientes/{clienteId}/sono")
public class SonoController {

    @Autowired
    private SonoRepository repository;

    @Transactional
    @PostMapping
    public void cadastrarSono(@PathVariable Long clienteId, @RequestBody @Valid DadosCadastroSono dados) {
        repository.save(new Sono(clienteId, dados));
    }

    @GetMapping
    public Page<DadosListagemSono> listarSono(@PageableDefault(size = 10, sort = {"data"}) Pageable paginacao) {
        return repository.findAllByClienteId(paginacao).map(DadosListagemSono::new);
    }

    @PutMapping
    @Transactional
    public void atualizarSono(@Valid @RequestBody DadosAtualizacaoSono dados) {
        Sono sono = repository.getReferenceById(dados.id());
        sono.atualizarInformacoes(dados);
    }
}
