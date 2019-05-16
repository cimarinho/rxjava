package com.example.RxJava.resource;

public abstract class AbstractResource implements Resource {

    private String uri;

    protected AbstractResource(String uri) {
        this.uri = uri;
    }

    @Override
    public String uri() {
        return uri;
    }
}
