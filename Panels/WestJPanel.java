package BetterThanPaint.Panels;

import javax.swing.*;
import java.awt.*;


public class WestJPanel extends GenericPanels {

    public JToggleButton getBtn_TextorPaint() {
        return btn_TextorPaint;
    }
    public JButton getBtn_ChangeColor() {
        return btn_ChangeColor;
    }

    private JToggleButton btn_TextorPaint = new JToggleButton("Draw Mode");

    private JButton btn_ChangeColor = new JButton("Change Draw color");


    public WestJPanel() {

        super("West Panel", new GridLayout(10,1));

        add(btn_TextorPaint);
        add(btn_ChangeColor);


        setVisible(true);
    }

}
