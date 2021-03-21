package com.superchoice.registration.files.xml.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.superchoice.registration.files.model.MemberRegistrationTransaction;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Component
public class XmlHelperImpl implements XmlHelper {
    @Override
    public List<MemberRegistrationTransaction> xmlToMemberRegistrationTransaction(InputStream is) throws IOException {
        List<MemberRegistrationTransaction> entries=null;
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        entries = xmlMapper.readValue(is, new TypeReference<List<MemberRegistrationTransaction>>() {});
        return entries;
    }
}
