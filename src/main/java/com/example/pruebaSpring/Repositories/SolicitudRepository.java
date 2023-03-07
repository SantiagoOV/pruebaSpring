package com.example.pruebaSpring.Repositories;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.pruebaSpring.models.Empleado;
import com.example.pruebaSpring.models.Solicitud;

public interface SolicitudRepository extends CrudRepository<Solicitud, Long> {
    public default boolean UpdateValid(Solicitud solicitud){
        String codigo = solicitud.getCodigo();
        String descripcion = solicitud.getDescripcion();
        String resumen = solicitud.getResumen();
        Empleado idEmpleado = solicitud.getEmpleado();
        if (codigo != null && descripcion != null && resumen != null && idEmpleado.getId() != null) {
            return false;
        }else{
            return true;
        }
    } 
    public abstract ArrayList<Solicitud> findByCodigo(String codigo);  
}
