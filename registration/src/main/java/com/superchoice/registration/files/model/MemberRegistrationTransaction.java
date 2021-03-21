package com.superchoice.registration.files.model;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class MemberRegistrationTransaction {


    private String transactionIdentifier;
    private String employerName;
    private String employerABN;
    private String fundIdentifier;
    private String fundEmployerIdentifier;
    private String memberFirstName;
    private String memberLastName;
    private String memberOtherNames;
    private String memberDateOfBirth;
    private String memberGender;
    private String memberAddress;
    private String memberEmail;
    private String memberContactNumber;
    private String memberNumber;
    private String memberTFN;
    private String memberPayrollNumber;
    private String memberEmploymentStatus;
    private String memberFundRegistrationDate;



}
