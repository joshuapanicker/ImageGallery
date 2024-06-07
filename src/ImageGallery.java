import javax.swing.*;

public class ImageGallery {
    public static ImageGallery imageGallery;

    private Settings settings;
    private Library library;
    private ImageFrame imageFrame;
    private SettingsPanel settingsPanel;
    private ImagePanel imagePanel;
    private ControlPanel controlPanel;
    private Timer timer;
    private boolean paused = false;
    private boolean isSettingsOn = false;

    ImageGallery() {
        String dirPath = "Images";

        this.library = new Library(dirPath);
        this.settings = new Settings();

        this.imageFrame = new ImageFrame();
        this.imagePanel = new ImagePanel(imageFrame);
        this.controlPanel = new ControlPanel(imageFrame);
        this.settingsPanel = new SettingsPanel(imageFrame);
        this.timer = new Timer(settings.getSpeed(), e -> updateFrame());
    }

    public static ImageGallery get() {
        return imageGallery;
    }

    public int getSpeed() {
        return settings.getSpeed();
    }

    public void setSpeed(int speed){
        settings.setSpeed(speed);
        timer.stop();
        this.timer = new Timer(settings.getSpeed(), e -> updateFrame());
        timer.start();
    }

    public void goBack() {
        timer.restart();
        updateFrame(library.getPrev());
    }

    public void goForward() {
        timer.restart();
        updateFrame();
    }

    public void togglePlayPause() {
        paused = !paused;
        if (paused)
            timer.stop();
        else
            timer.start();
    }

    public void toggleSettings() {
        isSettingsOn = !isSettingsOn;
        if (isSettingsOn) {
            timer.stop();
            settingsPanel.setVisible(true);
        } else {
            settingsPanel.setVisible(false);
            timer.start();
        }
    }

    public void updateFrame(Image image) {
        imagePanel.display(image);
        controlPanel.display();

    }

    public void updateFrame() {
        updateFrame(library.getNext());
    }

    public void initFrame() {
        imageFrame.addPanel(imagePanel, 1);
        imageFrame.addPanel(controlPanel, 0);
        imageFrame.setVisible();
    }

    public void start() {
        library.findImages();
        initFrame();
        updateFrame();
        timer.start();
    }

    public static void main(String[] args) {
        imageGallery = new ImageGallery();
        imageGallery.start();
    }
}
