package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SlimeCollision implements CollisionListener {
    private Cowbo cowbo;

    public SlimeCollision(Cowbo cowbo) {
        this.cowbo = cowbo;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Cowbo){
            this.cowbo.loseLife();
            System.out.println(cowbo.getLives());
        }
        if(cowbo.getLives() == 0){
            System.exit(0);
        }
    }
}
