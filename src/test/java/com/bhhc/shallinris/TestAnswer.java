/*
 * Copyright (c) 2019. Shallin Ris
 */

package com.bhhc.shallinris;

import com.bhhc.shallinris.dao.AnswerRepository;
import com.bhhc.shallinris.objects.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/**
 * Test Answer tests core parts of the project; from the endpoints to object creation
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAnswer {

    @Autowired
    private AnswerRepository answerRep;

    /**
     * Create answer tests the save functionality
     */
    @Test
    public void createAnswer() {
        try {
            Answer answer = new Answer(0, "hello");
            answer = answerRep.save(answer);
            assertNotNull(answerRep.findById(answer.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Test set invalid text empty tests that the text field cannot be set to an empty value
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidTextEmpty() {
        Answer answer = new Answer();
        answer.setText("");
    }

    /**
     * Test set invalid text null tests that the text field cannot be set to a null value
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidTextNull() {
        Answer answer = new Answer();
        answer.setText(null);
    }

    /**
     * Test set invalid id negative tests that the id field cannot be set to a negative value
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidIdNegative() {
        Answer answer = new Answer();
        answer.setId(-1);
    }

    /**
     * Test set invalid id too large tests that the id field cannot be set to a value larger than the max id
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidIdTooLarge() {
        Answer answer = new Answer();
        answer.setId(5001);
    }

    /**
     * Update answer tests the update functionality
     */
    @Test
    public void updateAnswer() {
        try {
            Answer answer = new Answer(0, "hey");
            answer = answerRep.save(answer);
            Answer toUpdate = answerRep.findById(answer.getId());
            Answer temp = (Answer) toUpdate.clone();
            toUpdate.setText("hola");
            answerRep.save(toUpdate);
            Answer postUpdate = answerRep.findByText("hola");
            assertNotEquals(temp.getText(), postUpdate.getText());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Delete answer tests the delete functionality
     */
    @Test
    public void deleteAnswer() {
        try {
            Answer answer = new Answer(0, "hello");
            answerRep.save(answer);
            answerRep.delete(answer);
            Answer afterDelete = answerRep.findById(answer.getId());
            assertNull(afterDelete);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
