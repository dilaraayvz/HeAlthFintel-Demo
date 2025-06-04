package com.mulakat.insurance_policy_service.dtos.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateInsurancePolicy {
    private String policyType;
    private Double coverageAmount;
    private Double premiumAmount;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
}
