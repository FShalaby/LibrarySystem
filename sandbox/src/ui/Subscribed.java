package ui;

import sandbox.Database;
import sandbox.Newsletter;
import sandbox.User;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.IOException;

public class Subscribed extends JFrame {
    private final JEditorPane contentEditorPane;

    public Subscribed() {
        super("Newsletter Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout());

        contentEditorPane = new JEditorPane();
        contentEditorPane.setContentType("text/html");
        contentEditorPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(contentEditorPane);
        add(scrollPane, BorderLayout.CENTER);

        JButton fetchButton = new JButton("Fetch Newsletter");
        fetchButton.addActionListener(e -> fetchAndDisplayNewsletter());
        add(fetchButton, BorderLayout.SOUTH);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(fetchButton);
        buttonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void fetchAndDisplayNewsletter() {
        Newsletter news = Database.getNews();
        try {
            String newsletterContent = Database.fetchNewsletterContent(news.url);
            contentEditorPane.setText(newsletterContent);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to fetch newsletter content: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
