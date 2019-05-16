package com.example.RxJava.processor;

import com.example.RxJava.domain.Jornada;
import org.springframework.stereotype.Component;

@Component
public class ControleProcessor implements JornadaProcessor {

    @Override
    public void postProcess(Jornada jornada) {
        System.out.println("ControleProcessor");
        jornada.setValorControle("SETADO ControleProcessorimplements");

    }
}

