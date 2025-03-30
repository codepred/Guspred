package com.codepred.guspred.gus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class PkdDane {

    @JacksonXmlProperty(localName = "praw_pkdKod")
    private String pkdKod;

    @JacksonXmlProperty(localName = "praw_pkdNazwa")
    private String pkdNazwa;

    @JacksonXmlProperty(localName = "praw_pkdPrzewazajace")
    private int pkdPrzewazajace;
}
