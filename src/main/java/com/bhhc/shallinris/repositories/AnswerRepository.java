/*
 * Copyright (c) 2019. Shallin Ris
 */

package com.bhhc.shallinris.repositories;

import com.bhhc.shallinris.models.Answer;
import org.springframework.data.repository.CrudRepository;

/**
 * The Answer Repository allows user to retrieve and search data in the Answer table
 */

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    Answer findById(int id);

    Answer findByText(String text);
}
