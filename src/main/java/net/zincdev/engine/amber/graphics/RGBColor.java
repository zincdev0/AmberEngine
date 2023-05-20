package net.zincdev.engine.amber.graphics;

public class RGBColor {
    public int r, g, b;

    public RGBColor(int rgb) {
        this.r = (rgb >> 16) & 0xFF;
        this.g = (rgb >> 8) & 0xFF;
        this.b = rgb & 0xFF;
    }
}
