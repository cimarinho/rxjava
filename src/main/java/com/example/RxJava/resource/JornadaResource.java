package com.example.RxJava.resource;

public class JornadaResource extends AbstractResource {

    private JornadaResource(String uri) {
        super(uri);
    }

    public static JornadaResource jornadaById(Long idJornada) {
        return new JornadaResource("/jornada/"+idJornada);
    }

}
