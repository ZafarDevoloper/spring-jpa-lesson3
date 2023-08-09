package uz.pdp.springjpalesson3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "university_id"}))//data base dagi
// nomini berish kerak
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private University university;
}
