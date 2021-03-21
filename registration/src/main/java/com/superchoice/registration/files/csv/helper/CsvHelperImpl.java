package com.superchoice.registration.files.csv.helper;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.superchoice.registration.files.model.MemberRegistrationTransaction;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Component
public class CsvHelperImpl implements CsvHelper {

    @Override
    public List<MemberRegistrationTransaction> csvToMemberRegistrationTransaction(InputStream is) throws IOException {
        CsvSchema schema = CsvSchema
                .emptySchema()
                .withHeader();
        ObjectReader reader = new CsvMapper()
                .readerFor(MemberRegistrationTransaction.class)
                .with(schema);
        List<MemberRegistrationTransaction> results = null;
        MappingIterator<MemberRegistrationTransaction> iterator = reader.readValues(is);
        results = iterator.readAll();
        return results;
    }
}
