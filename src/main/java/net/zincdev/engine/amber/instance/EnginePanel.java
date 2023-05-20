package net.zincdev.engine.amber.instance;

import net.zincdev.engine.amber.instance.handling.DropTargetHandler;
import net.zincdev.engine.amber.instance.handling.MouseHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;

public class EnginePanel extends JPanel {
    private final EngineInstance PARENT;

    public EnginePanel(EngineInstance parent) {
        super();
        this.PARENT = parent;


        this.setBackground(new Color(196, 64, 196));
        this.addMouseListener(new MouseHandler());
        new DropTarget(this, new DropTargetHandler(this.PARENT));
    }
    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.PARENT.$EventRender.InvokeEvents((event) -> event.Invoke((Graphics2D)g));
    }
}
