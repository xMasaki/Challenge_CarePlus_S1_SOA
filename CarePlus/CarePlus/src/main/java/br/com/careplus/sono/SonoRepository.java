package br.com.careplus.sono;

import aj.org.objectweb.asm.commons.Remapper;
import br.com.careplus.cliente.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SonoRepository extends JpaRepository<Sono, Long> {
    Page<Sono> findAllByClienteId(Pageable paginacao);
}
