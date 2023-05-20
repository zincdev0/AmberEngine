package net.zincdev.engine.amber.instance;

import net.zincdev.engine.amber.util.event.Event;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EngineFrame extends JFrame {
    private final EngineInstance PARENT;

    public EngineFrame(String title, EngineInstance parent) {
        super(title);
        this.PARENT = parent;

        this.addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) {
                PARENT.$EventWindowClosed.InvokeEvents(Event.Void::Invoke);
            }
        });
    }
}
