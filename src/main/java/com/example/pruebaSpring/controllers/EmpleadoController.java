package com.example.pruebaSpring.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebaSpring.services.EmpleadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pruebaSpring.models.Empleado;

@RestController
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping(value="Employs")
    public ArrayList<Empleado> getEmploys() {
        return empleadoService.getEmploys();
    }
    
    @GetMapping(value="GetEmploy" , params = "nombre")
    public ArrayList<Empleado> getByName(@RequestParam String nombre) {
        return this.empleadoService.getByName(nombre);
    }
    
    @PostMapping(value="CreateEmploy")
    public Empleado saveEmploys(@RequestBody Empleado empleado) {
        return this.empleadoService.saveEmploys(empleado);
    }
    
    @PutMapping(value="UpdateEmploy/{id}")
    public ResponseEntity<Object> UpdateEmploys(@PathVariable Long id, @RequestBody Empleado empleado) {
        return this.empleadoService.UpdateEmploys(id,empleado);
    }
}
