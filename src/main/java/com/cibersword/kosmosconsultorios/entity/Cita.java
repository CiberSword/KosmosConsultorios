package com.cibersword.kosmosconsultorios.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Cita {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consultorio_id", foreignKey = @ForeignKey(name = "fk_consultorio"))
    private Consultorio consultorio;

    @ManyToOne
    @JoinColumn(name = "doctor_id", foreignKey = @ForeignKey(name = "fk_doctor"))
    private Doctor doctor;

    private LocalDateTime horarioConsulta;
    private String nombrePaciente;
}