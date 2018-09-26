package BetterThanPaint.Panels;

import javax.swing.*;
import java.awt.*;


public class GenericPanels extends JPanel{

    private JButton GenericPanelColorChooser;
    //private

    public GenericPanels(String str_label, GridLayout applyLayout) {

        // Don't apply new layout if null
        // default is flowlayout
        if (applyLayout != null)
            setLayout(applyLayout);

        JLabel generic_lbl = new JLabel(str_label);
        GenericPanelColorChooser = new JButton("Change Color");

        GenericPanelColorChooser.addActionListener(actionEventClicked ->  {

            setBackground(
                    JColorChooser.showDialog(null, "Change " + str_label + " Background",
                            GenericPanelColorChooser.getBackground())
            );
            // Debug code
            System.out.println(str_label + " clicked");

        });

        /*
        GenericPanelColorChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Color newBackgroundColor = JColorChooser.showDialog(null, "Change Button Background",
                        GenericPanelColorChooser.getBackground());
                setBackground(newBackgroundColor);

                System.out.println(label + " clicked");

            }
        });
        */

        add(generic_lbl);
        add(GenericPanelColorChooser);
        setVisible(true);
    }

    //Generated
    public JButton getGenericPanelColorChooser() {
        return GenericPanelColorChooser;
    }

    public void setGenericPanelColorChooser(JButton genericPanelColorChooser) {
        GenericPanelColorChooser = genericPanelColorChooser;
    }
}
