package com.cibersword.kosmosconsultorios.controller;

import com.cibersword.kosmosconsultorios.config.ResponseHandler;
import com.cibersword.kosmosconsultorios.dto.CitaDTO;
import com.cibersword.kosmosconsultorios.entity.Cita;
import com.cibersword.kosmosconsultorios.entity.Consultorio;
import com.cibersword.kosmosconsultorios.entity.Doctor;
import com.cibersword.kosmosconsultorios.service.CitaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CitaController {

    private final CitaService citaService;
    private final ObjectMapper objectMapper;

    @Autowired
    public CitaController(CitaService citaService, ObjectMapper objectMapper) {
        this.citaService = citaService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/cita/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        if (citaService.find(id).isPresent()) {
            return ResponseHandler.generateResponse(HttpStatus.OK,citaService.find(id));
        }
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND,null);
    }

    @GetMapping(value = "/cita")
    @ResponseBody
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.generateResponse(HttpStatus.OK,citaService.findAll());
    }

    @PostMapping("/cita")
    public ResponseEntity<Object> save(@RequestBody CitaDTO dto) {
        Cita cita = objectMapper.convertValue(dto, Cita.class);
        cita.setDoctor(new Doctor());
        cita.getDoctor().setId(dto.getDoctorId());
        cita.setConsultorio(new Consultorio());
        cita.getConsultorio().setId(dto.getConsultorioId());
        return ResponseHandler.generateResponse(HttpStatus.CREATED, citaService.save(cita));
    }

    @PutMapping("/cita")
    public ResponseEntity<Object> update(@RequestBody CitaDTO dto) {
        if (citaService.find(dto.getId()).isPresent()) {
            Cita cita = objectMapper.convertValue(dto, Cita.class);
            cita.setDoctor(new Doctor());
            cita.getDoctor().setId(dto.getDoctorId());
            cita.setConsultorio(new Consultorio());
            cita.getConsultorio().setId(dto.getConsultorioId());
            return ResponseHandler.generateResponse(HttpStatus.OK, citaService.save(cita));
        }
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND,null);
    }

    @DeleteMapping("/cita/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (citaService.find(id).isPresent()) {
            citaService.delete(id);
            return ResponseHandler.generateResponse(HttpStatus.OK,null);
        }
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND,null);

    }

}
