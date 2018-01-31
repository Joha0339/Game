package castle.game.view;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame mainWindow;

    //Middle Panel
    private JPanel middlePanel;
    private JButton newGame;
    private JButton loadGame;
    private JButton exit;


    private JButton button;
    private JButton button2;

    /**
     * Creates the starting window off the game.
     */
    public View(){
        setUpMainWindow();
        createMiddleButtons();
        //createTestButton();

    }

    /**
     * Creates the frame holding all other components
     */
    private void setUpMainWindow(){
        mainWindow = new JFrame("Castle");
        mainWindow.setSize(800, 600);
        mainWindow.setMinimumSize(new Dimension(800, 600));
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setResizable(true);
        mainWindow.setVisible(true);
    }

    /**
     *
     */
    private void createMiddleButtons(){
        newGame = new JButton("New Game");
        loadGame = new JButton("Load Game");
        exit = new JButton("Exit Game");

        middlePanel = new JPanel();
        middlePanel.add(newGame);
        middlePanel.add(loadGame);
        middlePanel.add(exit);
        mainWindow.add(middlePanel, BorderLayout.CENTER);
    }

    private void createTestButton(){

        button = new JButton("Militia");
        button2 = new JButton("To Battle!");

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(button2);

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

    public JButton getNewGame() {
        return newGame;
    }

    public JButton getLoadGame() {
        return loadGame;
    }

    public JButton getExit() {
        return exit;
    }
}