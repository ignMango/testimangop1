package ar.com.imango.examen.repository;

import ar.com.imango.examen.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u join u.loans l where l.user = u.id and u.id = :id ")
    Users findUsersBy(@Param("id")Long id);
}
