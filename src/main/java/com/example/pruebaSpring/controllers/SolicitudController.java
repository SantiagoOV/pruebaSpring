package com.example.pruebaSpring.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.pruebaSpring.services.SolicitudService;
import com.example.pruebaSpring.models.Solicitud;

@RestController
public class SolicitudController {
    @Autowired
    SolicitudService solicitudService;

    @GetMapping(value="application")
    public ArrayList<Solicitud> getApplication() {
        return this.solicitudService.getListApplication();
    }

    @GetMapping(value="GetApplicationByCode", params = "codigo")
    public ArrayList<Solicitud> getApplication(@RequestParam String codigo) {
        return this.solicitudService.getByCodigo(codigo);
    }

    @PostMapping(value = "CreateApplication")
    public Solicitud saveApplication(@RequestBody Solicitud solicitud) {
        return this.solicitudService.saveApplication(solicitud);
    }
}
