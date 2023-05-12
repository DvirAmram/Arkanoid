/*
 * 318192200
 * Dvir Amram
 * Counter
 */

/**
 * A class that will create objects that will be used as counters.
 *
 * @author Dvir Amram
 * @version 1.0 07 Jun 2021
 */
public class Counter {
    private int count;

    /**
     * constructor.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Counter promotion.
     *
     * @param number to add
     */
    public void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * subtract number from current count.
     *
     * @param number - the number
     */
    void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * get current count.
     *
     * @return count
     */
    int getValue() {
        return this.count;
    }
}