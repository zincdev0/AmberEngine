package net.zincdev.engine.amber.util.condition;

public interface Condition {
    interface Void extends Condition {
        boolean Apply();
    }

    interface Mono<T> extends Condition {
        boolean Apply(T t);
    }
}
