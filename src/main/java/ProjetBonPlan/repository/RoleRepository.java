package ProjetBonPlan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.Role;
 
 
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
 
    Role findByName(String name);
}
