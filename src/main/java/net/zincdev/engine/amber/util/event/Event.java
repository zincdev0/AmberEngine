package net.zincdev.engine.amber.util.event;

public interface Event {
    interface Void extends Event {
        void Invoke();
    }

    interface Mono<T> extends Event {
        void Invoke(T t);
    }
}
