package nl.fontys.klusplatform.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateFreelancerRequest(
        @NotBlank String name,
        @NotBlank @Email String email) {
}
