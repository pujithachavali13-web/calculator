import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RealTimeClock extends JFrame {
    private JLabel timeLabel;
    private JLabel dateLabel;
    private Timer timer;

    public RealTimeClock() {
        // Setup Window Frame
        setTitle("Real-Time Clock Application");
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));
        getContentPane().setBackground(new Color(30, 30, 30));

        // Setup Date Label
        dateLabel = new JLabel("", JLabel.CENTER);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dateLabel.setForeground(new Color(170, 170, 170));

        // Setup Time Label (Main Clock)
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 45));
        timeLabel.setForeground(new Color(0, 255, 128)); // Neon Green

        add(dateLabel);
        add(timeLabel);

        // Real-time update using Swing Timer (fires every 1000ms / 1 second)
        timer = new Timer(1000, e -> updateClock());
        timer.start();

        // Initial call to prevent 1-second delay on startup
        updateClock();
    }

    private void updateClock() {
        // Format Current Date and Time
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        
        Date now = new Date();
        
        dateLabel.setText(dateFormat.format(now));
        timeLabel.setText(timeFormat.format(now));
    }

    public static void main(String[] args) {
        // Run on Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> {
            new RealTimeClock().setVisible(true);
        });
    }
}