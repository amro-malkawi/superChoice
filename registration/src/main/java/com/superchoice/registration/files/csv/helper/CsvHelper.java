package com.superchoice.registration.files.csv.helper;

import com.superchoice.registration.files.model.MemberRegistrationTransaction;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface CsvHelper {
    public  List<MemberRegistrationTransaction> csvToMemberRegistrationTransaction(InputStream is) throws IOException;
}
