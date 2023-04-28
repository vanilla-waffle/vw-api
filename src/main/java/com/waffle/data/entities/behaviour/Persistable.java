package com.waffle.data.entities.behaviour;

/**
 * Persistable.
 */
public interface Persistable {

    /**
     * Trigger function on persist operation.
     */
    void onPersist();
}
