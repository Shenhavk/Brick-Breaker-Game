package Default;

/**
 * Shenhav Katzav id: 209190560.
 * class Counter
 * class for Counter. member is the Counter's int value
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
     * @param count - given value of the counter
     * constructor.
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * @param number - given number
     * this function increase the counter with the given number
     */
    public void increase(int number) {
        this.count += number;
    }
    /**
     * @param number - given number
     * this function subtract number from the current count
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * @return - value of current count
     * this function returns the value of the counter
     */
    public int getValue() {
        return this.count;
    }
}