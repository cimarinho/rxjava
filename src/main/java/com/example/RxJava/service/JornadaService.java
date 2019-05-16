package com.example.RxJava.service;

import com.example.RxJava.client.JornadaRxClient;
import com.example.RxJava.domain.ControleJornada;
import com.example.RxJava.domain.Jornada;
import com.example.RxJava.domain.Simulacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class JornadaService {

    @Autowired
    JornadaRxClient jornadaRxClient;

    public Jornada getJornada(Long numeroJornada) {
        Jornada jornada = jornadaRxClient.getJornada(numeroJornada)
                .toBlocking()
                .single();

        return addJornadaELista(jornada);
    }

    private Jornada addJornadaELista(Jornada jornada) {
        Observable<ControleJornada> controleJornadaObs = Observable.just(getControleJornada());
        Observable<Simulacao> simulacaoObs = Observable.just(getSimulacao());
        return Observable.zip(controleJornadaObs, simulacaoObs, (controleJornada, simulacao) -> {
            jornada.setControleJornada(controleJornada);
            jornada.setSimulacao(simulacao);
            return jornada;
        }).toBlocking().single();
    }


    Simulacao getSimulacao(){
        Simulacao simulacao = new Simulacao();
        simulacao.setSimulacao("simulacao");
        return simulacao;
    }

    ControleJornada getControleJornada(){
        ControleJornada controleJornada = new ControleJornada();
        controleJornada.setControle("controleJornada");
        return controleJornada;
    }

}
