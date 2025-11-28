package br.com.careplus.controller;

import br.com.careplus.exercicio.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes/{clienteId}/exercicio")
public class ExercicioController {

    @Autowired
    private ExercicioRepository repository;

    @Transactional
    @PostMapping
    public void cadastrarExercicio(@PathVariable Long clienteId, @RequestBody @Valid DadosCadastroExercicio dados){
        repository.save(new Exercicio(clienteId, dados));
    }

    @GetMapping
    public Page<DadosListagemExercicio> listarExercicio(@PageableDefault(size = 10, sort = {"data"}) Pageable paginacao){
        return repository.findAllByClienteId(paginacao).map(DadosListagemExercicio::new);
    }

    @PutMapping
    @Transactional
    public void atualizarExercicio(@Valid @RequestBody DadosAtualizacaoExercicio dados){
        Exercicio exercicio = repository.getReferenceById(dados.id());
        exercicio.atualizarInformacoes(dados);
    }
}
