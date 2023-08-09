package uz.pdp.springjpalesson3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    //bir kilasni boshqa bir kilas ichida ishlatilishi Agrigation deb ataladi bu Database da
    //forenkeyga tug'ri keladi
    @OneToOne
    private Address address;
    @ManyToMany
    private Set<Subject> subjectSet;

    @ManyToOne
    private Group group;
}
