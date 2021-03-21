package com.superchoice.registration.files.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.superchoice.registration.files.model.MemberRegistrationTransaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileProcessorImpl implements FileProcessor {

    @Value( "${file.save.path}" )
    String path;
    @Override
    public void saveResult(List<MemberRegistrationTransaction> list) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(Paths.get(path).toFile(), list);
    }
}
