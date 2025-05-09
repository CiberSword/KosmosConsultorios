package com.cibersword.kosmosconsultorios.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CitaDTO {
    private Long id;
    private Long doctorId;
    private Long consultorioId;
    private LocalDateTime horarioConsulta;
    private String nombrePaciente;
}
