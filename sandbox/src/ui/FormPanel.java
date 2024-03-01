package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormPanel extends JPanel {
    public FormPanel() {
        this.setBorder(new EmptyBorder(12, 12, 12, 12));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void addRow(JLabel label, Component field) {
        // create an end-aligned row
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.TRAILING));
        row.add(label);
        row.add(field);

        this.add(row);
    }

    public void addVSpace(int height) {
        JPanel vSpace = new JPanel();
        vSpace.setSize(1, height);
        this.add(vSpace);
    }

    public void addActions(Component... components) {
        JPanel row = new JPanel();
        row.setLayout(new GridLayout(1, components.length));
        for (Component comp : components) {
            row.add(comp);
        }

        this.add(row);
    }
}
