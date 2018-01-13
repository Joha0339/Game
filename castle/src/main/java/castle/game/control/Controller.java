package castle.game.control;

import castle.game.model.Model;
import castle.game.view.View;

public class Controller {

    View view;
    Model model;

    public Controller(){
        model = new Model();
        view = new View();
    }
}
