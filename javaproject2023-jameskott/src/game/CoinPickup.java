package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CoinPickup implements CollisionListener {
    private final Cowbo cowbo;

    public CoinPickup(Cowbo c){
        cowbo = c;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Coin){
            cowbo.addCoin();
            collisionEvent.getOtherBody().destroy();
        }
    }
}


