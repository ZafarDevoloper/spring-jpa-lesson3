package uz.pdp.springjpalesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.springjpalesson3.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Integer> {
    List<Group> findAllByFaculty_University_Id(Integer faculty_university_id);//jpa orqali

    @Query("select gr from my_group gr where gr.faculty.university.id=:universityId")
    List<Group>getAllByUniversityId(Integer universityId);//jpa query bu


    @Query(value = "select *\n" +
            "from my_group gr\n" +
            "         join faculty f on f.id = gr.faculty_id\n" +
            "         join university u on u.id = f.university_id where u.id=:universityId",nativeQuery = true)
    List<Group>getAllByUniversityNative(Integer universityId);

}
