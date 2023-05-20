package net.zincdev.engine.amber.world;

import net.zincdev.engine.amber.util.Identifier;
import net.zincdev.engine.amber.entity.Entity;
import net.zincdev.engine.amber.util.condition.Condition;
import net.zincdev.engine.amber.util.event.Event;
import net.zincdev.engine.amber.util.event.EventHandler;

import java.awt.*;
import java.util.ArrayList;

public class World {
    public float PPM = 100F;
    public final ArrayList<Entity> objects = new ArrayList<>();



    public World() {
        this.AddObject(new Entity(this, "TestImage") {
            @Override
            public void Update(float delta) {
                float movementSpeed = 2F;
                if(this.position.x < 6) this.position.x += delta * movementSpeed;
                else this.position.x = Math.min(6, this.position.x);
            }
        });
    }


    private void Update(float delta) {
        objects.forEach((obj) -> obj.Update(delta));
    }

    private void Render(Graphics2D g) {
        objects.forEach((obj) -> obj.$EventRender.Invoke(g));
    }

    public Entity AddObject(Entity object) {
        this.objects.add(object);
        return object;
    }


    private final Condition.Mono<Identifier> $ConditionIdentifierExisits = (id) -> {
        for(Entity object : this.objects) {
            if(object.id.equals(id)) return true;
        }
        return false;
    };
    public Identifier CreateIdentifier() {
        return Identifier.Random($ConditionIdentifierExisits);
    }



    public final EventHandler<Event.Mono<Float>> $EventUpdate = new EventHandler<Event.Mono<Float>>()
            .AddEventListeners(this::Update);
    public final EventHandler<Event.Mono<Graphics2D>> $EventRender = new EventHandler<Event.Mono<Graphics2D>>()
            .AddEventListeners(this::Render);
}
