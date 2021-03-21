package com.superchoice.registration.files.xml.helper;

import com.superchoice.registration.files.model.MemberRegistrationTransaction;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface XmlHelper {
    public List<MemberRegistrationTransaction> xmlToMemberRegistrationTransaction(InputStream is) throws IOException;
}
