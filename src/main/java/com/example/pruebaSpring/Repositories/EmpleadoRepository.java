package com.example.pruebaSpring.Repositories;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.example.pruebaSpring.models.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    public default boolean UpdateValid(Empleado empleado){
        Date fecha_ingreso = empleado.getFechaIngreso();
        String nombre = empleado.getNombre();
        Integer salario = empleado.getSalario();
        if (fecha_ingreso != null && nombre != null && salario != null) {
            return false;
        }else{
            return true;
        }
    } 

    public abstract ArrayList<Empleado> findByNombre(String nombre);    
}
