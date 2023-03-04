package game;

import city.cs.engine.*;

public class Cowbo extends Walker {
    private static final Shape studentShape = new PolygonShape(
            1.12f,1.81f, 1.08f,-1.7f, -1.08f,-1.72f, -1.27f,1.81f);

    private static final BodyImage studentImage =
            new BodyImage("data/cowbostill.png", 4.5f);

    private int credits;

    private int books;

    public Cowbo(World world) {
        super(world, studentShape);
        addImage(studentImage);

        credits = 0;
        books = 0;
    }

    public void setCredits(int credits){
        this.credits = credits;
    }
    public int getCredits(){
        return credits;
    }

    public void setBooks(int books){
        this.books = books;
    }
    public int getBooks(){
        return books;
    }



}