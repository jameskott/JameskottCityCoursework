package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

import javax.swing.*;

public class EnemyCollision implements CollisionListener {
    private final Cowbo cowbo;

    public EnemyCollision(Cowbo cowbo) {
        this.cowbo = cowbo;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Enemy){
            if(!cowbo.isImmune()) {
                ((Enemy) collisionEvent.getOtherBody()).damage(cowbo);
                cowbo.setImmune(true);
                ImmuneTimer immuneTimer = new ImmuneTimer(cowbo);
                Timer timer = new Timer(3000, immuneTimer);
                timer.setRepeats(false);
                timer.start();
                System.out.println(cowbo.getLives());
            }
        }
        if(cowbo.getLives() <= 0){
            System.exit(0);
        }
    }
}
