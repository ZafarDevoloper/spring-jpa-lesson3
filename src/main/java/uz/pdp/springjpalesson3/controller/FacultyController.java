package uz.pdp.springjpalesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springjpalesson3.entity.Faculty;
import uz.pdp.springjpalesson3.entity.University;
import uz.pdp.springjpalesson3.payload.FacultyDto;
import uz.pdp.springjpalesson3.repository.FacultyRepository;
import uz.pdp.springjpalesson3.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    UniversityRepository universityRepository;

    //Vazirlik Uchun
    @GetMapping()
    public List<Faculty>getAllFaculty()
    {
        return facultyRepository.findAll();
    }

    //University masul hodimi
    @PutMapping
    public String addFaculty(@RequestBody FacultyDto facultyDto)
    {
        if (facultyRepository.existsByNameAndId(facultyDto.getName(),facultyDto.getUniversityId()))
            return "this university already exist";
        Faculty faculty=new Faculty();
        Optional<University> optional = universityRepository.findById(facultyDto.getUniversityId());
        if (optional.isPresent()) {
            University university = optional.get();
            faculty.setUniversity(university);
            faculty.setName(facultyDto.getName());
            facultyRepository.save(faculty);
            return "data saved";
        }
return "university not found";
    }

    //University Hodim uchun
    @GetMapping("/byUniversityID/{id}")
    public List<Faculty>getFacultyByUniversityID(@PathVariable Integer id)
    {
return facultyRepository.findAllByUniversity_Id(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable Integer id)
    {
        try {
            facultyRepository.deleteById(id);
            return "faculty deleted";
        }
       catch (Exception e)
       {
           return "Error in delete";
       }
    }

@PutMapping("/{id}")
    public String editFaculty(@PathVariable Integer id, @RequestBody FacultyDto facultyDto)
{
    Optional<Faculty> optional = facultyRepository.findById(id);
    if (optional.isPresent()) {
        Faculty faculty = optional.get();
        faculty.setName(facultyDto.getName());
        Optional<University> optionalUniversity = universityRepository.findById(facultyDto.getUniversityId());
        if (optionalUniversity.isPresent()) {
            University university = optionalUniversity.get();
            faculty.setUniversity(university);
        }
return "faculty edited";
    }
    return "faculty not found";
}

}
