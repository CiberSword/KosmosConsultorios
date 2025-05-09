package com.cibersword.kosmosconsultorios.controller;

import com.cibersword.kosmosconsultorios.config.ResponseHandler;
import com.cibersword.kosmosconsultorios.entity.Doctor;
import com.cibersword.kosmosconsultorios.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        if (doctorService.find(id).isPresent()) {
            return ResponseHandler.generateResponse(HttpStatus.OK,doctorService.find(id));
        }
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND,null);
    }

    @GetMapping(value = "/doctor")
    @ResponseBody
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.generateResponse(HttpStatus.OK,doctorService.findAll());
    }

    @PostMapping("/doctor")
    public ResponseEntity<Object> save(@RequestBody Doctor newDoctor) {
        return ResponseHandler.generateResponse(HttpStatus.CREATED,doctorService.save(newDoctor));
    }

    @PutMapping("/doctor")
    public ResponseEntity<Object> update(@RequestBody Doctor updatedDoctor) {
        if (doctorService.find(updatedDoctor.getId()).isPresent()) {
            return ResponseHandler.generateResponse(HttpStatus.OK,doctorService.save(updatedDoctor));
        }
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND,null);
    }

    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (doctorService.find(id).isPresent()) {
            doctorService.delete(id);
            return ResponseHandler.generateResponse(HttpStatus.OK,null);
        }
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND,null);

    }

}
