/*
 * Copyright (c) 2019. Shallin Ris
 */

package com.bhhc.shallinris.controllers;

import com.bhhc.shallinris.dao.AnswerRepository;
import com.bhhc.shallinris.objects.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The Answer Controller allows the app to handle HTTP requests. It contains POST, PUT and DELETE as well as GET
 * endpoints
 */

@RestController
@RequestMapping(value = {"/", "api"})
public class AnswerController {

    @Autowired
    AnswerRepository answerRep;

    /**
     * Returns all answer objects
     *
     * @return all answers in the answer table
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value = "/answers")
    public Iterable<Answer> findAll() {
        Iterable<Answer> allAnswers = answerRep.findAll();
        return allAnswers;
    }

    /**
     * Creates a new answer
     *
     * @param answer The answer
     * @return the newly created answer id
     */
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    int createAnswer(@RequestBody Answer answer) {
        try {
            if (answer.getId() == 0) {
                answerRep.save(answer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer.getId();
    }

    /**
     * Updates and saves an answer
     *
     * @param answer the answer
     * @return the updated answer
     */
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public @ResponseBody
    Answer updateAnswer(@RequestBody Answer answer) {
        try {
            if (answer.getId() > 0) {
                answerRep.save(answer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    /**
     * Deletes the answer by its id
     *
     * @param id the id of the answer to be deleted
     */
    //todo: maybe add status for all of these
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public @ResponseBody
    void deleteAnswer(@PathVariable Integer id) {
        try {
            answerRep.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





