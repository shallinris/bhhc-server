package com.example.demo;

import com.example.demo.dao.AnswerRepository;
import com.example.demo.objects.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.junit4.SpringRunner;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
public class TestAnswer {

    private MockMvc mvc;

    @Autowired
    private AnswerRepository answerRep;

    @Autowired
    ObjectMapper mapper;

//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }

    @Test
    public void createAnswer() {
        try {
            Answer answer = new Answer(1, "hello");
            answerRep.save(answer);
            assertNotNull(answerRep.findById(1));

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void updateAnswer() {
        try {
            Answer answer = new Answer(2, "hey");
            answer = answerRep.save(answer);
            Answer toUpdate = answerRep.findById(answer.getId());
            Answer temp = (Answer)toUpdate.clone();
            toUpdate.setAnswer("hola");
            answerRep.save(toUpdate);
            assertNotEquals(temp.getAnswer(), toUpdate.getAnswer());
        } catch(Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void deleteAnswer() {
        try {
            Answer answer = new Answer(1, "hello");
            answerRep.save(answer);
            answerRep.delete(answer);
            assertNull(answer);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
