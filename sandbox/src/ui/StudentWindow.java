package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StudentWindow extends MainWindow {

    public StudentWindow() {
        super();
        setTitle("Student Main Window");
        // Customize the window for student user
        customizeForStudent();
    }

    private void customizeForStudent() {
        // Customize components as needed for student user
        JLabel userTypeLabel = new JLabel("Student");
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel centerPanel = (JPanel) getContentPane().getComponent(1);
        centerPanel.add(userTypeLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentWindow().showLoginDialog());
    }
}
