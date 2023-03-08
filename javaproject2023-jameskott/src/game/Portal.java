package game;

import city.cs.engine.*;

public class Portal extends StaticBody {
    private Portal matchingPortal;
    private int exitDirection;

    private static final BodyImage image =
            new BodyImage("data/portal.png", 2f);

    private static final Shape portalShape = new PolygonShape(-0.08f,1.4f, 0.53f,-1.62f, -0.53f,-1.71f
    );

    public Portal getMatchingPortal() {
        return matchingPortal;
    }

    public void setMatchingPortal(Portal matchingPortal) {
        this.matchingPortal = matchingPortal;
    }

    public int getExitDirection() {
        return exitDirection;
    }

    public void setExitDirection(int exitDirection) {
        this.exitDirection = exitDirection;
    }

    public Portal(World w) {
        super(w,portalShape);
        addImage(image);
    }

}
