package com.superchoice.registration.files.service;

import com.superchoice.registration.files.csv.helper.CsvHelper;
import com.superchoice.registration.files.model.MemberRegistrationTransaction;
import com.superchoice.registration.files.xml.helper.XmlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    @Autowired
    CsvHelper csvHelper;
    @Autowired
    XmlHelper xmlHelper;

    @Autowired
    FileProcessor fileProcessor;

    public void mergeAndSave(MultipartFile csvfile, MultipartFile xmlfile) {
        try {

            List<MemberRegistrationTransaction> csvMemberRegistrationTransactions = csvHelper.csvToMemberRegistrationTransaction(csvfile.getInputStream());
            List<MemberRegistrationTransaction> xmlMemberRegistrationTransactions = xmlHelper.xmlToMemberRegistrationTransaction(xmlfile.getInputStream());
            csvMemberRegistrationTransactions.addAll(xmlMemberRegistrationTransactions);
            fileProcessor.saveResult(csvMemberRegistrationTransactions);
        } catch (IOException e) {
            throw new RuntimeException("failed to merge csv and xml data: " + e.getMessage());
        }
    }
}
