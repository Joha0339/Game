package castle.game.control;

import castle.game.model.Model;
import castle.game.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    View view;
    Model model;

    public Controller(){
        model = new Model();
        view = new View();

        view.getButton().addActionListener(new testButtonListener());
    }



    private class testButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String name = model.getTestUnit().getName();
            String type = model.getTestUnit().getType();
            String description = model.getTestUnit().getDescription();
            description = description +
                    model.getTestUnit().getStats().toString();
            view.createUnitWindow(name, type, description);
        }

    }

}
