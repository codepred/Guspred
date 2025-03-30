package com.codepred.guspred.gus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JacksonXmlRootElement(localName = "root")
class CompanyPkdData {

    @JacksonXmlProperty(localName = "dane")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PkdDane> dane;

}