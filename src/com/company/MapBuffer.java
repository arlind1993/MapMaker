package com.company;

import java.io.*;
import java.util.ArrayList;

public class MapBuffer {
    private int cols;
    private int rows;
    private ArrayList<ArrayList<MapCell>> cells;

    private final String fileName;

    public MapBuffer(String fileName, ArrayList<ArrayList<MapCell>> data) {
        this.fileName=fileName;
        this.cols=data.get(0).size();
        this.rows=data.size();
        this.cells=data;
    }

    public void readFromDocument() {
        try{
            FileReader fr=new FileReader(fileName);
            int i;
            while((i=fr.read())!=-1)
                System.out.print((char)i);
            fr.close();
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Success...");
    }

    public void writeIntoDocument(){
        try{
            FileWriter fw=new FileWriter(fileName);
            fw.write(cols+" "+rows+"\n");
            for (ArrayList<MapCell> row : cells) {
                String rowString="";
                for (MapCell cell : row) {
                    rowString+=cell.getValue()+" ";
                }
                fw.write(rowString+"\n");
            }
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }

    }


}
