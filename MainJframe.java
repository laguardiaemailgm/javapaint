package BetterThanPaint;

import BetterThanPaint.Panels.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class MainJframe extends JFrame {

    GenericPanels[] jpanelArray;

    public MainJframe(){

        NorthJPanel northPan = new NorthJPanel();
        SouthJPanel southPan = new SouthJPanel();
        EastJPanel eastPan = new EastJPanel();
        WestJPanel westPan = new WestJPanel();
        CenterJPanel centerPan = new CenterJPanel();

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(1000,600));

        // Specific Panel layout inside the array
        //                                     0     ,   1    ,  2    ,   3   ,   4
        jpanelArray = new GenericPanels[] {northPan, southPan, eastPan, westPan, centerPan};


        //Set layout
        mainPanel.setLayout(new BorderLayout());

        // North and South color
        jpanelArray[0].setBackground(Color.red);
        jpanelArray[1].setBackground(Color.red);

        // East and West Color
        jpanelArray[2].setBackground(Color.GRAY);
        jpanelArray[3].setBackground(Color.GRAY);

        //Center Color
        jpanelArray[4].setBackground(Color.WHITE);

        // Add to this frame instance
        mainPanel.add(northPan, BorderLayout.NORTH);
        mainPanel.add(southPan, BorderLayout.SOUTH);
        mainPanel.add(eastPan, BorderLayout.EAST);
        mainPanel.add(westPan, BorderLayout.WEST);
        mainPanel.add(centerPan, BorderLayout.CENTER);

        //Add mainPanel to Jframe
        this.add(mainPanel);


        //Change Pen/draw Color
        westPan.getBtn_ChangeColor().addActionListener(changePenDrawColor -> {

            System.out.println("Test pen color button");
            centerPan.setDrawingColor(
                    JColorChooser.showDialog(null, "Change Pen/Draw color",
                            centerPan.getBackground())
            );
        });

        //DrawModes
        westPan.getBtn_TextorPaint().addItemListener(e -> {
            if (!westPan.getBtn_TextorPaint().isSelected()) {

                centerPan.setTypeMode(false);
                westPan.getBtn_TextorPaint().setText("Draw Mode");
            }
            else{

                centerPan.setTypeMode(true);
                westPan.getBtn_TextorPaint().setText("Type Mode");
            }
        });

        //Shape Change
        eastPan.getRectangleOrCircle().addItemListener(e -> {
            if (!eastPan.getRectangleOrCircle().isSelected()) {

                centerPan.setRectangle(false);
                eastPan.getRectangleOrCircle().setText("Circle");
            }
            else{
                centerPan.setRectangle(true);
                eastPan.getRectangleOrCircle().setText("Rectangle");
            }
        });

        //East Slider
        eastPan.getSizeSlider().addChangeListener(sliderChange-> {
                //System.out.println(valuesChange.getSource());
                //System.out.println(eastPan.getSizeSlider().getValue());
                centerPan.setShapeSize(eastPan.getSizeSlider().getValue());
                centerPan.setFontSize(eastPan.getSizeSlider().getValue());
            }
        );


        //Image Fill
        eastPan.getImageFill().addItemListener(e -> {
            if (!eastPan.getImageFill().isSelected()) {

                centerPan.setFill(false);
                eastPan.getImageFill().setText("No Fill");
            }
            else{
                centerPan.setFill(true);
                eastPan.getImageFill().setText("Fill");
            }
        });

        //Image Fill
        eastPan.getImageFill().addItemListener(e -> {
            if (!eastPan.getImageFill().isSelected()) {

                centerPan.setFill(false);
                eastPan.getImageFill().setText("No Fill");
            }
            else{
                centerPan.setFill(true);
                eastPan.getImageFill().setText("Fill");
            }
        });

        //Eraser
        eastPan.getEraser().addItemListener(e -> {
            if (!eastPan.getEraser().isSelected()) {

                //Making Sure
                centerPan.setFill(true);
                centerPan.setDrawingColor(Color.white);
                eastPan.getImageFill().setText("No Erase");
            }
            else{
                //Making Sure
                centerPan.setFill(true);
                centerPan.setDrawingColor(Color.white);
                eastPan.getEraser().setText("Erase");
            }
        });
        // Make sure everything is loaded, set in the middle and visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
