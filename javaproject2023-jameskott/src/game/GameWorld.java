package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private final Cowbo cowbo;

    public GameWorld(){

      // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -15f));
        ground.addImage(new BodyImage("./data/ground.png", 1f));
        ground.setName("Ground");

        // make the shape for the platforms
        Shape platform = new BoxShape(3,0.5f);
        // add platforms, give them positions and add images to them
        StaticBody platform1 = new StaticBody(this, platform);
        platform1.setPosition(new Vec2(8, 0f));
        platform1.addImage(new BodyImage("./data/platform.png", 1f));
        platform1.setName("platform1");

        StaticBody platform2 = new StaticBody(this, platform);
        platform2.setPosition(new Vec2(-8, 0f));
        platform2.addImage(new BodyImage("./data/platform.png", 1f));
        platform2.setName("platform2");

        StaticBody platform3 = new StaticBody(this, platform);
        platform3.setPosition(new Vec2(-3, -8f));
        platform3.addImage(new BodyImage("./data/platform.png", 1f));
        platform3.setName("platform3");


        StaticBody platform4 = new StaticBody(this, platform);
        platform4.setPosition(new Vec2(3, -8f));
        platform4.addImage(new BodyImage("./data/platform.png", 1f));
        platform4.setName("platform4");


        Shape wall = new BoxShape(0.5f, 30f);
        StaticBody wall1 = new StaticBody(this, wall);
        StaticBody wall2 = new StaticBody(this, wall);
        wall1.setPosition(new Vec2(14.5f, 0f));
        wall1.addImage(new BodyImage("./data/wall.png", 30f));
        wall1.setName("wall");
        wall2.setPosition(new Vec2(-14.5f, 0f));
        wall2.addImage(new BodyImage("./data/wall.png", 30f));
        wall2.setName("wall2");

        Portal p1 = new Portal(this);
        p1.setPosition(new Vec2(-11.5f, 2f));
        p1.setName("portal1");
        Portal p2 = new Portal(this);
        p2.setPosition(new Vec2(12.5f, -13f));
        p2.setName("p2");
        p1.setMatchingPortal(p2);
        p2.setMatchingPortal(p1);
        p1.setExitDirection(1);
        p2.setExitDirection(0);


        Coin c1 = new Coin(this);
        c1.setPosition(new Vec2(-10,4));
        c1.setName("coin");
        Coin c2 = new Coin(this);
        c2.setPosition(new Vec2(8, -3));
        c2.setName("coin");

        Slime s1 = new Slime(this);
        s1.setPosition(new Vec2(-5,-8));
        s1.setName("slime");
        Slime s2 = new Slime(this);
        s2.setPosition(new Vec2(6, -8));
        s2.setName("slime");


        cowbo = new Cowbo(this);
        cowbo.setPosition(new Vec2(0, 2));

        //GenericCollisionListener gcl = new GenericCollisionListener();
        //cowbo.addCollisionListener(gcl);



        CoinPickup coinPickup = new CoinPickup(cowbo);
        cowbo.addCollisionListener(coinPickup);

        PortalTouch pt = new PortalTouch();
        p1.addCollisionListener(pt);
        p2.addCollisionListener(pt);
    }

    public Cowbo getCowbo(){
        return cowbo;
    }
}
