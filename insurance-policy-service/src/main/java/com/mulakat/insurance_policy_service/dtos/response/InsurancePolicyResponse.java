package com.mulakat.insurance_policy_service.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InsurancePolicyResponse {
    private String policyType;
    private Double coverageAmount;
    private Double premiumAmount;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
}
