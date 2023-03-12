package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class EnemyStepListen implements StepListener {
    private Enemy enemy;

    public EnemyStepListen(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }

    @Override
    public void postStep(StepEvent stepEvent) {
        enemy.move();
    }
}
