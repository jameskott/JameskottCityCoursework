package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWorld extends World implements ActionListener {

    private final Cowbo cowbo;



    public GameWorld(){

        //random generator for coords
        generateRandom random = new generateRandom();

        cowbo = new Cowbo(this);
        cowbo.setPosition(new Vec2(0, 2));


        // make the ground
        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -15f));
        ground.addImage(new BodyImage("./data/ground.png", 1f));
        ground.setName("ground");

        // make the shape for the platforms
        Shape platform = new BoxShape(3,0.5f);
        // add platforms, give them positions and add images to them
        StaticBody platform1 = new StaticBody(this, platform);
        platform1.setPosition(new Vec2(8, 0f));
        platform1.addImage(new BodyImage("./data/platform.png", 1f));
        platform1.setName("platform");

        StaticBody platform2 = new StaticBody(this, platform);
        platform2.setPosition(new Vec2(-8, 0f));
        platform2.addImage(new BodyImage("./data/platform.png", 1f));
        platform2.setName("platform");

        StaticBody platform3 = new StaticBody(this, platform);
        platform3.setPosition(new Vec2(-3, -8f));
        platform3.addImage(new BodyImage("./data/platform.png", 1f));
        platform3.setName("platform");


        StaticBody platform4 = new StaticBody(this, platform);
        platform4.setPosition(new Vec2(3, -8f));
        platform4.addImage(new BodyImage("./data/platform.png", 1f));
        platform4.setName("platform");



        Shape wall = new BoxShape(0.5f, 30f);
        StaticBody wall1 = new StaticBody(this, wall);
        StaticBody wall2 = new StaticBody(this, wall);
        wall1.setPosition(new Vec2(14.5f, 0f));
        wall1.addImage(new BodyImage("./data/wall.png", 30f));
        wall1.setName("wall");
        wall2.setPosition(new Vec2(-14.5f, 0f));
        wall2.addImage(new BodyImage("./data/wall.png", 30f));
        wall2.setName("wall");

        Portal portal1 = new Portal(this);
        portal1.setPosition(new Vec2(-11.5f, 2f));
        portal1.setName("portal");
        Portal portal2 = new Portal(this);
        portal2.setPosition(new Vec2(12.5f, -13f));
        portal2.setName("portal");
        portal1.setMatchingPortal(portal2);
        portal2.setMatchingPortal(portal1);
        portal1.setExitDirection(1);
        portal2.setExitDirection(0);


        Coin c1 = new Coin(this);
        c1.setPosition(new Vec2(-10,4));
        c1.setName("coin");
        Coin c2 = new Coin(this);
        c2.setPosition(new Vec2(8, -3));
        c2.setName("coin");

        Slime slime1 = new Slime(this);
        slime1.setPosition(new Vec2(-5,-8));
        slime1.setName("slime");
        Slime slime2 = new Slime(this);
        slime2.setPosition(new Vec2(6, -8));
        slime2.setName("slime") ;
        Spider spider1 = new Spider(this);
        spider1.setPosition(new Vec2(6.5f,9f));
        spider1.setName("spider");


        Timer timer = new Timer(10000, this);
        timer.setInitialDelay(100);
        timer.start();



        //GenericCollisionListener gcl = new GenericCollisionListener();
        //cowbo.addCollisionListener(gcl);



        CoinPickup coinPickup = new CoinPickup(cowbo);
        cowbo.addCollisionListener(coinPickup);

        EnemyCollision enemyCollision = new EnemyCollision(cowbo);
        cowbo.addCollisionListener(enemyCollision);
        SlimeWallCollision slimeWallCollision = new SlimeWallCollision(slime1);
        SlimeWallCollision slimeWallCollision2 = new SlimeWallCollision(slime2);
        slime1.addCollisionListener(slimeWallCollision);
        slime2.addCollisionListener(slimeWallCollision2);
        PortalTouch pt = new PortalTouch();
        portal1.addCollisionListener(pt);
        portal2.addCollisionListener(pt);


        slime1.move();
        slime2.move();
        spider1.move();
        cowbo.setName("cowbo");
        this.addStepListener(new EnemyStepListen(slime1));
        this.addStepListener(new EnemyStepListen(slime2));
        this.addStepListener(new EnemyStepListen(spider1));
    }

    public Cowbo getCowbo(){
        return cowbo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Vec2 coord = new Vec2(generateRandom.main(),generateRandom.main());
        Coin c = new Coin(this);
        c.setPosition(coord);
        c.setName("coin");
    }
}
