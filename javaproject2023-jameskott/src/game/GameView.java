package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {

    private final Image background;
    private final Image coin;
    private final Image heart;

    private int coins;
    private String coinString;
    private Cowbo cowbo;

    public GameView(World w, int width, int height, Cowbo cowbo) {
        super(w, width, height);
        background = new ImageIcon("data/background.png").getImage();
        coin = new ImageIcon("data/coin.png").getImage();
        heart = new ImageIcon("data/heart.png").getImage();
        this.cowbo = cowbo;
        int xCoord = 33;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("Apple Casual", Font.PLAIN, 18));
        g.drawImage(coin, 500,15, this);
        coins = cowbo.getCoins();
        coinString = Integer.toString(coins);
        g.drawString(coinString + "x" ,540, 35);
        for(int i = 0; i < cowbo.getLives(); i++){
            g.drawImage(heart, 33 + i*50,11, this);
        }

    }



}
