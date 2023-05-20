package net.zincdev.engine.amber.util.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventHandler<T extends Event> {
    public final List<T> LISTENERS = new ArrayList<>();
    public final List<EventHandler<T>> LOADS = new ArrayList<>();


    public EventHandler<T> AddEventListeners(T... listeners) {
        this.LISTENERS.addAll(List.of(listeners));
        return this;
    }
    public EventHandler<T> AddEventLoaders(EventHandler<T>... loads) {
        this.LOADS.addAll(List.of(loads));
        return this;
    }
    public List<T> GetEvents() {
        List<T> list = new ArrayList<>(this.LISTENERS);
        this.LOADS.forEach((listeners) -> list.addAll(listeners.GetEvents()));
        return list;
    }
    public void InvokeEvents(Consumer<? super T> invoker) {
        this.GetEvents().forEach(invoker);
    }
}
