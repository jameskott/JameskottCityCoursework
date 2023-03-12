package game;

import city.cs.engine.BodyImage;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CowboController implements KeyListener {

    private final int super_jump = 16;

    private final Cowbo cowbo;

    SuperJump superJump;
    Timer timer;

    public CowboController(Cowbo s){
        this.cowbo = s;
        superJump = new SuperJump(s);
        this.timer = new Timer(2500, superJump);
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
            System.out.println(cowbo.isSuperJump());
            timer.setRepeats(false);
            timer.start();
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
        } else if (code == KeyEvent.VK_UP){
            timer.stop();
            if(cowbo.isSuperJump()){
                System.out.println(cowbo.isSuperJump());
                cowbo.jump(18);
                cowbo.setSuperJump(false);
                System.out.println(cowbo.isSuperJump());
                System.out.println("SUPER JUMP");
            } else{
                cowbo.jump(13);
            }
        }
    }
}
