/*
 * Copyright (c) 2019. Shallin Ris
 */

package com.bhhc.shallinris;

import com.bhhc.shallinris.repositories.AnswerRepository;
import com.bhhc.shallinris.models.Answer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.*;

import java.util.Set;

import static org.junit.Assert.*;


/**
 * Test Answer tests core parts of the project; from the endpoints to object creation
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAnswer {

    private static Validator validator;
    @Autowired
    private AnswerRepository answerRep;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Create answer tests the save functionality
     */
    @Test
    public void createAnswer() {
        try {
            Answer answer = new Answer(1, "hello");
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
     * Test set invalid id too large tests that the id field cannot be set to a value larger than the
     * max value specified in the answer class
     */
    @Test
    public void testShouldDetectInvalidId() {
        Answer answer = new Answer(5001, "hi");
        Set<ConstraintViolation<Answer>> violations
                = validator.validate(answer);
        assertEquals(violations.size(), 1);
    }

    /**
     * Update answer tests the update functionality
     */
    @Test
    public void updateAnswer() {
        try {
            Answer answer = new Answer(1, "hey");
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
            Answer answer = new Answer(1, "hello");
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
