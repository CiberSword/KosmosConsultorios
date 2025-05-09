package com.cibersword.kosmosconsultorios.service;


import com.cibersword.kosmosconsultorios.entity.Cita;

import java.util.List;
import java.util.Optional;

public interface CitaService {

    Optional<Cita> find(Long id);
    List<Cita> findAll();
    Cita save(Cita newCita);
    void delete(Long id);

}
