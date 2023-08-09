package uz.pdp.springjpalesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springjpalesson3.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
