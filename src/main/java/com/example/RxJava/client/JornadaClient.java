package com.example.RxJava.client;

import com.example.RxJava.domain.Jornada;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JornadaClient {


    public Jornada getJornada(Long numeroJornada) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Jornada> request = new HttpEntity<>(new Jornada());
        ResponseEntity<Jornada> response = restTemplate
                .exchange("http://localhost:8080/jornadaControle/"+numeroJornada, HttpMethod.GET, request, Jornada.class);

        return response.getBody();
    }

}
