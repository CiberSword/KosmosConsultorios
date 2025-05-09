package com.cibersword.kosmosconsultorios.service.impl;

import com.cibersword.kosmosconsultorios.entity.Doctor;
import com.cibersword.kosmosconsultorios.repository.DoctorRepository;
import com.cibersword.kosmosconsultorios.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Optional<Doctor> find(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor save(Doctor newDoctor) {
        return doctorRepository.save(newDoctor);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }
}
