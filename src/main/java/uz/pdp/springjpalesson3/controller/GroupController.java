package uz.pdp.springjpalesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springjpalesson3.entity.Faculty;
import uz.pdp.springjpalesson3.entity.Group;
import uz.pdp.springjpalesson3.payload.GroupDto;
import uz.pdp.springjpalesson3.repository.FacultyRepository;
import uz.pdp.springjpalesson3.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;

    //Vazirlik uchun
    @GetMapping
    public List<Group>getAllGroup()
    {
        return groupRepository.findAll();
    }
    //Dekanat uchun
    @GetMapping("/byUniversityId/{university_id}")
    public List<Group>getAllGroupByUniversityId(@PathVariable Integer university_id)
    {
return groupRepository.getAllByUniversityNative(university_id);
    }

    @PostMapping
    public String addGroup(@RequestBody GroupDto groupDto)
    {
        Group group = new Group();
        group.setName(groupDto.getName());
        Optional<Faculty> optional = facultyRepository.findById(groupDto.getFaculty_id());
        if (optional.isPresent()) {
            Faculty faculty = optional.get();
            group.setFaculty(faculty);
            groupRepository.save(group);
            return "saved";
        }
        return "not found this faculty id";
    }
}
