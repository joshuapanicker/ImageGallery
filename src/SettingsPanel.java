import javax.swing.*;
import java.awt.*;

public class SettingsPanel {
    private JFrame settingsFrame, parentFrame;
    private GridBagConstraints gbc;
    private JLabel label;
    private ButtonGroup buttonGroup;
    private JCheckBox option1, option2, option3;

    public SettingsPanel(ImageFrame imageFrame){
        parentFrame = imageFrame.getFrame();
        createSettingsFrame();
        option1 = createOptionCheckbox(gbc, "2x", Settings.SPEED_FAST);
        option2 = createOptionCheckbox(gbc, "1x", Settings.SPEED_NORMAL);
        option3 = createOptionCheckbox(gbc, "0.5x", Settings.SPEED_SLOW);
        setVisible(false);
    }

    private void createSettingsFrame(){
        settingsFrame = new JFrame("Settings");
        settingsFrame.setSize(400, 300);
        settingsFrame.setLayout(new GridBagLayout());
        settingsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        settingsFrame.setLocationRelativeTo(parentFrame);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        label = new JLabel("Timer Speeds:");
        settingsFrame.add(label, gbc);

        buttonGroup = new ButtonGroup();
    }

    private JCheckBox createOptionCheckbox(GridBagConstraints gbc, String title, int speed) {
        JCheckBox option = new JCheckBox(title);

        if (speed == Settings.SPEED_NORMAL)
            option.setSelected(true);
        option.addActionListener(e -> setTimerSpeed(speed));
        buttonGroup.add(option);
        gbc.gridy++;
        settingsFrame.add(option, gbc);
        return option;
    }

    public void setTimerSpeed(int speed){
        ImageGallery.get().setSpeed(speed);
    }

    public void setVisible(Boolean isVisible){
        settingsFrame.setVisible(isVisible);
        settingsFrame.revalidate();
        settingsFrame.repaint();
    }
}

