package uz.pdp.springjpalesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springjpalesson3.entity.Student;
import uz.pdp.springjpalesson3.repository.StudentRepository;
import uz.pdp.springjpalesson3.repository.UniversityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * for GET METHOD
     * 1.VAZIRLIK
     * 2.UNIVERSITY
     * 3.FACULTY DEKANAT
     * GROUP RAXBARI
     */
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    UniversityRepository universityRepository;
    //PAGE SAXIFALAB QAYATRISH UCHUN
    //VAZIRLIK UCHUN

    /**
     * REQUESTParam da keladi yani nechta nechta saxifalab olib kelishimiz agarda biz malumotni saxifalab olib
     * kelmaydigan bulsak serverni qotishiga olib keladi yani vazirlik malumotni suraganda hammma masaln 100000 mingta
     * malumot bor barchasini birdaniga server yuboradi bu surovni 10 kishi junatadigan bulsa 1 mln ta surov bulib ketadi
     * bu essa serverni qotishiga olib keladi shuning uchun malumotlarni page uram junatish kerak
     * @return
     */
    @GetMapping("/forMinistry")
    public Page<Student>getAllStudentForVazirlik(@RequestParam int page)//1-1=0
    {
        //select * from student limit 10 offset (0*10);//shu surov junatilmoqda databsaga
        //select * from student limit 10 offset ((2-1)*10);
        //select * from student limit 10 offset ((3-1)*10);//3 bu klent dan kelayotgan page
        //buni tushunmasangiz resources ichidagi rasmga qarang

        Pageable pageable = PageRequest.of(page,10);//bu surov tepadagi ishni qilib beradi
        Page<Student> all = studentRepository.findAll(pageable);
        return all;
    }

//    UNIVERSITY
    @GetMapping("university/{university_id}")
    public Page<Student> getAllStudentByUniversityId(@PathVariable Integer university_id,@RequestParam int page)
    {
        Pageable pageable=PageRequest.of(page,10);
        return studentRepository.findAllByGroup_Faculty_University_Id(university_id,pageable);

    }

}
