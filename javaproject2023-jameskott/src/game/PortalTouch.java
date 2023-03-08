package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class PortalTouch implements CollisionListener {
    private Cowbo cowbo;

    private Portal reportingBody;

    public PortalTouch(){
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        reportingBody = (Portal) collisionEvent.getReportingBody();

        if(collisionEvent.getOtherBody() instanceof Walker) {
            if (reportingBody.getExitDirection() == 0) {
                collisionEvent.getOtherBody().setPosition(reportingBody.getMatchingPortal().getPosition().add(new Vec2(2, 0)));
            } else {
                collisionEvent.getOtherBody().setPosition(reportingBody.getMatchingPortal().getPosition().add(new Vec2(-2, 0)));
            }
        }
        if(collisionEvent.getOtherBody() instanceof DynamicBody) {
            if (reportingBody.getExitDirection() == 0) {
                collisionEvent.getOtherBody().setPosition(reportingBody.getMatchingPortal().getPosition().add(new Vec2(2, 0)));
            } else {
                collisionEvent.getOtherBody().setPosition(reportingBody.getMatchingPortal().getPosition().add(new Vec2(-2, 0)));
            }
        }
        }
    }

