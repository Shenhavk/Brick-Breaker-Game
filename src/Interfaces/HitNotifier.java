package Interfaces;

/**
 * Shenhav Katzav id: 209190560.
 * interface HitNotifier.
 * interface for hit notifier.
 */

public interface HitNotifier {
    /**
     * @param hl - given hit listener
     * this function adds hl as a listener to hit events.
     */
    void addHitListener(HitListener hl);
    /**
     * @param hl - given hit listener
     * this function removes hl from the list of listeners to hit events.
     */
    void removeHitListener(HitListener hl);
}