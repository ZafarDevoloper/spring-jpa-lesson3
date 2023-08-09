package uz.pdp.springjpalesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springjpalesson3.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    boolean existsByName(String name);//malumotlar omborida shunaqanginomli bormi
}
