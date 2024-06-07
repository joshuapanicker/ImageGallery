import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends IgPanel {
    private JButton backButton, forwardButton, pauseButton, settingsButton;
    private String iconDirName = "Resources";

    public ControlPanel(ImageFrame imageFrame) {
        super(imageFrame);

        setLayout(null);
        setBounds(0, 0, imageFrame.getWidth(), imageFrame.getHeight());
        setOpaque(false);

        createBackButton();
        createForwardButton();
        createPauseButton();
        createSettingsButton();
    }

    private JButton createButton(String iconFile, int x, int y, int width, int height) {
        JButton button = new JButton();
        String iconPath = iconDirName + "\\" + iconFile;

        try {
            BufferedImage icon = ImageIO.read(new File(iconPath));
            Image scaledIcon = icon.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledIcon));
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
            button.setBounds(x, y, width, height); // Set button position and custom size
        } catch (IOException e) {
            e.printStackTrace();
        }
        return button;
    }

    private void createBackButton() {
        backButton = createButton("back.png", 285, 500, 50, 50);
        backButton.addActionListener(e -> ImageGallery.get().goBack());
        add(backButton);
    }

    private void createForwardButton() {
        forwardButton = createButton("forward.png", 405, 500, 50, 50);
        forwardButton.addActionListener(e -> ImageGallery.get().goForward());
        add(forwardButton);
    }

    private void createPauseButton() {
        pauseButton = createButton("pause.png", 345, 500, 50, 50);
        pauseButton.addActionListener(e -> ImageGallery.get().togglePlayPause());
        add(pauseButton);
    }

    private void createSettingsButton() {
        settingsButton = createButton("settings.png", 700, 500, 50, 50);
        settingsButton.addActionListener(e -> ImageGallery.get().toggleSettings());
        add(settingsButton);
    }

    public void display() {
        revalidate();
        repaint();
    }
}
