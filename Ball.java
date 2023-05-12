/*
 * 318192200
 * Dvir Amram
 * Ball
 */

import java.awt.Color;

import biuoop.DrawSurface;

/**
 * A class creates an object that describes a moving ball on a plane by center, radius, color and velocity.
 *
 * @author Dvir Amram
 * @version 1.0 12 Apr 2021
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Velocity v;
    private Color color;
    private GameEnvironment gameEnvironment;

    /**
     * constructor.
     *
     * @param center of the ball
     * @param r      radius
     * @param color  of the ball
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = Math.abs(r);
        this.color = color;
    }

    /**
     * constructor.
     *
     * @param x     value
     * @param y     value
     * @param r     of the point
     * @param color of the point
     */
    public Ball(int x, int y, int r, Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * access to x of center.
     *
     * @return x
     */
    public double getX() {
        return this.center.getX();
    }

    /**
     * access to y of center.
     *
     * @return y
     */
    public double getY() {
        return this.center.getY();
    }

    /**
     * access to radius.
     *
     * @return radius
     */
    public int getSize() {
        return this.r;
    }

    /**
     * access to color.
     *
     * @return color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface given parameter
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), r);
        surface.setColor(Color.black);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), r);
    }

    /**
     * Set velocity.
     *
     * @param vel velocity
     */
    public void setVelocity(Velocity vel) {
        this.v = vel;
    }

    /**
     * Set velocity.
     *
     * @param dx of movement
     * @param dy 0f movement
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * access to velocity.
     *
     * @return velocity
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * Check if the ball is outside the frame limits, if so - put it in the frame.
     *
     * @param width  of frame
     * @param height of frame
     */
    public void insertIntoFrame(int width, int height) {
        if (this.center.getX() <= this.r) {
            this.center.setX(this.r + 1);
        }
        if (this.center.getX() >= width - this.r) {
            this.center.setX(width - this.r - 1);
        }
        if (this.center.getY() <= this.r) {
            this.center.setY(this.r + 1);
        }
        if (this.center.getY() >= height - this.r) {
            this.center.setY(height - this.r - 1);
        }
    }

    /**
     * let the ball know his game environment.
     *
     * @param game = list of collidable
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.gameEnvironment = game;
    }

    /**
     * update the center of the ball after a hit according to his radius.
     * @param block - hitten
     */
    public void updateCenter(Collidable block) {
        if (block.getCollisionRectangle().bottomEdge().ifPointOnLine(this.center)) {
            this.center.setY(this.getY() + this.r + 1);
        }
        if (block.getCollisionRectangle().upperEdge().ifPointOnLine(this.center)) {
            this.center.setY(this.getY() - this.r - 1);
        }
        if (block.getCollisionRectangle().leftEdge().ifPointOnLine(this.center)) {
            this.center.setX(this.getX() - this.r - 1);
        }
        if (block.getCollisionRectangle().rightEdge().ifPointOnLine(this.center)) {
            this.center.setX(this.getX() + this.r + 1);
        }
    }

    /**
     * Move the ball according to its velocity and to his game environment.
     */
    public void moveOneStep() {
        Point start = this.center;
        Point end = new Point(this.center.getX() + this.v.getDx(), this.center.getY() - this.v.getDy());
        Line trajectory = new Line(start, end);
        CollisionInfo info = this.gameEnvironment.getClosestCollision(trajectory);
        // if there is collision close, update the center.
        if (info != null) {
            this.center = info.collisionPoint();
            this.v = info.collisionObject().hit(this, this.center, this.v);
            updateCenter(info.collisionObject());
        } else {
            // if there is no collision close, move on
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     * call move one step.
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * let to the ball and the game know each other.
     *
     * @param game to add the ball into
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        this.setGameEnvironment(game.getGameEnvironment());
    }

    /**
     * remove the ball From the Game.
     * @param game - the game to remove from it.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        this.setGameEnvironment(null);
    }
}
