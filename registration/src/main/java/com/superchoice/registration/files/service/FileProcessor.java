package com.superchoice.registration.files.service;

import com.superchoice.registration.files.model.MemberRegistrationTransaction;

import java.io.IOException;
import java.util.List;

public interface FileProcessor {
    public void saveResult(List<MemberRegistrationTransaction> list) throws IOException;
}
