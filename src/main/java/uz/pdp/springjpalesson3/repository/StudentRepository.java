package uz.pdp.springjpalesson3.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.springjpalesson3.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "select * FROM student s join my_group g on \n" +
            "s.id = g.id join faculty f on f.id = g.id join university u on u.id=:university_id",nativeQuery = true)
    Page<Student>findAllByGroup_Faculty_University_Id(Integer university_id, Pageable pageable);
}
