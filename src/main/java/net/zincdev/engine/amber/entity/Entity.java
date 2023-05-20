package net.zincdev.engine.amber.entity;

import net.zincdev.engine.amber.math.Vec2f;
import net.zincdev.engine.amber.math.Vec2i;
import net.zincdev.engine.amber.util.Identifier;
import net.zincdev.engine.amber.util.event.Event;
import net.zincdev.engine.amber.world.World;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Entity {
    public World world;
    public final Identifier id;
    public Vec2f position = Vec2f.Zero(), scale = new Vec2f(1, 1);
    private BufferedImage texture = null;

    public Entity(World world, String texture) {
        this(world, world.CreateIdentifier(), texture);
    }
    public Entity(World world, Identifier id, String texture) {
        this.world = world;
        this.id = id;
        try {
            this.texture = ImageIO.read(new File("src/main/resources/assets/base/" + texture + ".png"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Entity(World world, BufferedImage texture) {
        this.world = world;
        this.id = world.CreateIdentifier();
        this.texture = texture;
    }

    public void Update(float delta) {

    }

    public final Event.Mono<Graphics2D> $EventRender = this::Render;
    private void Render(Graphics g) {
        g.drawImage(this.texture,
                this.ScreenPosition().x,
                this.ScreenPosition().y,
                this.ScreenPosition().x + this.ScreenScale().x,
                this.ScreenPosition().y + this.ScreenScale().y,
                0, 0, this.texture.getWidth(), this.texture.getHeight(),
                new Color(0, 0, 0, 0), null);
    }

    public Vec2i ScreenPosition() {
        return this.position.clone().scale(world.PPM).intify();
    }
    public Vec2i ScreenScale() {
        return this.scale.clone().scale(world.PPM).intify();
    }
}
