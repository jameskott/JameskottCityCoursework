package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImmuneTimer implements ActionListener {
    private final Cowbo cowbo;
    public ImmuneTimer(Cowbo cowbo) {
        this.cowbo = cowbo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cowbo.setImmune(false);
    }
}
