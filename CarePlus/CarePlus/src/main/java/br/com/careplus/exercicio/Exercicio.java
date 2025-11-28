package br.com.careplus.exercicio;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Table(name = "exercicio")
@Entity(name = "Exercicio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private Integer tempo;
    EspecialidadeModeracao especialidadeModeracao;
    EspecialidadeSentimento especialidadeSentimento;
    private Long clienteId;

    public Exercicio(DadosCadastroExercicio dados) {
        this.data = dados.data();
        this.tempo = dados.tempo();
        this.especialidadeModeracao = dados.especialidadeModeracao();
        this.especialidadeSentimento = dados.especialidadeSentimento();
    }

    public Exercicio(Long id, DadosCadastroExercicio dados) {
        this.data = dados.data();
        this.tempo = dados.tempo();
        this.especialidadeModeracao = dados.especialidadeModeracao();
        this.especialidadeSentimento = dados.especialidadeSentimento();
        this.clienteId = id;
    }

    public void atualizarInformacoes(DadosAtualizacaoExercicio dados){
        if(dados.data() != null){
            this.data = dados.data();
        }
    }
}
