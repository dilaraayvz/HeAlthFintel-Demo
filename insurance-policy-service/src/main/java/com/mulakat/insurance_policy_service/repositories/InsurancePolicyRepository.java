package com.mulakat.insurance_policy_service.repositories;

import com.mulakat.insurance_policy_service.entities.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {
    InsurancePolicy findByPolicyType(String policyType);
}