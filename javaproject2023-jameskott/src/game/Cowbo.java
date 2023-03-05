package game;

import city.cs.engine.*;

public class Cowbo extends Walker {
    private static final Shape cowboShape = new PolygonShape(
            1.12f,1.81f, 1.08f,-1.7f, -1.08f,-1.72f, -1.27f,1.81f);


    public static void setCowboImage(BodyImage cowboImage) {
        System.out.println("bananas");
        Cowbo.cowboImage = cowboImage;
    }

    private static BodyImage cowboImage =
            new BodyImage("data/cowbostill.png", 4.5f);


    public Cowbo(World world) {
        super(world, cowboShape);
        addImage(cowboImage);
    }




}