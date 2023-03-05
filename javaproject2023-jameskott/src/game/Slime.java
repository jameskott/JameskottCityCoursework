package game;

import city.cs.engine.*;

public class Slime extends DynamicBody {

    private static final Shape slimeShape = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("data/slime1.png", 2f);

    public Slime(World w) {
        super(w,slimeShape);
        addImage(image);
    }
}
