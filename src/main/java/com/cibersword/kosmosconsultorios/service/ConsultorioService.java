package com.cibersword.kosmosconsultorios.service;


import com.cibersword.kosmosconsultorios.entity.Consultorio;

import java.util.List;
import java.util.Optional;

public interface ConsultorioService {

    Optional<Consultorio> find(Long id);
    List<Consultorio> findAll();
    Consultorio save(Consultorio newConsultorio);
    void delete(Long id);

}
