package LevelInfo;
import Animation.GameLevel;
import Sprites.Sprite;
import biuoop.DrawSurface;
import java.awt.*;

public abstract class Background implements Sprite {
    @Override
    public abstract void drawOn(DrawSurface surface);

    @Override
    public void timePassed() { }

    @Override
    public void addToGame(GameLevel g) { }
}
