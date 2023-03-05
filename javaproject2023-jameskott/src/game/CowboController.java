package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class CowboController implements KeyListener {

    //set the characters walk speed
    private static float walk_speed = 6;


    private Cowbo cowbo;


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
            cowbo.startWalking(-walk_speed);
        } else if (code == KeyEvent.VK_RIGHT) {
            cowbo.startWalking(walk_speed);
        }
        else if (code == KeyEvent.VK_UP){
            cowbo.jump(12);
        }
        else if (code == KeyEvent.VK_SHIFT){
            this.walk_speed = 9;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            cowbo.stopWalking();
        } else if (code ==   KeyEvent.VK_RIGHT) {
            cowbo.stopWalking();
        }
        else if (code == KeyEvent.VK_SHIFT){
            this.walk_speed = 6;
        }
    }
}
