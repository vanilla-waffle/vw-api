package com.waffle.data.entities.behaviour;

/**
 * Persistable.
 */
public interface Persistable {

    /**
     * Triggers on persist.
     */
    void onPersist();
}
