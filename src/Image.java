import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
    private String filename;
    private File file;
    private BufferedImage bufferedImage;

    public Image(File file) {
        this.file = file;
        filename = file.getName();
        loadImage();
    }

    private void loadImage() {
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilename() {
        return filename;
    }

    public BufferedImage getBuffered(){
        return bufferedImage;
    }
}