package uz.pdp.springjpalesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springjpalesson3.entity.Address;
import uz.pdp.springjpalesson3.entity.University;
import uz.pdp.springjpalesson3.payload.UniversityDto;
import uz.pdp.springjpalesson3.repository.AddressRepository;
import uz.pdp.springjpalesson3.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/university")
public class UniversityController {

    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    AddressRepository addressRepository;

    //    READ
    @GetMapping
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    //READ*
    @GetMapping(value = "/{id}")
    public University getUniversityById(@PathVariable Integer id) {
        Optional<University> optional = universityRepository.findById(id);
        return optional.orElseGet(University::new);
    }

    @PostMapping
    public String addUniversity(@RequestBody UniversityDto universityDto) {
        Address address = new Address();
        address.setCity(universityDto.getCity());
        address.setDistrict(universityDto.getDistrict());
        address.setStreet(universityDto.getStreet());
        Address save = addressRepository.save(address);
        University university = new University();
        university.setAddress(save);
        university.setName(universityDto.getName());
        universityRepository.save(university);
        return "data saved";
    }

    @PutMapping("/{id}")
    public String editedUniversity(@PathVariable Integer id,@RequestBody UniversityDto universityDto)
    {
        Optional<University> optional = universityRepository.findById(id);
        if (optional.isPresent()) {
            University university = optional.get();
            university.setName(universityDto.getName());
            Address address = university.getAddress();//bazadan addres keldi
            address.setCity(universityDto.getStreet());
            address.setStreet(universityDto.getCity());
            address.setDistrict(universityDto.getDistrict());
            university.setAddress(address);
            addressRepository.save(address);
            universityRepository.save(university);
            return "university added";
        }
return "not found";

    }

    @DeleteMapping(value = "{id}")
    public String deleteUniversityById(@PathVariable Integer id)
    {
        universityRepository.deleteById(id);
        return "university deleted";
    }
}
