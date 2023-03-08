package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

public class GameView extends UserView {

    private final Image background;
    private final Image coin;

    public GameView(World w, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/background.png").getImage();
        coin = new ImageIcon("data/coin.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawImage(coin, 520,11, this);
    }



}
