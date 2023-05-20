package net.zincdev.engine.amber.instance;

import net.zincdev.engine.amber.util.factory.Factory;

public interface EngineImplementation {
    Factory.Mono<EngineFrame, EngineInstance> FrameFactory();
    default EngineFrame CreateFrame(EngineInstance parent) {
        return this.FrameFactory().Create(parent);
    }
    EngineInstance Instance();
}
