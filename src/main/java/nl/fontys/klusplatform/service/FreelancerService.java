package nl.fontys.klusplatform.service;

import java.util.List;

import nl.fontys.klusplatform.dto.CreateFreelancerRequest;
import nl.fontys.klusplatform.model.Freelancer;
import nl.fontys.klusplatform.repository.FreelancerRepository;
import org.springframework.stereotype.Service;

@Service
public class FreelancerService {

    private final FreelancerRepository freelancerRepository;

    public FreelancerService(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    public List<Freelancer> getAll() {
        return freelancerRepository.findAll();
    }

    public Freelancer create(CreateFreelancerRequest request) {
        return freelancerRepository.save(new Freelancer(request.name(), request.email()));
    }
}
