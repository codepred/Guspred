package com.codepred.guspred.gus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName = "root")
@Getter
@Setter
class CompanyPrawnaDetailData {

    @JacksonXmlProperty(localName = "dane")
    private BIR11OsPrawna dane;

}