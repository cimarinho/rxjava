package com.example.RxJava.facade;

import com.example.RxJava.domain.Jornada;
import com.example.RxJava.processor.JornadaProcessor;
import com.example.RxJava.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JornadaFacade {

    @Autowired
    JornadaService jornadaService;

    @Autowired
    private List<JornadaProcessor> processors;

    public Jornada getJornada(Long numerojornada) {
        return  applyPostProcessors(jornadaService.getJornada(numerojornada));
    }

    private Jornada applyPostProcessors(Jornada jornada) {
        processors.forEach(processor ->
                processor.postProcess(jornada)
        );
        return jornada;
    }

}
