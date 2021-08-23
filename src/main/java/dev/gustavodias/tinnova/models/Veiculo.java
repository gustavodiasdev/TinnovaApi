package dev.gustavodias.tinnova.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "TB_VEICULO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veiculo {

    @Id
    @Column(name = "ID_VEICULO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NO_VEICULO")
    @NonNull
    private String nome;

    @Column(name = "NO_MARCA")
    @NonNull
    private String marca;

    @Column(name = "DT_ANO")
    @NonNull
    private Integer ano;

    @Column(name = "DS_VEICULO")
    @NonNull
    private String descricao;

    @Column(name = "ST_VEICULO")
    private Boolean vendido = Boolean.FALSE;

    @Column(name = "DT_CREATED")
    private LocalDate created = LocalDate.now();

    @Column(name = "DT_UPDATED")
    private LocalDate updated;
}
