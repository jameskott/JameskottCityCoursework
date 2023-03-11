package game;

import city.cs.engine.*;

import javax.swing.*;


public class Game {

    private GameWorld world;

    // A graphical display of the world
    private final GameView view;

    private SoundClip gameMusic;


    // Initialise a new Game
    public Game() {

        // make the world
        GameWorld world = new GameWorld();

        // make a view
        view = new GameView(world, 600, 600, world.getCowbo());

        //Add controls to cowbo
        CowboController controller = new CowboController(world.getCowbo());
        view.addKeyListener(controller);

        //adding step and mouse listeners
        view.addMouseListener(new GiveFocus(view));
        world.addStepListener(new Display(view, world.getCowbo()));

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Cowbo");
        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();


    }

    public static void main(String[] args) {

        new Game();
    }
}
