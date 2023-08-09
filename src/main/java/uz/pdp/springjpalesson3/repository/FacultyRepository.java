package uz.pdp.springjpalesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springjpalesson3.entity.Faculty;
import uz.pdp.springjpalesson3.payload.FacultyDto;
import uz.pdp.springjpalesson3.payload.UniversityDto;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Integer> {

    boolean existsByNameAndId(String name,Integer university_id);

    List<Faculty> findAllByUniversity_Id(Integer university_id);
}
