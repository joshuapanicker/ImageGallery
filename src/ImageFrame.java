import java.awt.*;
import javax.swing.*;

public class ImageFrame {
    private JFrame frame;
    private int height, width;
    private JLayeredPane layeredPane;

    public ImageFrame() {
        this(800, 600);
    }

    public ImageFrame(int width, int height){
        this.width = width;
        this.height = height;

        layeredPane = new JLayeredPane();

        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(width, height);
        frame.add(layeredPane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addPanel(IgPanel igPanel, int layerType){
        layeredPane.add(igPanel, layerType);
    }

    public void setVisible() {
        frame.setVisible(true);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public JFrame getFrame(){
        return frame;
    }
}