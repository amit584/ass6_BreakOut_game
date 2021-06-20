package LevelInfo;
import java.awt.Color;
import Animation.*;
import Behavior.*;
import Sprites.*;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

public class WideEasy implements LevelInformation {
    static final int SPEED = 6;
    static final int BLOCK_WIDTH = 780 / 15;
    static final int BLOCK_HEIGHT = 30;

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Point> ballsStartPoints() {
        List<Point> start = new ArrayList<Point>();
        for (int i = 0; i < numberOfBalls() / 2; i++) {
            Point p = new Point((380 - (i * BLOCK_HEIGHT)),
                    300 + (BLOCK_HEIGHT * i));
            start.add(p);
        }
        for (int i = 0; i < numberOfBalls() / 2; i++) {
            Point p = new Point((420 + (i * BLOCK_HEIGHT)),
                    300 + (BLOCK_HEIGHT * i));
            start.add(p);
        }
        return start;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> vel = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            Velocity v = Velocity.fromAngleAndSpeed(0, SPEED);
            vel.add(v);
        }
        return vel;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 400;
    }

    @Override
    public String levelName() {
        return "Wilde Easy";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background() {
            @Override
            public void drawOn(DrawSurface surface) {
                surface.setColor(new Color(61, 178, 226));
                surface.fillRectangle(0, 0, GameLevel.FRAME_WIDTH + GameLevel.BORDER_SIZE,
                        GameLevel.FRAME_HEIGHT + GameLevel.BORDER_SIZE);
                surface.setColor(new Color(207, 216, 220));
                surface.fillCircle(60, 100, 30);
                surface.fillCircle(100, 100, 30);
                surface.fillCircle(80, 80, 30);
                surface.fillCircle(560, 200, 30);
                surface.fillCircle(530, 200, 30);
                surface.fillCircle(580, 180, 30);
                surface.setColor(new Color(255, 255, 255));
                surface.drawText(40, 100, "MARIO", 20);
                surface.drawText(40, 120, "007100", 20);
                surface.drawText(560, 100, "WORLD", 20);
                surface.drawText(560, 120, "1-1", 20);
                surface.setColor(new Color(119, 219, 88));
                surface.fillRectangle(90, 460, 80, 100);
                surface.setColor(new Color(107, 205, 76));
                surface.fillRectangle(68, 438, 124, 64);
                surface.setColor(new Color(119, 219, 88));
                surface.fillRectangle(70, 440, 120, 60);
                surface.fillCircle(370, 560, 30);
                surface.setColor(new Color(100, 170, 90));
                surface.fillCircle(430, 560, 30);
                surface.setColor(new Color(109, 210, 72));
                surface.fillCircle(400, 550, 30);
                surface.setColor(new Color(182, 95, 59));
                surface.fillRectangle(570, 380, 100, 100);
                surface.fillRectangle(550, 450, 140, 120);
                surface.setColor(new Color(0, 0, 0));
                surface.drawRectangle(550, 450, 140, 120);
                surface.drawRectangle(550, 450, 20, 120);
                surface.drawRectangle(580, 450, 20, 120);
                surface.drawRectangle(610, 450, 20, 120);
                surface.drawRectangle(640, 450, 20, 120);
                surface.drawRectangle(670, 450, 20, 120);
                surface.drawRectangle(570, 380, 100, 70);
                surface.drawRectangle(590, 380, 20, 70);
                surface.drawRectangle(610, 380, 20, 70);
                surface.drawRectangle(630, 380, 22, 70);
                surface.fillRectangle(600, 475, 40, 100);
                surface.fillRectangle(590, 400, 30, 30);
                surface.setColor(new Color(250, 221, 51));
                surface.fillOval(100, 200, 20, 40);
                surface.fillOval(100, 400, 20, 40);
                surface.fillOval(200, 360, 20, 40);
                surface.fillOval(500, 500, 20, 40);
                surface.setColor(new Color(113, 69, 45));
                surface.fillRectangle(0, 560, GameLevel.FRAME_WIDTH, 40);
                surface.setColor(new Color(105, 158, 72));
                surface.fillRectangle(0, 560, GameLevel.FRAME_WIDTH, 10);
                surface.setColor(new Color(0, 0, 0));
                surface.drawText(550, 570, "I WORKED REALLY HARD ON THIS BACKGROUND :)", 8);

            }
        };
        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            int j = 0;
            if (i % 2 == 0) {
                j = 50;
            }
            Point p = new Point(GameLevel.BORDER_SIZE + (i * BLOCK_WIDTH), 150 + j);
            Block block = new Block(BLOCK_HEIGHT, BLOCK_WIDTH, new Color(189, 155, 84), p);
            blocks.add(block);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
