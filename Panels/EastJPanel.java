package BetterThanPaint.Panels;

import javax.swing.*;
import java.awt.*;


public class EastJPanel extends GenericPanels {

    private JLabel changeSizeSlider = new JLabel("Object size slider");
    private final int jSliderMin = 3; // Min val
    private final int jSliderMax = 144; // Max val
    private final int jSliderMStart = 25; //Staring val
    private JSlider sizeSlider = new JSlider(JSlider.HORIZONTAL,jSliderMin,jSliderMax,jSliderMStart);

    private JToggleButton rectangleOrCircle = new JToggleButton("Circle");


    private JToggleButton imageFill = new JToggleButton("Fill");

    public JToggleButton getEraser() {
        return eraser;
    }

    private JToggleButton eraser = new JToggleButton("No Erase");

    public JSlider getSizeSlider() {
        return sizeSlider;
    }

    public JToggleButton getRectangleOrCircle(){
        return rectangleOrCircle;
    }

    public JToggleButton getImageFill() {
        return imageFill;
    }


    public EastJPanel() {
        super("East Panel", new GridLayout(10,1));
        add(changeSizeSlider);
        add(sizeSlider);
        add(rectangleOrCircle);
        add(imageFill);
        add(eraser);

        setVisible(true);
    }
}
