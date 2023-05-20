package net.zincdev.engine.amber.math;

public class Vec2i {
    public static Vec2i Zero() {
        return new Vec2i(0, 0);
    }
    public int x, y;
    public Vec2i(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return this.x;
    }
    public Vec2i setX(int x) {
        this.x = x;
        return this;
    }
    public float getY() {
        return this.y;
    }
    public Vec2i getY(int y) {
        this.y = y;
        return this;
    }
    public Vec2i translate(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }
    public Vec2i translate(Vec2i v) {
        return this.translate(v.x, v.y);
    }
    public Vec2i scale(int x, int y) {
        this.x *= x;
        this.y *= y;
        return this;
    }
    public Vec2i scale(Vec2i v) {
        return this.scale(v.x, v.y);
    }
    public Vec2i scale(int s) {
        return this.scale(s, s);
    }
    public Vec2i invert() {
        return this.scale(-1, -1);
    }
}
