package ui;

import javax.swing.*;
import java.awt.*;

/**
 * The main entrypoint for the GUI.
 */
public class MainWindow extends JFrame {
    // constants
    private static final int WIN_WIDTH = 1024;
    private static final int WIN_HEIGHT = 640;

    /**
     * Creates the MainWindow.
     */
    private MainWindow() {
        super("Library System");

        // init window
        this.setSize(WIN_WIDTH, WIN_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center window
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(
                (screenDimension.width - WIN_WIDTH) / 2, (screenDimension.height - WIN_HEIGHT) / 2);

        // add stuff
        JLabel label = new JLabel("Welcome to the Main Page!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow().showLoginDialog());
    }

    /**
     * Creates and displays a login dialog.
     */
    public void showLoginDialog() {
        // login dialog always disposes itself
        LoginDialog loginDialog = new LoginDialog(this);
        loginDialog.setVisible(true);
        this.setVisible(false);
    }
}
