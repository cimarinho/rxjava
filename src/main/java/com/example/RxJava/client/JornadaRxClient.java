package com.example.RxJava.client;

import com.example.RxJava.domain.Jornada;
import com.example.RxJava.factory.ExecutorFactory;
import com.example.RxJava.factory.ObservableFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;

@Component
public class JornadaRxClient {

    private static final ExecutorService EXECUTOR = ExecutorFactory.getExecutor();

    @Autowired
    JornadaClient jornadaClient;

    public Observable<Jornada> getJornada(Long jornada) {
        return ObservableFactory.create("http://localhost:8080/jornadaControle/1",() -> jornadaClient.getJornada(jornada))
                .subscribeOn(Schedulers.from(EXECUTOR));
    }
}
