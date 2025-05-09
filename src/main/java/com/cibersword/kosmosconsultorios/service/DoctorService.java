package com.cibersword.kosmosconsultorios.service;


import com.cibersword.kosmosconsultorios.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Optional<Doctor> find(Long id);
    List<Doctor> findAll();
    Doctor save(Doctor newDoctor);
    void delete(Long id);

}
