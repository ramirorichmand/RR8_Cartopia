package ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>   {

    public Admin findByMobileNumber(String mobileNo);

    public Admin findByAdminId(Integer AdminId);

}