package net.zincdev.engine.amber.math;

public class Vec2f {
    public static Vec2f Zero() {
        return new Vec2f(0, 0);
    }
    public float x, y;
    public Vec2f(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return this.x;
    }
    public Vec2f setX(float x) {
        this.x = x;
        return this;
    }
    public float getY() {
        return this.y;
    }
    public Vec2f getY(float y) {
        this.y = y;
        return this;
    }
    public Vec2f translate(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }
    public Vec2f translate(Vec2f v) {
        return this.translate(v.x, v.y);
    }
    public Vec2f scale(float x, float y) {
        this.x *= x;
        this.y *= y;
        return this;
    }
    public Vec2f scale(Vec2f v) {
        return this.scale(v.x, v.y);
    }
    public Vec2f scale(float s) {
        return this.scale(s, s);
    }
    public Vec2f invert() {
        return this.scale(-1F, -1F);
    }
    public Vec2i intify() {
        return new Vec2i((int)this.x, (int)this.y);
    }
    public Vec2f clone() {
        return new Vec2f(this.x, this.y);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
