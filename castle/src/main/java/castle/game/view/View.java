package castle.game.view;

import javax.swing.*;

public class View {
    JFrame mainWindow;

    public View(){
        setUpMainWindow();

    }

    private void setUpMainWindow(){
        mainWindow = new JFrame("Joels shitty game");
        mainWindow.setSize(800, 600);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
    }

    private void createTestButton(){

        JButton button = new JButton("Militia");

        JPanel panel = new JPanel();
    }

    private void createUnitWindow(String name, String type, String description){
        JFrame unitFrame = new JFrame("name");
        unitFrame.setSize(800, 600);
        unitFrame.setResizable(false);

        JTextArea area = new JTextArea();
        area.append("Type: " + type + "\n");
        area.append(description);

        JPanel panel = new JPanel();
        panel.add(area);

        unitFrame.setVisible(true);
    }
}