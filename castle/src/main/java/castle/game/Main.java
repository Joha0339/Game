package castle.game;

import castle.game.control.Controller;

import javax.swing.*;

public class Main {

    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> new Controller());
    }
}
