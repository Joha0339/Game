package castle.game.view;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame mainWindow;
    private JButton button;

    public View(){
        setUpMainWindow();
        createTestButton();

    }

    private void setUpMainWindow(){
        mainWindow = new JFrame("Joels shitty game");
        mainWindow.setSize(800, 600);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
    }

    private void createTestButton(){

        button = new JButton("Militia");

        JPanel panel = new JPanel();
        panel.add(button);

        mainWindow.add(panel);
    }

    public void createUnitWindow(String name, String type, String description){
        JFrame unitFrame = new JFrame(name);
        unitFrame.setSize(300, 200);
        unitFrame.setLayout(new BorderLayout());
        unitFrame.setMinimumSize(new Dimension(300, 200));

        JTextArea area = new JTextArea();
        area.append("Type: " + type + "\n");
        area.append(description);
        area.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(area, BorderLayout.CENTER);

        unitFrame.add(panel, BorderLayout.CENTER);
        unitFrame.setVisible(true);
    }

    public JButton getButton() {
        return button;
    }
}