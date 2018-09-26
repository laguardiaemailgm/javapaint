package BetterThanPaint.Panels;

import BetterThanPaint.Mouse.MouseCoordinates;

import java.awt.*;
import java.awt.event.*;


public class CenterJPanel extends GenericPanels implements MouseListener, MouseMotionListener, KeyListener,ItemListener {

    // For drawing
    private MouseCoordinates mouseCoor = new MouseCoordinates();
    private Color drawingColor;

    // Needs getter and setters.
    // Maybe create classes like star, triangle and etc for easier drawing.
    private int shapeSize = 20;
    private int fontSize = 20;
    private Font font_user = new Font("Serif",Font.BOLD, fontSize);
    private FontMetrics fontMetrics_user;

    // Type = true;
    // Draw = False

    private boolean typeMode = false;

    // Rectangle true
    // Not Rectangle false
    private boolean isRectangle = false;


    private boolean isFill = false;

    public CenterJPanel() {
        super("Center Panel", null);

        fontMetrics_user = getFontMetrics(font_user);
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);

        setVisible(true);

    }

    public void setFill(boolean fill) {
        isFill = fill;
    }

    public boolean isRectangle() {
        return isRectangle;
    }

    public void setRectangle(boolean rectangle) {
        isRectangle = rectangle;
    }

    public boolean isTypeMode() {
        return typeMode;
    }

    public void setTypeMode(boolean typeMode) {
        this.typeMode = typeMode;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }


    public Color getDrawingColor() {
        return drawingColor;
    }

    public void setDrawingColor(Color drawingColor) {
        this.drawingColor = drawingColor;
    }

    public int getShapeSize() {
        return shapeSize;
    }

    public void setShapeSize(int shapeSize) {
        this.shapeSize = shapeSize;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseCoor.recordCoordinates(e.getX(), e.getY());
        Graphics2D gShapes = (Graphics2D) getGraphics();
        gShapes.setColor(drawingColor);

        if (!typeMode && !isRectangle) {
            //store the lastX and lastY values

            if(!isFill){
                notFillOval(gShapes);
            }
            else {
                fillOval(gShapes);
            }


        }
        else if(!typeMode && isRectangle)
        {
            //Draw Rect
            if(!isFill){
                notFillRec(gShapes);
            }
            else {
                fillRec(gShapes);
            }
        }
    }

    private void notFillOval(Graphics2D gShapes){

        gShapes.drawOval( (mouseCoor.getxCoor()-(shapeSize /2) ),
                (mouseCoor.getyCoor()-(shapeSize /2)),
                shapeSize, shapeSize);
    }

    private void fillOval(Graphics2D gShapes){

        gShapes.fillOval(mouseCoor.getxCoor()-(shapeSize /2), mouseCoor.getyCoor()-(shapeSize /2), shapeSize, shapeSize);
    }


    private void notFillRec(Graphics2D gShapes){

        gShapes.fillRect(mouseCoor.getxCoor()-((shapeSize /2)*2),
                mouseCoor.getyCoor()-(shapeSize /2),
                shapeSize*2,shapeSize);

    }

    private void fillRec(Graphics2D gShapes){

        gShapes.fillRect(mouseCoor.getxCoor()-((shapeSize /2)*2),
                mouseCoor.getyCoor()-(shapeSize /2),
                shapeSize*2,shapeSize);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        requestFocus();

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int xCoor = e.getX();
        int yCoor = e.getY();

        Graphics2D gShapes = (Graphics2D) getGraphics();

        gShapes.setColor(drawingColor);
        //gShapes.setStroke(new BasicStroke(shapeSize));

        if (!typeMode && !isRectangle) {
            //store the lastX and lastY values

            if(!isFill){
                notFillOval(gShapes);
            }
            else {
                fillOval(gShapes);
            }


        }
        else if(!typeMode && isRectangle)
        {

            if(!isFill){
                notFillRec(gShapes);
            }
            else {
                fillRec(gShapes);
            }
        }

        mouseCoor.recordCoordinates(xCoor,yCoor);

    }



    @Override
    public void mouseMoved(MouseEvent e) {

        //Records new location of mouse
        //mouseCoor.recordCoordinates(e.getX(),e.getY());
        //System.out.print("Test!!!");
    }

    //Need to be fixed
    @Override
    public void keyTyped(KeyEvent e) {

        if (typeMode){

            //Graphics2D keysd = (Graphics2D) getGraphics();
            Graphics keyUserPrint_ToScreen = getGraphics();

            keyUserPrint_ToScreen.setColor(drawingColor);

            font_user = new Font("Serif",Font.BOLD, fontSize);

            keyUserPrint_ToScreen.setFont(font_user);


            //circleShape.drawLine(mouseCoor.getxCoor(),mouseCoor.getyCoor(),xCoor,yCoor);

            String str_userInput = String.valueOf(e.getKeyChar());
            fontMetrics_user = getFontMetrics(font_user);

            keyUserPrint_ToScreen.drawString(str_userInput,mouseCoor.getxCoor(),mouseCoor.getyCoor());


            mouseCoor.recordCoordinates(mouseCoor.getxCoor()+fontMetrics_user.stringWidth(str_userInput),
                    mouseCoor.getyCoor());

            //System.out.println("DEBUG KEYSS!");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
