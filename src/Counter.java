//ID: 206628794

/**
 * @author Amit Shavit
 * a Block class implementing the Collidable interface
 */
public class Counter {
    private int c = 0;

    /**
     * constructor.
     * @param c - count number
     */
    public Counter(int c) {
        this.c = c;
    }

    /**
     * add number to current count.
     * @param number - number to add
     */
    void increase(int number) {
        c += number;
    }

    /**
     * subtract number from current count.
     * @param number - number to remove
     */
    void decrease(int number) {
        c -= number;
    }

    /**
     *  get current count.
     * @return int value of counter.
     */
    int getValue() {
        return c;
    }
}