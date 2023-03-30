package ProjetBonPlan.repository;

import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer>{
    public User findByEmail(String email);

    //public User findByEmailAndPassword(String email, String password);
}

