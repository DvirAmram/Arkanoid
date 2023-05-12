/*
 * 318192200
 * Dvir Amram
 * paddle
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The class defines an object to be the "player".
 *
 * @author Dvir Amram
 * @version 1.0 26 Apr 2021
 */
public class Paddle implements Sprite, Collidable {
    static final int X = 370;
    static final int Y = 560;
    static final int HEIGHT = 20;
    static final int X_MIN = 20;
    static final int X_MAX = 780;
    static final int DEGREES_300 = 300;
    static final int DEGREES_330 = 330;
    static final int DEGREES_30 = 30;
    static final int DEGREES_60 = 60;
    static final int FIFTH = 5;
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;
    private Color color;
    private int velocity;
    private int width;

    /**
     * constructor.
     *
     * @param keyboard the keyboard
     * @param v        the velocity
     * @param width    the width
     */
    public Paddle(KeyboardSensor keyboard, int v, int width) {
        this.rect = new Rectangle(new Point(400 - (width / 2), Y), width, HEIGHT);
        this.color = Color.ORANGE;
        this.keyboard = keyboard;
        this.velocity = v;
        this.width = width;
    }

    /**
     * move the paddle left.
     */
    public void moveLeft() {
        // if there is enough place
        if (this.rect.getUpperLeft().getX() >= X_MIN + this.velocity) {
            Point p = new Point((int) this.rect.getUpperLeft().getX() - this.velocity,
                    (int) this.rect.getUpperLeft().getY());
            this.rect.setUpperLeft(p);
        } else {
            // if the paddle is already almost in the left corner
            Point p = new Point(X_MIN, (int) this.rect.getUpperLeft().getY());
            this.rect.setUpperLeft(p);
        }
    }

    /**
     * move the paddle right.
     */
    public void moveRight() {
        // if there is enough place
        if (this.rect.getUpperLeft().getX() <= X_MAX - this.velocity - this.rect.getWidth()) {
            Point p = new Point((int) this.rect.getUpperLeft().getX() + this.velocity,
                    (int) this.rect.getUpperLeft().getY());
            this.rect.setUpperLeft(p);
        } else {
            // if the paddle is already almost in the left corner
            Point p = new Point(X_MAX - this.rect.getWidth(), (int) this.rect.getUpperLeft().getY());
            this.rect.setUpperLeft(p);
        }
    }

    /**
     * Sprite - change location.
     */
    public void timePassed() {
        // if the player pressed LEFT_KEY
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        // if the player pressed Right_KEY
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw the paddle on the surface.
     *
     * @param d - the surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        int x = (int) this.rect.getUpperLeft().getX();
        int y = (int) this.rect.getUpperLeft().getY();
        int w = (int) this.rect.getWidth();
        int h = (int) this.rect.getHeight();
        d.fillRectangle(x, y, w, h);
        d.setColor(Color.black);
        d.drawRectangle(x, y, w, h);
    }

    /**
     * access to rhe rectangle.
     *
     * @return rect
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // if the ball hit the upper edge of the paddle
        if (this.rect.upperEdge().ifPointOnLine(collisionPoint)) {
            // split the upper edge for 5 parts
            double x0 = this.rect.getUpperLeft().getX();
            double x1 = x0 + this.rect.getWidth() / FIFTH;
            double x2 = x1 + this.rect.getWidth() / FIFTH;
            double x3 = x2 + this.rect.getWidth() / FIFTH;
            double x4 = x3 + this.rect.getWidth() / FIFTH;
            double x5 = x4 + this.rect.getWidth() / FIFTH;
            double x = collisionPoint.getX();
            double speed = currentVelocity.getSpeed();
            // if the hit on the first part
            if ((x0 <= x) && (x <= x1)) {
                Velocity v = Velocity.fromAngleAndSpeed(DEGREES_300, speed);
                return v;
                // if the hit on the second part
            } else if ((x1 <= x) && (x <= x2)) {
                Velocity v = Velocity.fromAngleAndSpeed(DEGREES_330, speed);
                return v;
                // if the hit on the third part
            } else if ((x2 <= x) && (x <= x3)) {
                Block b = new Block(this.rect, this.color);
                return b.hit(hitter, collisionPoint, currentVelocity);
                // if the hit on the fourth part
            } else if ((x3 <= x) && (x <= x4)) {
                Velocity v = Velocity.fromAngleAndSpeed(DEGREES_30, speed);
                return v;
                // if the hit on the fifth part
            } else if ((x4 <= x) && (x <= x5)) {
                Velocity v = Velocity.fromAngleAndSpeed(DEGREES_60, speed);
                return v;
            }
        }
        // if the hit is not on the upper edge
        Block b = new Block(this.rect, this.color);
        return b.hit(hitter, collisionPoint, currentVelocity);

    }

    /**
     * adding the paddle to the game.
     *
     * @param g - the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}