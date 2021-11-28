package com.company;

import java.awt.image.BufferedImage;

public class Tile {
    public static final int NORMAL = 0;
    public static final int BLOCK = 1;

    BufferedImage image;

    int actualType;

    public Tile(BufferedImage image, int actualType) {
        this.image=image;

        this.actualType=actualType;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getActualType() {
        return actualType;
    }
}
