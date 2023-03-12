package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpiderJumpCooldown implements ActionListener {
    private Spider spider;

    public SpiderJumpCooldown(Spider spider) {
        this.spider = spider;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        spider.setJumpOffCd(true);
    }
}
