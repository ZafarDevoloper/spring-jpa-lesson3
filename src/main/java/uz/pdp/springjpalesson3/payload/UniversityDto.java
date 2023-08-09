package uz.pdp.springjpalesson3.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniversityDto //Malumotllarni tashish uchun
{
    private String city;
    private String district;
    private String street;
    private String name;
}
