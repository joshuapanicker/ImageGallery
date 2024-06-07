import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Library {
    private String dirName;
    private int currentIndex;
    private ArrayList<Image> imageFiles;

    public Library() {
        this(".");
    }

    public Library(String dirName) {
        this.dirName = dirName;
        imageFiles = new ArrayList<Image>();
    }

    public void findImages() {
        File directory = new File(dirName);
        File[] filesList = directory.listFiles();

        if (filesList != null) {
            for (File file : filesList) {
                if (file.isFile() && isImageFile(file)) {
                    Image image = new Image(file);
                    imageFiles.add(image);
                }
            }
        }
    }

    private boolean isImageFile(File file) {
        String[] imageExtensions = { "jpg", "jpeg", "tiff", "bmp", "png" };
        String fileName = file.getName().toLowerCase();

        for (String extension : imageExtensions) {
            if (fileName.endsWith("." + extension)) {
                return true;
            }
        }
        return false;
    }

    public void listImages() {
        for (int i = 0; i < imageFiles.size(); i++){
            System.out.printf("%s\n", imageFiles.get(i).getFilename());
        }
    }

    public Image getNext() {
        currentIndex = (currentIndex + 1) % imageFiles.size();
        return imageFiles.get(currentIndex);
    }

    public Image getPrev() {
        currentIndex = (currentIndex - 1 + imageFiles.size()) % imageFiles.size();
        return imageFiles.get(currentIndex);
    }
}