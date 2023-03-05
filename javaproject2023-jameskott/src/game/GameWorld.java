package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Cowbo cowbo;

    public GameWorld(){

      // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -15f));
        ground.addImage(new BodyImage("./data/ground.png", 1f));

        // make the shape for the platforms
        Shape platform = new BoxShape(3,0.5f);
        // add platforms, give them positions and add images to them
        StaticBody platform1 = new StaticBody(this, platform);
        platform1.setPosition(new Vec2(8, 0f));
        platform1.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform2 = new StaticBody(this, platform);
        platform2.setPosition(new Vec2(-8, 0f));
        platform2.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform3 = new StaticBody(this, platform);
        platform3.setPosition(new Vec2(-3, -8f));
        platform3.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform4 = new StaticBody(this, platform);
        platform4.setPosition(new Vec2(3, -8f));
        platform4.addImage(new BodyImage("./data/platform.png", 1f));

        Shape wall = new BoxShape(0.5f, 30f);
        StaticBody wall1 = new StaticBody(this, wall);
        StaticBody wall2 = new StaticBody(this, wall);
        wall1.setPosition(new Vec2(14.5f, 0f));
        wall1.addImage(new BodyImage("./data/wall.png", 30f));
        wall2.setPosition(new Vec2(-14.5f, 0f));
        wall2.addImage(new BodyImage("./data/wall.png", 30f));



        cowbo = new Cowbo(this);
        cowbo.setPosition(new Vec2(0, 2));


    }

    public Cowbo getStudent(){
        return cowbo;
    }
}
