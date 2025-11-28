package br.com.careplus.sono;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "sono")
@Entity(name = "Sono")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private Float horasSono;
    private Integer tempoParaDormir;
    private Integer vezesAcordados;
    private Boolean acordouBem;
    private Long clienteId;

    public Sono(DadosCadastroSono dados) {
        this.data = dados.data();
        this.horasSono = dados.horasSono();
        this.tempoParaDormir = dados.tempoParaDormir();
        this.vezesAcordados = dados.vezesAcordados();
        this.acordouBem = dados.acordouBem();
    }

    public Sono(Long id, DadosCadastroSono dados) {
        this.data = dados.data();
        this.horasSono = dados.horasSono();
        this.tempoParaDormir = dados.tempoParaDormir();
        this.vezesAcordados = dados.vezesAcordados();
        this.acordouBem = dados.acordouBem();
        this.clienteId = id;

    }

    public void atualizarInformacoes(DadosAtualizacaoSono dados) {
        if(dados.data() != null) {
            this.data = dados.data();
        }
        if(dados.horasSono() != this.horasSono) {
            this.horasSono = dados.horasSono();
        }
        if(dados.tempoParaDormir() != this.tempoParaDormir) {
            this.tempoParaDormir = dados.tempoParaDormir();
        }
        if (dados.vezesAcordados() != this.vezesAcordados) {
            this.vezesAcordados = dados.vezesAcordados();
        }
        if (dados.acordouBem() != this.acordouBem) {
            this.acordouBem = dados.acordouBem();
        }
    }
}


