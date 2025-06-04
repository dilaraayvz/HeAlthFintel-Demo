package com.mulakat.insurance_policy_service.mappers;

import com.mulakat.insurance_policy_service.dtos.request.CreateInsurancePolicy;
import com.mulakat.insurance_policy_service.dtos.response.InsurancePolicyResponse;
import com.mulakat.insurance_policy_service.entities.InsurancePolicy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsurancePolicyMapper {

    InsurancePolicy toEntity(CreateInsurancePolicy createInsurancePolicyRequest);
    InsurancePolicyResponse toResponse(InsurancePolicy insurancePolicy);

}
