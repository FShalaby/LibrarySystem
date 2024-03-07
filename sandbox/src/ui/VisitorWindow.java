package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VisitorWindow extends MainWindow {

    public VisitorWindow() {
        super();
        setTitle("Non-Faculty Main Window");
        // Customize the window for faculty user
        customizeForVisitor();
    }

    private void customizeForVisitor() {
        // Customize components as needed for faculty user
        JLabel userTypeLabel = new JLabel("Non-Faculty");
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel centerPanel = (JPanel) getContentPane().getComponent(1);
        centerPanel.add(userTypeLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VisitorWindow().showLoginDialog());
    }
}



