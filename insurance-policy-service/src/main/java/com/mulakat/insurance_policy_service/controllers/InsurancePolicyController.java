package com.mulakat.insurance_policy_service.controllers;

import com.mulakat.insurance_policy_service.dtos.request.CreateInsurancePolicy;
import com.mulakat.insurance_policy_service.dtos.response.InsurancePolicyResponse;
import com.mulakat.insurance_policy_service.services.abstracts.InsurancePolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurance-policy")
@RequiredArgsConstructor
public class InsurancePolicyController {

    private final InsurancePolicyService insurancePolicyService;

    @GetMapping
    public List<InsurancePolicyResponse> getAllInsurancePolicies(){
        return insurancePolicyService.getAllInsurancePolicies();
    }

    @PostMapping
    public InsurancePolicyResponse createInsurancePolicyService(@RequestBody CreateInsurancePolicy request){
        return insurancePolicyService.createInsurancePolicy(request);
    }



}
