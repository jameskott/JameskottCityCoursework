package game;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Spider extends Walker implements Enemy{
    private static final Shape spiderShape = new CircleShape(1);

    private static final BodyImage image = new BodyImage("data/spooder1.png", 2f);
    private static final BodyImage image2 = new BodyImage("data/spooder2.png", 2f);
    private boolean jumpOffCd;
    private final int damage = 2;

    private Timer timer;

    public Spider(World world) {
        super(world, spiderShape);
        addImage(image);
        jumpOffCd = true;
        ActionListener SpiderJumpCooldown = new SpiderJumpCooldown(this);
        timer = new Timer(5000, SpiderJumpCooldown);
        timer.setRepeats(false);
    }

    @Override
    public void damage(Cowbo cowbo) {
        cowbo.setLives(cowbo.getLives()-this.damage);
    }

    public boolean isJumpOffCd() {
        return jumpOffCd;
    }

    public void setJumpOffCd(boolean jumpOffCd) {
        this.jumpOffCd = jumpOffCd;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void move() {
        if(jumpOffCd){
            this.jump(8);
            setJumpOffCd(false);
            timer.start();
        }
    }
}
