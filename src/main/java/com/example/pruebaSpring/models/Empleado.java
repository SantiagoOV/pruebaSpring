package com.example.pruebaSpring.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private Date fecha_ingreso;

    @Column(name="nombre", length = 50)
    private String nombre;
    private Integer salario;

    @OneToOne(mappedBy = "empleado")
    private Solicitud solicitud;    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fecha_ingreso;
    }

    public void setFechaIngreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }
}
