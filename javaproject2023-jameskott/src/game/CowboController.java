package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class CowboController implements KeyListener {

    private static final float WALKING_SPEED = 3;

    private Cowbo cowbo;

    private HashMap<Body, BodyImage> hiddenImages = null;

    public CowboController(Cowbo s){
        cowbo = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_LEFT) {
            cowbo.startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT) {
            cowbo.startWalking(WALKING_SPEED*2);
        }
        else if (code == KeyEvent.VK_UP){
            cowbo.jump(12);
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
    }
}
