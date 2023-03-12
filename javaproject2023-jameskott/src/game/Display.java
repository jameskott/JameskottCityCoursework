package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Display implements StepListener {
    private final GameView view;
    private final Cowbo cowbo;
    public Display(GameView view, Cowbo cowbo) {
        this.view = view;
        this.cowbo = cowbo;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
    }
}