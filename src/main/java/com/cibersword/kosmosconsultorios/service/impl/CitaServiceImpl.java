package com.cibersword.kosmosconsultorios.service.impl;

import com.cibersword.kosmosconsultorios.entity.Cita;
import com.cibersword.kosmosconsultorios.repository.CitaRepository;
import com.cibersword.kosmosconsultorios.service.CitaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public Optional<Cita> find(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public Cita save(Cita newCita) {
        return citaRepository.save(newCita);
    }

    @Override
    public void delete(Long id) {
        citaRepository.deleteById(id);
    }
}
