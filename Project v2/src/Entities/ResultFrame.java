package Entities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ResultFrame {
    private JFrame frame;
    private JButton abortButton;
    private JLabel label;
    private JButton okButton;

    public ResultFrame(String textToDisplay) {
        frame = new JFrame("Action Result");
        abortButton = new JButton("Back");
        label = new JLabel("<html><pre>" + textToDisplay + "</pre></html>");

        frame.add(abortButton, BorderLayout.EAST);
        frame.add(label, BorderLayout.WEST);

        frame.setSize(1200, 800);
        frame.setVisible(true);

        abortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                abortMission();
            }
        });

    }

    private void abortMission() {
        frame.setVisible(false);
        frame.dispose();
    }
}
