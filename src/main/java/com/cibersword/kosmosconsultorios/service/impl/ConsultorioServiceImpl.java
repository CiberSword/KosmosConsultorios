package com.cibersword.kosmosconsultorios.service.impl;

import com.cibersword.kosmosconsultorios.entity.Consultorio;
import com.cibersword.kosmosconsultorios.repository.ConsultorioRepository;
import com.cibersword.kosmosconsultorios.service.ConsultorioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultorioServiceImpl implements ConsultorioService {

    private final ConsultorioRepository consultorioRepository;

    public ConsultorioServiceImpl(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }

    public Optional<Consultorio> find(Long id) {
        return consultorioRepository.findById(id);
    }

    @Override
    public List<Consultorio> findAll() {
        return consultorioRepository.findAll();
    }

    @Override
    public Consultorio save(Consultorio newConsultorio) {
        return consultorioRepository.save(newConsultorio);
    }

    @Override
    public void delete(Long id) {
        consultorioRepository.deleteById(id);
    }
}
