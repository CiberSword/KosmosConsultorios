package com.cibersword.kosmosconsultorios.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", foreignKey = @ForeignKey(name = "fk_especialidad"))
    private Especialidad especialidad;

}
