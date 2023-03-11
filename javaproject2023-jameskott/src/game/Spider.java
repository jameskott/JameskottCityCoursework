package game;

import city.cs.engine.*;

public class Spider extends Walker implements Enemy{
    private static final Shape spiderShape = new CircleShape(1);

    private static final BodyImage image = new BodyImage("data/spooder1.png", 2f);
    private static final BodyImage image2 = new BodyImage("data/spooder2.png", 2f);

    private int damage = 2;
    public Spider(World world) {
        super(world, spiderShape);
        addImage(image);
    }

    @Override
    public void damage(Cowbo cowbo) {
        cowbo.setLives(cowbo.getLives()-this.damage);
    }
}
