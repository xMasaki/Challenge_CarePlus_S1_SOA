package br.com.careplus.sono;

import java.time.LocalDate;


public record DadosListagemSono(
       Long id,
       LocalDate data,
       Float horasSono,
       Integer tempoParaDormir,
       Integer vezesAcordados,
       Boolean acordouBem,
       Long clienteId) {

    public DadosListagemSono(Sono sono){
        this(sono.getId(),sono.getData(), sono.getHorasSono(), sono.getTempoParaDormir(), sono.getVezesAcordados(), sono.getAcordouBem(), sono.getClienteId());
    }
}
