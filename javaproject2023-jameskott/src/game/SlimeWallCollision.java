package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class SlimeWallCollision implements CollisionListener {
    private final Slime slime;
    private String[] noTurn = {"wall, portal, ground"};

    public SlimeWallCollision(Slime slime) {
        this.slime = slime;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        for(int i = 0; i < noTurn.length; i++){
            if(collisionEvent.getOtherBody().getName() != "ground" && collisionEvent.getOtherBody().getName() != "platform" && collisionEvent.getOtherBody().getName() != "portal") {
                slime.setSpeed(-slime.getSpeed());
                System.out.println(slime.getSpeed());
            }
        }
    }
}
