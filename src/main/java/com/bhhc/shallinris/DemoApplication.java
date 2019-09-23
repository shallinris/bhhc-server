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
        answerRep.save(new Answer(1, "First, I deeply respect and appreciate Warren Buffett’s investing philosophy and philanthropic work. I believe the philosophy of a company’s leader permeates the company, and as an employee, I would feel pride in my work knowing the overarching principles at any subsidiary of Warren Buffett’s would be non-predatory, and embody integrity, professionalism and sound ethics. "));
        answerRep.save(new Answer(2, "Second, it is crucial to me to work for a company which holds itself to the highest professional standards in its course of work. Berkshire Hathaway is consistently awarded the highest ratings among insurance carriers, and that is an indication to me that I will be proud to come to work everyday.   "));
        answerRep.save(new Answer(3, "Finally, it is my understanding, verified by the reviews of former employees, that Berkshire Hathaway truly cares for its employees and strives to retain quality people by fostering their professional development while ensuring a positive work experience. "));
    }
}
