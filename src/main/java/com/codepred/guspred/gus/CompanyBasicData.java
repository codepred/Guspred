package com.codepred.guspred.gus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@JacksonXmlRootElement(localName = "root")
@Getter
@Setter
class CompanyBasicData {

    @JacksonXmlProperty(localName = "dane")
    private Dane dane;

}