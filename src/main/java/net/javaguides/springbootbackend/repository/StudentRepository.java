package net.javaguides.springbootbackend.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import net.javaguides.springbootbackend.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    @Query("from Student b where b.fullName=:keyword OR b.gpa=:keyword")
    Page<Student> findAll(Pageable pageable, @Param("keyword") String keyword);
}