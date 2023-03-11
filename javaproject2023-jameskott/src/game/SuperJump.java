package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperJump implements ActionListener {
    private Cowbo cowbo;

    public SuperJump(Cowbo cowbo) {
        this.cowbo = cowbo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cowbo.setSuperJump(true);
    }
}



