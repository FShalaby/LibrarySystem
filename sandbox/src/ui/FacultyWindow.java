package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FacultyWindow extends MainWindow {

    public FacultyWindow() {
        super();
        setTitle("Faculty Main Window");
        // Customize the window for faculty user
        customizeForFaculty();
    }

    private void customizeForFaculty() {
        // Customize components as needed for faculty user
        JLabel userTypeLabel = new JLabel("Faculty");
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel centerPanel = (JPanel) getContentPane().getComponent(1);
        centerPanel.add(userTypeLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FacultyWindow().showLoginDialog());
    }
}
