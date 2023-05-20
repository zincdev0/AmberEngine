package net.zincdev.engine.amber.graphics;

import java.awt.image.BufferedImage;

public class ImageModifier {
    public BufferedImage result;

    public ImageModifier(BufferedImage image) {
        result = image;
        //result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < image.getWidth(); i++) {
            for(int j = 0; j < image.getHeight(); j++) {
                RGBColor rgb = new RGBColor(image.getRGB(i, j));
                result.setRGB(rgb.r, rgb.g, rgb.b);
            }
        }
    }
}
