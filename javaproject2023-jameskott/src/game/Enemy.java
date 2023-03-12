package game;

import city.cs.engine.Walker;

public interface Enemy {
    void damage(Cowbo cowbo);

    void move();
}
