package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Cowbo cowbo;

    public GameWorld(){

      // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.addImage(new BodyImage("./data/ground.png", 1f));

        // make the shape for the platforms
        Shape platform = new BoxShape(3,0.5f);
        // add platforms, give them positions and add images to them
        StaticBody platform1 = new StaticBody(this, platform);
        platform1.setPosition(new Vec2(8, 3f));
        platform1.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform2 = new StaticBody(this, platform);
        platform2.setPosition(new Vec2(-8, 3f));
        platform2.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform3 = new StaticBody(this, platform);
        platform3.setPosition(new Vec2(-3, -5f));
        platform3.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform4 = new StaticBody(this, platform);
        platform4.setPosition(new Vec2(3, -5f));
        platform4.addImage(new BodyImage("./data/platform.png", 1f));

       cowbo = new Cowbo(this);
       cowbo.setPosition(new Vec2(0, 2));

    }

    public Cowbo getStudent(){
        return cowbo;
    }
}
