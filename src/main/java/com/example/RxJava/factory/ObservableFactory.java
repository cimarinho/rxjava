package com.example.RxJava.factory;

import rx.Observable;
import rx.Subscriber;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ObservableFactory {


    /**
     * @param resourceIdentification unique identification for a resource being called
     * @param supplier what will be executed
     */
    public static <T> Observable<T> create(String resourceIdentification, Supplier<T> supplier) {
        return Observable.create((Subscriber<? super T> s) -> {
            s.onNext(supplier.get());
            s.onCompleted();
        });
    }

    /**
     * @param supplier what will be executed
     * @param consumer that will flag resource identification
     */
    public static <T> Observable<T> create(Supplier<T> supplier,
                                           Consumer<T> consumer) {
        return Observable.create((Subscriber<? super T> s) -> {
            T supplied = supplier.get();
            consumer.accept(supplied);
            s.onNext(supplied);
            s.onCompleted();
        });
    }
}
