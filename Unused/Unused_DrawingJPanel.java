package BetterThanPaint.Unused;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Unused_DrawingJPanel extends JPanel implements MouseListener, MouseMotionListener{

    private int circleSize = 40;
    private int lastX=0, lastY=0;
    private int times=0;
    protected static boolean drawShapes = false;

    public Unused_DrawingJPanel(){
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("X IS "+x+ "Y IS "+y);
        Graphics g = getGraphics();
        Graphics g2d = (Graphics2D)g;
        ((Graphics2D) g2d).setStroke(new BasicStroke(20));//use a variable that will have the line width
        g2d.setColor(Color.BLUE);  //use a variable that will have the drawing color
        g2d.drawLine(lastX, lastY, x, y);
        record(x,y);

    }
    protected void record(int x, int y){
        lastX = x;
        lastY = y;
    }
    public int getLastX(){
        return lastX;
    }
    public int getLastY(){
        return lastY;
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        record(e.getX(), e.getY());//need for the typing

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(drawShapes){
            times++;
            record(e.getX(), e.getY()); //store the lastX and lastY values
            //lastX = e.getX();
            //lastY = e.getY();
            Graphics g = getGraphics();
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.RED);
            //g2d.fillOval(lastX, lastY, circleSize, circleSize);
            // notice circle is NOT drawn around the click
            g2d.fillOval(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);
            //g2d.fillRect(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);//same idea for other shapes
            //draw a hollow circle
            //g2d.setStroke(new BasicStroke(10));
            //g2d.drawOval(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);
			/*
			//draw a triangle.... polygon
			int [] xs =  {lastX-(circleSize/2) ,lastX+(circleSize/2), lastX};
		    int [] ys = {lastY-(circleSize/2),lastY-(circleSize/2),lastY+(circleSize/2)};
			g2d.fillPolygon(xs , ys,3);
			*/
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        requestFocus();//need for typing
        record(e.getX(), e.getY());//need for typing

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}

