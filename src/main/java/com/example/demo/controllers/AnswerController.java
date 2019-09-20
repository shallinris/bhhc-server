package com.example.demo.controllers;

import com.example.demo.dao.AnswerRepository;
import com.example.demo.objects.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= {"/", "api"})
public class AnswerController {

    @Autowired
    AnswerRepository answerRep;

    @RequestMapping(method = RequestMethod.GET, value="/retrieveAll")
    public String hello() {
        return "Hello2";
    }

    //(
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.GET, value="/answer")
    public Iterable<Answer> findAll() {
        Iterable<Answer> allAnswers =  answerRep.findAll();
//        List<Answer> allAnswers = new ArrayList<Answer>();
//        allAnswers.add(new Answer(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
//        allAnswers.add(new Answer(2, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
//        allAnswers.add(new Answer(3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        return allAnswers;
    }

    @RequestMapping(method= RequestMethod.POST)
    public @ResponseBody
    int createMedication(@RequestBody Answer answer){
        try {
            if (answer.getId() == 0) {
//                answerRep.save(answer);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return answer.getId();
    }

    @RequestMapping(method = RequestMethod.PUT, value="{id}")
    public @ResponseBody
    Answer updateAnswer(@RequestBody Answer answer) {
        try {
            if (answer.getId() > 0) {
                answerRep.save(answer);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    //todo: maybe add status for all of these
    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public @ResponseBody
    void deleteAnswer(@PathVariable Integer id) {
        try {
            answerRep.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}





