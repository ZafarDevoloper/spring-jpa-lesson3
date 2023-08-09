package uz.pdp.springjpalesson3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity(name = "my_group")
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Faculty faculty;//eng kup ishlatiladigani
}
