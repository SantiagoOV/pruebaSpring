package com.example.pruebaSpring.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebaSpring.Repositories.SolicitudRepository;
import com.example.pruebaSpring.models.Solicitud;

@Service
public class SolicitudService {
    @Autowired
    SolicitudRepository solicitudRepository;

    public ArrayList<Solicitud> getListApplication() {
        return (ArrayList<Solicitud>) solicitudRepository.findAll();
    }

    public ArrayList<Solicitud> getByCodigo(String codigo) {
        return solicitudRepository.findByCodigo(codigo);
    }

    public Solicitud saveApplication(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }
}
