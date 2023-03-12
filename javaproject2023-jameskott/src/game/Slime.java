package game;

import city.cs.engine.*;

public class Slime extends Walker implements Enemy{

    private static final Shape slimeShape = new CircleShape(1);

    private int damage = 1;
    private int speed;

    private static final BodyImage image = new BodyImage("data/slime1.png", 2f);
    private static final BodyImage image2 = new BodyImage("data/slime2.png", 2f);

    public Slime(World w) {
        super(w,slimeShape);
        addImage(image);
        speed = -3;
    }

    @Override
    public void damage(Cowbo cowbo) {
       cowbo.setLives(cowbo.getLives()-this.damage);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void move() {
        this.startWalking(speed);
    }
}

