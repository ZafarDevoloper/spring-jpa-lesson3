package uz.pdp.springjpalesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springjpalesson3.entity.Subject;
import uz.pdp.springjpalesson3.repository.SubjectRepository;

@Repository
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;
    @PostMapping()
    public String addSubject(@RequestBody Subject subject)
    {
        if (subjectRepository.existsByName(subject.getName())) {
            return "this subject alredy exsist";
        }
        subjectRepository.save(subject);
        return "subject added";
    }

}
