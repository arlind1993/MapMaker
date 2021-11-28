package com.company;

import java.awt.*;
import java.util.ArrayList;

public class B1Connection {
    public int cordX;
    public int cordY;
    public ArrayList<ArrayList<MapCell>> data;

    public B1Connection(ArrayList<ArrayList<MapCell>> data){
        this.data=data;
    }

    public void connectionAlgorithm(int i, int j, Graphics2D g2d){
        MapCell current=data.get(i).get(j);
        cordX=6;
        cordY=0;
        current.showNeighbours();
        if (empty(new MapCell[]{current.getTNeighbour(), current.getLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getRNeighbour(), current.getBNeighbour(), current.getBRNeighbour()})
        ){
            cordX=0;
            cordY=0;
        }else if(empty(new MapCell[]{current.getTNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=1;
            cordY=0;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getLNeighbour(),current.getBLNeighbour(),current.getBNeighbour()})
        ){
            cordX=2;
            cordY=0;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getBNeighbour(),})
        ){
            cordX=3;
            cordY=0;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getBNeighbour(),current.getRNeighbour()})
        ){
            cordX=4;
            cordY=0;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getRNeighbour(),current.getBLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getLNeighbour(),current.getBNeighbour()})
        ){
            cordX=5;
            cordY=0;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})) {
            cordX=6;
            cordY=0;
        }else if(empty(new MapCell[]{current.getLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getTRNeighbour(),current.getRNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=0;
            cordY=1;
        }else if(inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=1;
            cordY=1;
        }else if(empty(new MapCell[]{current.getRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getLNeighbour(),current.getBLNeighbour(),current.getBNeighbour()})
        ){
            cordX=2;
            cordY=1;
        }else if(empty(new MapCell[]{current.getLNeighbour(),current.getRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getBNeighbour()})
        ){
            cordX=3;
            cordY=1;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getRNeighbour(),current.getBLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getBNeighbour()})
        ){
            cordX=4;
            cordY=1;
        }else if(empty(new MapCell[]{current.getTRNeighbour(),current.getLNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getRNeighbour(),current.getBNeighbour()})
        ){
            cordX=5;
            cordY=1;
        }else if(empty(new MapCell[]{current.getLNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getTRNeighbour(),current.getRNeighbour()})
        ){
            cordX=0;
            cordY=2;
        }else if(empty(new MapCell[]{current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),})
        ){
            cordX=1;
            cordY=2;
        }else if(empty(new MapCell[]{current.getRNeighbour(),current.getBNeighbour(),}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getLNeighbour()})
        ){
            cordX=2;
            cordY=2;
        }else if(empty(new MapCell[]{current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour()})
        ){
            cordX=3;
            cordY=2;
        }else if(empty(new MapCell[]{current.getTRNeighbour(),current.getLNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getRNeighbour()})
        ){
            cordX=4;
            cordY=2;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getRNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getLNeighbour()})
        ){
            cordX=5;
            cordY=2;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getRNeighbour()})
        ){
            cordX=0;
            cordY=3;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getLNeighbour(),current.getRNeighbour()})
        ){
            cordX=1;
            cordY=3;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getRNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getLNeighbour()})
        ){
            cordX=2;
            cordY=3;
        }else if(empty(new MapCell[]{current.getLNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getTRNeighbour(),current.getRNeighbour(),current.getBNeighbour()})
        ){
            cordX=3;
            cordY=3;
        }else if(empty(new MapCell[]{current.getRNeighbour(),current.getBLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getLNeighbour(),current.getBNeighbour()})
        ){
            cordX=4;
            cordY=3;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour()})
        ){
            cordX=5;
            cordY=3;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getBLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=6;
            cordY=3;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getBLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=0;
            cordY=4;
        }else if(empty(new MapCell[]{current.getTNeighbour(),current.getBLNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour()})
        ){
            cordX=1;
            cordY=4;
        }else if(empty(new MapCell[]{current.getBLNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour()})
        ){
            cordX=2;
            cordY=4;
        }else if(empty(new MapCell[]{current.getTRNeighbour(),current.getLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getRNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=3;
            cordY=4;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getBLNeighbour(),current.getBNeighbour()})
        ){
            cordX=4;
            cordY=4;
        }else if(empty(new MapCell[]{current.getTRNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour()})
        ){
            cordX=5;
            cordY=4;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour()})
        ){
            cordX=6;
            cordY=4;
        }else if(empty(new MapCell[]{current.getTRNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour()})
        ){
            cordX=0;
            cordY=5;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getTRNeighbour(),current.getBNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour()})
        ){
            cordX=1;
            cordY=5;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getTRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=2;
            cordY=5;
        }else if(empty(new MapCell[]{current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour()})
        ){
            cordX=3;
            cordY=5;
        }else if(empty(new MapCell[]{current.getBLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=4;
            cordY=5;
        }else if(empty(new MapCell[]{current.getTRNeighbour(),current.getBLNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour()})
        ){
            cordX=5;
            cordY=5;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getBLNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour()})
        ){
            cordX=6;
            cordY=5;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour()})
        ){
            cordX=0;
            cordY=6;
        }else if(empty(new MapCell[]{current.getTRNeighbour(),current.getBLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=1;
            cordY=6;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getTRNeighbour(),current.getBLNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour()})
        ){
            cordX=2;
            cordY=6;
        }else if(empty(new MapCell[]{current.getTRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTLNeighbour(),current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=3;
            cordY=6;
        }else if(empty(new MapCell[]{current.getTLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getTRNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=4;
            cordY=6;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getTRNeighbour(),current.getBRNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBLNeighbour(),current.getBNeighbour()})
        ){
            cordX=5;
            cordY=6;
        }else if(empty(new MapCell[]{current.getTLNeighbour(),current.getTRNeighbour(),current.getBLNeighbour()}) &&
                inBlock1Margin(new MapCell[]{current.getTNeighbour(),current.getLNeighbour(),current.getRNeighbour(),current.getBNeighbour(),current.getBRNeighbour()})
        ){
            cordX=6;
            cordY=6;
        }
        else {
            cordX=6;
            cordY=0;
        }

            current.setValue(cordY * 7 + cordX + 10);

    }

    private boolean inBlock1Margin(MapCell[] mapCells) {
        boolean res;
        for (MapCell mapCell: mapCells) {
            res=inBlock1Margin(mapCell);
            if (!res){
                return false;
            }
        }
        return true;
    }

    private boolean empty(MapCell[] mapCells) {
        boolean res;
        for (MapCell mapCell: mapCells) {
            res=empty(mapCell);
            if (!res){
                return false;
            }
        }
        return true;
    }


    private boolean inBlock1Margin(MapCell mapCellNeighbour) {
        if (mapCellNeighbour==null){
            return true;
        }
        return (mapCellNeighbour.getValue()>=10 && mapCellNeighbour.getValue()<=58);
    }
    private boolean empty(MapCell mapCellNeighbour){
        if (mapCellNeighbour==null){
            return false;
        }
        return (mapCellNeighbour.getValue()==0);
    }

    public void setData(ArrayList<ArrayList<MapCell>> data) {
        this.data = data;
    }

    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }
}
