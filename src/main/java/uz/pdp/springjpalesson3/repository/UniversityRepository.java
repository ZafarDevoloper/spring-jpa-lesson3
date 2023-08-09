package uz.pdp.springjpalesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.springjpalesson3.entity.University;

@Repository
public interface UniversityRepository extends JpaRepository<University,Integer> {
}
