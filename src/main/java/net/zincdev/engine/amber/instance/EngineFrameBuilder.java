package net.zincdev.engine.amber.instance;

import java.awt.*;
import java.beans.BeanProperty;

public class EngineFrameBuilder {
    private final EngineFrame frame;

    public EngineFrameBuilder(String name, EngineInstance parent) {
        this.frame = new EngineFrame(name, parent);

    }

    public EngineFrameBuilder Title(String title) {
        this.frame.setTitle(title);
        return this;
    }

    public EngineFrameBuilder Size(Dimension size) {
        this.frame.setSize(size);
        return this;
    }

    public EngineFrameBuilder Location(Point location) {
        this.frame.setLocation(location);
        return this;
    }

    @BeanProperty(preferred = true, enumerationValues = {"WindowConstants.DO_NOTHING_ON_CLOSE", "WindowConstants.HIDE_ON_CLOSE", "WindowConstants.DISPOSE_ON_CLOSE"}, description = "The dialog's default close operation.")
    public EngineFrameBuilder DefaultCloseOperation(int closeOperation) {
        this.frame.setDefaultCloseOperation(closeOperation);
        return this;
    }

    public EngineFrameBuilder Centered() {
        this.frame.setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2-this.frame.getWidth()/2), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2-this.frame.getHeight()/2));
        return this;
    }

    public EngineFrame Build() {
        return frame;
    }
}
