package com.mulakat.insurance_policy_service.services.abstracts;

import com.mulakat.insurance_policy_service.dtos.request.CreateInsurancePolicy;
import com.mulakat.insurance_policy_service.dtos.response.InsurancePolicyResponse;

import java.util.List;

public interface InsurancePolicyService {
    InsurancePolicyResponse createInsurancePolicy(CreateInsurancePolicy request);
    List<InsurancePolicyResponse> getAllInsurancePolicies();
    void deleteInsurancePolicy(Long id);
}