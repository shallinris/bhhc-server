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
        answerRep.save(new Answer(1, "First, I deeply respect and appreciate Warren Buffet’s investing philosophy and philanthropic work. I believe the philosophy of a company’s leader permeates the company, and as an employee, I would feel pride in my work knowing the overarching principles at any subsidiary of Warren Buffet’s would be non-predatory, and embody integrity, professionalism and sound ethics. "));
        answerRep.save(new Answer(2, "Second, I want to work at a company that is respected because it does its job well. In its chosen markets, BHHC has been awarded the highest rating for insurance carriers by A.M.Best. "));
        answerRep.save(new Answer(3, "Finally, studies show, and I know from personal experience, that employees are more loyal to and work harder for their company when they are well-treated and taken care of. According to Glassdoor and other reviewers,  BHHC takes great care of their employees in terms of benefits and employee support. They also treat their employees well because they understand the importance of this in retaining good people. "));
    }
}
