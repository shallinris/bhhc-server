package com.example.demo.dao;

import com.example.demo.objects.Answer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    Answer findById(int id);
//    List<Answer> findAll();

}
