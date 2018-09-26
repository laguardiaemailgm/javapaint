package BetterThanPaint.Mouse;


public class MouseCoordinates {
    private int xCoor = 0;
    private int yCoor = 0;

    public MouseCoordinates() {
        //Do nothing
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
    public void recordCoordinates(int xCoor,int yCoor){
        setxCoor(xCoor);
        setyCoor(yCoor);
    }
}
