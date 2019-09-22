package com.bhhc.shallinris;

import com.bhhc.shallinris.repositories.AnswerRepository;
import com.bhhc.shallinris.models.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * The Demo Application contains the main method and also populates the answer table with data
 */

@SpringBootApplication
public class DemoApplication {

    @Autowired
    AnswerRepository answerRep;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * This method is called once after initialization. It is used to populate the database with default values
     */
    @PostConstruct
    public void init() {
        answerRep.save(new Answer(1, "His philosophy behind investing as well as his philanthropic tendencies. " +
                "He, along with Bill Gates, are the most charitable billionaires, and I believe that a company owners philosophy seeps down to the " +
                "company. It would make me proud to work at a company that is owned by warren buffet"));
        answerRep.save(new Answer(2, "I want to work at a company that is a brand name and does its job well, " +
                "and BHHC does/is just this. In its chosen markets, BHHC was awarded A++ A.M. Best rating, the highest rating " +
                "they award insurance carriers. I also like working on products that have tangible positive impacts on other people "));
        answerRep.save(new Answer(3, "Studies show, and I know from personal experience, that employees are more loyal to and work harder for their company when they are treated well and taken care of by it. BHHC takes great care of their employees in the form of solid benefit packages as well as workers comp. They also treat their employees well because they understand the importance of this in retaining good people"));
    }
}
