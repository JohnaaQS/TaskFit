package nl.fontys.klusplatform.repository;

import nl.fontys.klusplatform.model.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
}
