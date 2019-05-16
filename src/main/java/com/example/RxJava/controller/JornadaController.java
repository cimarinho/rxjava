package com.example.RxJava.controller;

import com.example.RxJava.domain.Jornada;
import com.example.RxJava.facade.JornadaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JornadaController {

    @Autowired
    JornadaFacade jornadaFacade;

    @RequestMapping(value = "/jornada/{numerojornada}", method = RequestMethod.GET)
    public Jornada getJornada(@PathVariable Long numerojornada) {
        return jornadaFacade.getJornada(numerojornada);
    }

    @RequestMapping(value = "/jornadaControle/{numerojornada}", method = RequestMethod.GET)
    public Jornada jornadaControle(@PathVariable Long numerojornada) {

        Jornada jornada = new Jornada();
        jornada.setServico("jornadaControle");

        return jornada;
    }


}
