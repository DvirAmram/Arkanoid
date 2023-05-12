/*
 * 318192200
 * Dvir Amram
 * Block
 */

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The class creates an object that describes a block in a plane.
 *
 * @author Dvir Amram
 * @version 1.0 26 Apr 2021
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle rect;
    private Color color;

    /**
     * constructor.
     *
     * @param rect  A rectangle that will define the boundaries of the block
     * @param color The color of the block
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * access to the rectangle.
     *
     * @return rect
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * update the velocity of object after collision.
     *
     * @param collisionPoint  (the center of the ball)
     * @param currentVelocity of the ball
     * @param hitter          the ball.
     * @return new velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // If the ball hit a horizontal side of the block
        if (this.rect.bottomEdge().ifPointOnLine(collisionPoint)
                || this.rect.upperEdge().ifPointOnLine(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        // If the ball hit a vertical side of the block
        if (this.rect.rightEdge().ifPointOnLine(collisionPoint) || this.rect.leftEdge().ifPointOnLine(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * Drawing the block on the surface.
     *
     * @param d Surface to draw on
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
     * check if point on the scope of the block.
     *
     * @param p Point
     * @return true/false
     */
    public boolean ifPointOnBlock(Point p) {
        if (this.rect.bottomEdge().ifPointOnLine(p) || this.rect.upperEdge().ifPointOnLine(p)
                || this.rect.rightEdge().ifPointOnLine(p) || this.rect.leftEdge().ifPointOnLine(p)) {
            return true;
        }
        return false;
    }

    /**
     * check if point in the block.
     *
     * @param p point to check
     * @return true/false
     */
    public boolean ifPointInBlock(Point p) {
        double x = p.getX();
        double y = p.getY();
        double x1 = this.rect.getUpperLeft().getX();
        double x2 = this.rect.getUpperRight().getX();
        double y1 = this.rect.getUpperLeft().getY();
        double y2 = this.rect.getBottomLeft().getY();
        if ((x1 < x) && (x < x2) && (y1 < y) && (y < y2)) {
            return true;
        }
        return false;
    }

    /**
     * Do not change anything for now.
     */
    public void timePassed() {
    }

    /**
     * add the block into the sprite list and the collidable list of the game.
     *
     * @param game game to add the block into it
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * remove this block from his game.
     *
     * @param game - the game to remove from
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * Notify of a collision.
     *
     * @param hitter the ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
