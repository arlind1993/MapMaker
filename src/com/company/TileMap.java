package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class TileMap {
    private final int tileSize;
    private BufferedImage tileset;
    private int numTileCols;
    private int numTilesRows;
    private Tile[][] tiles;


    public TileMap(int tileSize) {
        this.tileSize = tileSize;
    }
    public void loadTiles(String s){
        try {
            tileset= ImageIO.read(getClass().getResourceAsStream(s));
            numTileCols=tileset.getWidth()/tileSize;
            numTilesRows=tileset.getHeight()/tileSize;
            tiles=new Tile[numTilesRows][numTileCols];

            BufferedImage subImage;
            for (int i = 0; i < numTilesRows; i++) {
                for (int j = 0; j < numTileCols; j++) {
                    subImage=tileset.getSubimage(j*tileSize,i*tileSize,tileSize,tileSize);
                    tiles[i][j]=new Tile(subImage, Tile.NORMAL);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }
    public Tile getTile(int i,int j) {

        return tiles[i][j];
    }

    public BufferedImage getTileset() {
        return tileset;
    }

    public int getNumTileCols() {
        return numTileCols;
    }

    public int getNumTilesRows() {
        return numTilesRows;
    }

    public int getTileSize() {
        return tileSize;
    }
}
