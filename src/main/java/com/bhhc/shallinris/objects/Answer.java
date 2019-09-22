/*
 * Copyright (c) 2019. Shallin Ris
 */

package com.bhhc.shallinris.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;


/**
 * The Answer class creates the structure for object answer and provides access to answers why I want to work at BHHC
 */

@Entity
@Table(name = "ANSWERS")
public class Answer implements Cloneable {

    /**
     * Defines the maximum value for an answer id
     */
    public static final int MAX_ID = 5000;

    /**
     * Defines the max length for answer text
     */
    public static final short MAX_TEXT_LENGTH = 6000;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Size(max=400)
    private String text;

    /* Provides a default constructor for answers */
    public Answer() {

    }

    /**
     * Creates an answer given an id and answer text
     *
     * @param id   The answer id
     * @param text The answer text
     */
    public Answer(int id, String text) {

        setId(id);
        setText(text);
    }

    /**
     * Supports answer cloning
     *
     * @return the object
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Gets the id for the answer
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the answer id and returns an answer for call chaining
     *
     * @param id The id value (up to ~32k values)
     * @return The Answer
     */
    public Answer setId(int id) {

        if (id < 0 || id > MAX_ID) {
            throw new IllegalArgumentException("The id must be between 0 and " + MAX_ID);
        }

        this.id = id;
        return this;
    }

    /**
     * Gets the answer text
     *
     * @return the answer text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the answer text and returns an Answer for call chaining
     *
     * @param text The answer text
     * @return The Answer
     * @throws IllegalArgumentException when text is empty
     */
    public Answer setText(String text) throws IllegalArgumentException {

        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Answer text is required.");
        }

        if (text.length() >= MAX_TEXT_LENGTH) {
            throw new IllegalArgumentException("Answer text length must be less than " + MAX_TEXT_LENGTH);
        }

        this.text = text;
        return this;
    }
}
