package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CowboController implements KeyListener {

    private final int super_jump = 0;

    private final Cowbo cowbo;


    public CowboController(Cowbo s){
        cowbo = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            cowbo.startWalking(-Cowbo.getWalk_speed());
            Cowbo.setCowboImage(new BodyImage("data/cowboleftgun.png", 4.5f));
        } else if (code == KeyEvent.VK_RIGHT) {
            cowbo.startWalking(Cowbo.getWalk_speed());
            Cowbo.setCowboImage(new BodyImage("data/cowborightgun.png", 4.5f));
        }
        else if (code == KeyEvent.VK_UP){
            cowbo.jump(14);
        }
        else if (code == KeyEvent.VK_SHIFT){
            Cowbo.setWalk_speed(9);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            cowbo.stopWalking();
            Cowbo.setCowboImage(new BodyImage("data/cowbostill.png", 4.5f));
        } else if (code ==   KeyEvent.VK_RIGHT) {
            cowbo.stopWalking();
            Cowbo.setCowboImage(new BodyImage("data/cowbostill.png", 4.5f));
        }
        else if (code == KeyEvent.VK_SHIFT){
            Cowbo.setWalk_speed(6);
        }
    }
}
