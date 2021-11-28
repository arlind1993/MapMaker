package com.company;

public class MapCell {
    private MapCell[] neighbours=new MapCell[8];
    private Integer value;

    public MapCell(){
        value=0;
    }

    public MapCell(int value){
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MapCell[] getNeighbours() {
        return neighbours;
    }

    public MapCell getTLNeighbour() {
        return neighbours[0];
    }
    public MapCell getTNeighbour() {
        return neighbours[1];
    }
    public MapCell getTRNeighbour() {
        return neighbours[2];
    }
    public MapCell getLNeighbour() {
        return neighbours[3];
    }
    public MapCell getRNeighbour() {
        return neighbours[4];
    }
    public MapCell getBLNeighbour() {
        return neighbours[5];
    }
    public MapCell getBNeighbour() {
        return neighbours[6];
    }
    public MapCell getBRNeighbour() {
        return neighbours[7];
    }

    public void setNeighbours(MapCell[] neighbours) {
        this.neighbours = neighbours;
    }

    public void setTLNeighbour(MapCell tlNeighbour){
        neighbours[0]=tlNeighbour;
        if (tlNeighbour!=null)
        tlNeighbour.neighbours[7]=this;
    }
    public void setTNeighbour(MapCell tNeighbour){
        neighbours[1]=tNeighbour;
        if (tNeighbour!=null)
        tNeighbour.neighbours[6]=this;
    }
    public void setTRNeighbour(MapCell trNeighbour){
        neighbours[2]=trNeighbour;
        if (trNeighbour!=null)
        trNeighbour.neighbours[5]=this;
    }
    public void setLNeighbour(MapCell lNeighbour){
        neighbours[3]=lNeighbour;
        if (lNeighbour!=null)
        lNeighbour.neighbours[4]=this;
    }
    public void setRNeighbour(MapCell rNeighbour){
        neighbours[4]=rNeighbour;
        if (rNeighbour!=null)
        rNeighbour.neighbours[3]=this;
    }
    public void setBLNeighbour(MapCell blNeighbour){
        neighbours[5]=blNeighbour;
        if (blNeighbour!=null)
        blNeighbour.neighbours[2]=this;
    }
    public void setBNeighbour(MapCell bNeighbour){
        neighbours[6]=bNeighbour;
        if (bNeighbour!=null)
        bNeighbour.neighbours[1]=this;
    }
    public void setBRNeighbour(MapCell brNeighbour){
        neighbours[7]=brNeighbour;
        if (brNeighbour!=null)
        brNeighbour.neighbours[0]=this;
    }

    public void setNeighbours(MapCell tlNeighbour, MapCell tNeighbour,
                              MapCell trNeighbour, MapCell lNeighbour,
                              MapCell rNeighbour, MapCell blNeighbour,
                              MapCell bNeighbour, MapCell brNeighbour) {
        setTLNeighbour(tlNeighbour);
        setTNeighbour(tNeighbour);
        setTRNeighbour(trNeighbour);
        setLNeighbour(lNeighbour);
        setRNeighbour(rNeighbour);
        setBLNeighbour(blNeighbour);
        setBNeighbour(bNeighbour);
        setBRNeighbour(brNeighbour);
    }

    public void showNeighbours() {

        System.out.println(format(getTLNeighbour()) + " " + format(getTNeighbour()) + " " + format(getTRNeighbour()) + "\n" +
                format(getLNeighbour()) + " " + format(this) + " " + format(getRNeighbour()) + "\n" +
                format(getBLNeighbour()) + " " + format(getBNeighbour()) + " " + format(getBRNeighbour()));

    }

    private String format(MapCell n){
        if(n==null){
            return "^";
        }
        return n.getValue().toString();
    }
}
