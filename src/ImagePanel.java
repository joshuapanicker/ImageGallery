import java.awt.*;
import java.awt.image.BufferedImage;


public class ImagePanel extends IgPanel {
    private BufferedImage currentImage;

    public ImagePanel(ImageFrame imageFrame){
        super(imageFrame);
        setBounds(0, 0, imageFrame.getWidth(), imageFrame.getHeight());
    }

    public void display(Image image) {
        currentImage = image.getBuffered();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}