package game;

import city.cs.engine.*;

public class Cowbo extends Walker {

    private boolean immune;

    public boolean isImmune() {
        return immune;
    }

    public void setImmune(boolean immune) {
        this.immune = immune;
    }

    private int lives;

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    //set the characters walk speed
    private static float walk_speed = 6;
    private int coins;
    private static final Shape cowboShape = new PolygonShape(
            1.12f,1.81f, 1.08f,-1.7f, -1.08f,-1.72f, -1.27f,1.81f);

    public static float getWalk_speed() {
        return walk_speed;
    }

    public static void setWalk_speed(float walk_speed) {
        Cowbo.walk_speed = walk_speed;
    }

    public void loseLife(){
        this.setLives(this.getLives()-1);
    }


    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    //add 1 coin
    public void addCoin(){
        setCoins(getCoins()+1);
    }

    public static void setCowboImage(BodyImage cowboImage) {
        //System.out.println("bananas");
        Cowbo.cowboImage = cowboImage;
    }

    private static BodyImage cowboImage =
            new BodyImage("data/cowbostill.png", 4.5f);


    public Cowbo(World world) {
        super(world, cowboShape);
        addImage(cowboImage);
        this.lives = 3;
        this.immune = false;
    }




}