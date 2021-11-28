package com.company;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements KeyListener, MouseInputListener, MouseWheelListener {
    public static final int WIDTH=640;
    public static final int HEIGHT=360;

    private int cordX=0;
    private int cordY=0;
    private int posX=0;
    private int posY=0;
    private TileMap tm;

    int actualMouseButton;
    boolean mouseInScreen;
    private MapBuffer mb;

    private Image tempStoreImage;

    ArrayList<ArrayList<MapCell>> data;
    B1Connection conAl;
    public GamePanel(){
        super();
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        init();
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    private void init() {
        tm = new TileMap(20);
        tm.loadTiles("/grass.png");
        tempStoreImage=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);

        data=new ArrayList<>();
        for (int i = 0; i < HEIGHT/tm.getTileSize(); i++) {
            ArrayList<MapCell> temp=new ArrayList<>();
            for (int j = 0; j < WIDTH/tm.getTileSize(); j++) {
                temp.add(new MapCell());
            }
            data.add(temp);
        }
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(0).size(); j++) {
                MapCell tlNeighbour = null;
                MapCell tNeighbour = null;
                MapCell trNeighbour = null;
                MapCell lNeighbour = null;
                MapCell rNeighbour = null;
                MapCell blNeighbour = null;
                MapCell bNeighbour = null;
                MapCell brNeighbour = null;


                if ((i==0&&j==0)) {
                    //tlNeighbour=data.get(i-1).get(j-1);
                    rNeighbour=data.get(i).get(j+1);
                    bNeighbour=data.get(i+1).get(j);
                    brNeighbour=data.get(i+1).get(j+1);

                }
                else if ((i==0&&(j>0&&j<data.get(0).size()-1))){
                    //tNeighbour=data.get(i-1).get(j);
                    lNeighbour=data.get(i).get(j-1);
                    rNeighbour=data.get(i).get(j+1);
                    blNeighbour=data.get(i+1).get(j-1);
                    bNeighbour=data.get(i+1).get(j);
                    brNeighbour=data.get(i+1).get(j+1);

                }
                else if ((i==0&&j==data.get(0).size()-1)){
                    //trNeighbour=data.get(i-1).get(j+1);
                    lNeighbour=data.get(i).get(j-1);
                    blNeighbour=data.get(i+1).get(j-1);
                    bNeighbour=data.get(i+1).get(j);
                }
                else if (((i>0&&i<data.size()-1)&&j==0)){
                    //lNeighbour=data.get(i).get(j-1);
                    tNeighbour=data.get(i-1).get(j);
                    trNeighbour=data.get(i-1).get(j+1);
                    rNeighbour=data.get(i).get(j+1);
                    bNeighbour=data.get(i+1).get(j);
                    brNeighbour=data.get(i+1).get(j+1);
                }
                else if (((i>0&&i<data.size()-1)&&j==data.get(0).size()-1)){
                    //rNeighbour=data.get(i).get(j+1);
                    tlNeighbour=data.get(i-1).get(j-1);
                    tNeighbour=data.get(i-1).get(j);
                    lNeighbour=data.get(i).get(j-1);
                    blNeighbour=data.get(i+1).get(j-1);
                    bNeighbour=data.get(i+1).get(j);
                }
                else if ((i==data.size()-1&&j==0)){
                    //blNeighbour=data.get(i+1).get(j-1);
                    tNeighbour=data.get(i-1).get(j);
                    trNeighbour=data.get(i-1).get(j+1);
                    rNeighbour=data.get(i).get(j+1);
                }
                else if ((i==data.size()-1&&(j>0&&j<data.get(0).size()-1))){
                    //bNeighbour=data.get(i+1).get(j);
                    tlNeighbour=data.get(i-1).get(j-1);
                    tNeighbour=data.get(i-1).get(j);
                    trNeighbour=data.get(i-1).get(j+1);
                    lNeighbour=data.get(i).get(j-1);
                    rNeighbour=data.get(i).get(j+1);
                }
                else if ((i==data.size()-1&&j==data.get(0).size()-1)){
                    //brNeighbour=data.get(i+1).get(j+1);
                    tlNeighbour=data.get(i-1).get(j-1);
                    tNeighbour=data.get(i-1).get(j);
                    lNeighbour=data.get(i).get(j-1);
                }else{
                    tlNeighbour=data.get(i-1).get(j-1);
                    tNeighbour=data.get(i-1).get(j);
                    trNeighbour=data.get(i-1).get(j+1);
                    lNeighbour=data.get(i).get(j-1);
                    rNeighbour=data.get(i).get(j+1);
                    bNeighbour=data.get(i+1).get(j);
                    brNeighbour=data.get(i+1).get(j+1);
                    blNeighbour=data.get(i+1).get(j-1);

                }
                data.get(i).get(j).setNeighbours(tlNeighbour,tNeighbour,trNeighbour,
                        lNeighbour,rNeighbour,blNeighbour,bNeighbour,brNeighbour);

            }
        }
        conAl=new B1Connection(data);

        mb = new MapBuffer("map.txt", data);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        if (tempStoreImage!=null){
            g.drawImage(tempStoreImage,0,0, WIDTH,HEIGHT,null);
        }
        g.drawImage(tm.getTile(0,6).image,cordX,cordY, tm.getTileSize(),tm.getTileSize(),null);
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (cordX>0){
                    cordX -= tm.getTileSize();
                }
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (cordX<WIDTH-tm.getTileSize()) {
                    cordX += tm.getTileSize();
                }
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (cordY>0) {
                    cordY -= tm.getTileSize();
                }
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (cordY<HEIGHT-tm.getTileSize()) {
                    cordY += tm.getTileSize();
                }
                break;
            case KeyEvent.VK_ENTER:
                try{
                    select();
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                break;
        }
        repaint();
    }

    private void select(){

        Graphics2D g2d = (Graphics2D) tempStoreImage.getGraphics();
        //g2d.drawImage(tempStoreImage,0,0,null);

        posX=cordX/tm.getTileSize();
        posY=cordY/tm.getTileSize();

        //System.out.println("Tile:"+conAl.cordY+", "+conAl.cordX);
        data.get(posY).get(posX).setValue(1);
        conAl.setData(data);

        rec(posY,posX,g2d);
        rec(posY-1,posX-1,g2d);
        rec(posY-1,posX,g2d);
        rec(posY-1,posX+1,g2d);
        rec(posY,posX-1,g2d);
        rec(posY,posX+1,g2d);
        rec(posY+1,posX-1,g2d);
        rec(posY+1,posX,g2d);
        rec(posY+1,posX+1,g2d);

        mb.writeIntoDocument();
    }

    private void rec(int posY, int posX, Graphics2D g2d) {
        if(posX<0||posX>WIDTH/tm.getTileSize()-1||posY<0||posY>HEIGHT/tm.getTileSize()-1){
            return;
        }
        int cordX=posX*tm.getTileSize();
        int cordY=posY*tm.getTileSize();
        if (data.get(posY).get(posX).getValue()==0){
            return;
        }
        conAl.connectionAlgorithm(posY,posX, g2d);
        g2d.drawImage(tm.getTile(conAl.getCordY(),conAl.getCordX()).image, cordX,cordY,null);
    }

    @Override public void keyReleased(KeyEvent e) { }
    @Override public void mouseClicked(MouseEvent e) { }
    @Override
    public void mouseMoved(MouseEvent e) {
        if (mouseInScreen) {
            cordX = (e.getX() / tm.getTileSize()) * tm.getTileSize();
            cordY = (e.getY() / tm.getTileSize()) * tm.getTileSize();
            repaint();
        }
    }
    @Override public void mouseEntered(MouseEvent e) { mouseInScreen=true; }
    @Override public void mouseExited(MouseEvent e) { mouseInScreen=false; }
    @Override
    public void mousePressed(MouseEvent e) {
        actualMouseButton= e.getButton();
        act(e);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        act(e);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        act(e);
    }

    private void act(MouseEvent e) {
        if (actualMouseButton==MouseEvent.BUTTON1 && mouseInScreen){
            try{
                System.out.println("I:"+e.getX()+" "+e.getY());
                cordX=(e.getX()/tm.getTileSize())*tm.getTileSize();
                cordY=(e.getY()/tm.getTileSize())*tm.getTileSize();

                System.out.println("O:"+cordX+" "+cordY);
                select();
                repaint();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
