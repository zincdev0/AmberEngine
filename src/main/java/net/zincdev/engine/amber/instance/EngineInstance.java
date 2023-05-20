package net.zincdev.engine.amber.instance;

import net.zincdev.engine.amber.util.event.Event;
import net.zincdev.engine.amber.util.event.EventHandler;
import net.zincdev.engine.amber.graphics.ImageModifier;
import net.zincdev.engine.amber.math.Vec2f;
import net.zincdev.engine.amber.world.World;
import net.zincdev.engine.amber.entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class EngineInstance {
    public final EnginePanel PANEL;
    public final EngineFrame FRAME;
    public final EngineThread THREAD;
    public World world = new World();

    public float framesPerSecond = 60F;
    public boolean closing = false;


    public EngineInstance(EngineImplementation impl) {
        this.PANEL = new EnginePanel(this);

        this.FRAME = impl.CreateFrame(this);
        this.FRAME.setContentPane(PANEL);
        this.FRAME.setVisible(true);

        this.THREAD = new EngineThread(this);
    }

    protected void Update(float delta) {

    }
    protected void Render(Graphics g) {

    }
    protected void WindowClosing() {
        System.out.println("Closing update thread...");
        this.closing = true;
        this.THREAD.interrupt();
    }
    protected void FileDropped(File file) {
        System.out.println("Accepting dropped file {" + file.getAbsolutePath() + "}");
        try {
            ImageModifier img = new ImageModifier(ImageIO.read(file));
            Entity object = this.world.AddObject(new Entity(this.world, img.result));
            object.scale = new Vec2f(img.result.getWidth() / this.world.PPM, img.result.getHeight() / this.world.PPM);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    public final EventHandler<Event.Mono<Float>> $EventUpdate = new EventHandler<Event.Mono<Float>>()
            .AddEventListeners(this::Update)
            .AddEventLoaders(this.world.$EventUpdate);
    public final EventHandler<Event.Mono<Graphics2D>> $EventRender = new EventHandler<Event.Mono<Graphics2D>>()
            .AddEventListeners(this::Render)
            .AddEventLoaders(this.world.$EventRender);
    public final EventHandler<Event.Void> $EventWindowClosed = new EventHandler<Event.Void>()
            .AddEventListeners(this::WindowClosing);
    public final EventHandler<Event.Mono<File>> $EventFileDropped = new EventHandler<Event.Mono<File>>()
            .AddEventListeners(this::FileDropped);
}
