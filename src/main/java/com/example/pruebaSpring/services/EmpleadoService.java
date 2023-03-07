package com.example.pruebaSpring.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pruebaSpring.Repositories.EmpleadoRepository;
import com.example.pruebaSpring.models.Empleado;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public ArrayList<Empleado> getEmploys() {
        return (ArrayList<Empleado>) empleadoRepository.findAll();
    }

    public Optional<Empleado> getById(Long id) {
        return empleadoRepository.findById(id);
    }

    public ArrayList<Empleado> getByName(String nombre) {
        return empleadoRepository.findByNombre(nombre);
    }

    public Empleado saveEmploys(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public ResponseEntity<Object> UpdateEmploys(Long id, Empleado empleado) {
        Optional<Empleado> employId = empleadoRepository.findById(id);
        if (empleadoRepository.UpdateValid(empleado)) {
            return new ResponseEntity<>("Campos mal diligenciados",HttpStatus.BAD_REQUEST);
        }
        if (employId.isPresent()) {
            Empleado _empleado = employId.get();
            _empleado.setFechaIngreso(empleado.getFechaIngreso());
            _empleado.setNombre(empleado.getNombre());
            _empleado.setSalario(empleado.getSalario());
            return ResponseEntity.ok(empleadoRepository.save(_empleado));
        } else {
            return ResponseEntity.ok("Empleado no existente");
        }
    }
}
