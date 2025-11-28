package br.com.careplus.exercicio;

import br.com.careplus.cliente.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    Page<Exercicio> findAllByClienteId(Pageable paginacao);
}
