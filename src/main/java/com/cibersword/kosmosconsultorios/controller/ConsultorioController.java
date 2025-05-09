package com.cibersword.kosmosconsultorios.controller;

import com.cibersword.kosmosconsultorios.config.ResponseHandler;
import com.cibersword.kosmosconsultorios.entity.Consultorio;
import com.cibersword.kosmosconsultorios.service.ConsultorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    @Autowired
    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @GetMapping("/consultorio/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        if (consultorioService.find(id).isPresent()) {
            return ResponseHandler.generateResponse(HttpStatus.OK,consultorioService.find(id));
        }
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND,null);
    }

    @GetMapping(value = "/consultorio")
    @ResponseBody
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.generateResponse(HttpStatus.OK,consultorioService.findAll());
    }

    @PostMapping("/consultorio")
    public ResponseEntity<Object> save(@RequestBody Consultorio newConsultorio) {
        return ResponseHandler.generateResponse(HttpStatus.CREATED,consultorioService.save(newConsultorio));
    }

    @PutMapping("/consultorio")
    public ResponseEntity<Object> update(@RequestBody Consultorio updatedConsultorio) {
        if (consultorioService.find(updatedConsultorio.getId()).isPresent()) {
            return ResponseHandler.generateResponse(HttpStatus.OK,consultorioService.save(updatedConsultorio));
        }
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND,null);
    }

    @DeleteMapping("/consultorio/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (consultorioService.find(id).isPresent()) {
            consultorioService.delete(id);
            return ResponseHandler.generateResponse(HttpStatus.OK,null);
        }
        return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND,null);

    }

}
