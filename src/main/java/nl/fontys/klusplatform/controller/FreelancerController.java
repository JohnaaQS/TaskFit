package nl.fontys.klusplatform.controller;

import java.util.List;

import jakarta.validation.Valid;
import nl.fontys.klusplatform.dto.CreateFreelancerRequest;
import nl.fontys.klusplatform.model.Freelancer;
import nl.fontys.klusplatform.service.FreelancerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/freelancers")
public class FreelancerController {

    private final FreelancerService freelancerService;

    public FreelancerController(FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    @GetMapping
    public List<Freelancer> getAll() {
        return freelancerService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Freelancer create(@Valid @RequestBody CreateFreelancerRequest request) {
        return freelancerService.create(request);
    }
}
