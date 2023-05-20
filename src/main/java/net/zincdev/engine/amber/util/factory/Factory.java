package net.zincdev.engine.amber.util.factory;

public interface Factory {
    interface Void<T> extends Factory {
        T Create();
    }

    interface Mono<T, U> extends Factory {
        T Create(U u);
    }
}
