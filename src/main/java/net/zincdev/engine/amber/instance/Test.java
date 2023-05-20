package net.zincdev.engine.amber.instance;

import net.zincdev.engine.amber.util.factory.Factory;

import javax.swing.*;
import java.awt.*;

public class Test implements EngineImplementation {
    final EngineInstance INSTANCE = new EngineInstance(this);

    public static void main(String[] args) {
        new Test();
    }

    @Override public Factory.Mono<EngineFrame, EngineInstance> FrameFactory() {
        return (parent) -> new EngineFrameBuilder("Amber Engine", parent).DefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE).Size(new Dimension(768, 512)).Centered().Build();
    }

    @Override public EngineInstance Instance() {
        return INSTANCE;
    }
}
