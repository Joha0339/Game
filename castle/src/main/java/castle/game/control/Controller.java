package castle.game.control;

import castle.game.model.Model;
import castle.game.model.audio.AudioController;
import castle.game.model.unit.Battle;
import castle.game.model.unit.Knight;
import castle.game.model.unit.Militia;
import castle.game.model.unit.Unit;
import castle.game.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {

    View view;
    Model model;

    public Controller(){

        AudioController.getInstance().playSound(AudioController.MUSIC);
        model = new Model();
        view = new View();

        view.getButton().addActionListener(new testButtonListener());
        view.getButton2().addActionListener(new battleButtonListener());
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

    private class battleButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ArrayList<Unit> attackers = new ArrayList<Unit>();
            attackers.add(new Militia());
            attackers.add(new Militia());
            attackers.add(new Militia());
            attackers.add(new Militia());

            ArrayList<Unit> defenders = new ArrayList<Unit>();
            defenders.add(new Militia());
            defenders.add(new Militia());
            defenders.add(new Militia());
            defenders.add(new Militia());

            Battle battle = new Battle(attackers, defenders);
            int poop = battle.doBattle();
            System.out.println(poop);
        }

    }

}
