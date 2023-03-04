package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {

    private Cowbo student;

    public GameWorld(){

      // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.addImage(new BodyImage("./data/ground.png", 1f));

        // make the shape for the platforms
        Shape platform = new BoxShape(3,0.5f);
        // add platforms, give them positions and add images to them
        StaticBody platform2 = new StaticBody(this, platform);
        platform2.setPosition(new Vec2(8, 3f));
        platform2.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform3 = new StaticBody(this, platform);
        platform3.setPosition(new Vec2(-8, 3f));
        platform3.addImage(new BodyImage("./data/platform.png", 1f));

       student = new Cowbo(this);
       student.setPosition(new Vec2(8, -10));

       new Books(this).setPosition(new Vec2(-9.5f,3));
       new Books(this).setPosition(new Vec2(12,2));
    }

    public Cowbo getStudent(){
        return student;
    }
}
