package com.mulakat.insurance_policy_service.services.concretes;

import com.mulakat.insurance_policy_service.dtos.request.CreateInsurancePolicy;
import com.mulakat.insurance_policy_service.dtos.response.InsurancePolicyResponse;
import com.mulakat.insurance_policy_service.entities.InsurancePolicy;
import com.mulakat.insurance_policy_service.mappers.InsurancePolicyMapper;
import com.mulakat.insurance_policy_service.repositories.InsurancePolicyRepository;
import com.mulakat.insurance_policy_service.services.abstracts.InsurancePolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    private final InsurancePolicyRepository insurancePolicyRepository;
    private final InsurancePolicyMapper insurancePolicyMapper;

    @Override
    public InsurancePolicyResponse createInsurancePolicy(CreateInsurancePolicy request) {
        InsurancePolicy insurancePolicy = insurancePolicyMapper.toEntity(request);
        insurancePolicy.setCreatedAt(LocalDateTime.now());
        insurancePolicy.setUpdatedAt(LocalDateTime.now());

        InsurancePolicy savedInsurancePolicy = insurancePolicyRepository.save(insurancePolicy);
        return insurancePolicyMapper.toResponse(savedInsurancePolicy);
    }

    @Override
    public List<InsurancePolicyResponse> getAllInsurancePolicies() {
        return insurancePolicyRepository.findAll()
                .stream()
                .map(insurancePolicyMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteInsurancePolicy(Long id) {
        insurancePolicyRepository.deleteById(id);
    }

}