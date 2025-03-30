package com.codepred.guspred.gus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
class Dane {

    @JacksonXmlProperty(localName = "Regon")
    private String regon;

    @JacksonXmlProperty(localName = "RegonLink")
    private String regonLink;

    @JacksonXmlProperty(localName = "Nazwa")
    private String nazwa;

    @JacksonXmlProperty(localName = "Wojewodztwo")
    private String wojewodztwo;

    @JacksonXmlProperty(localName = "Powiat")
    private String powiat;

    @JacksonXmlProperty(localName = "Gmina")
    private String gmina;

    @JacksonXmlProperty(localName = "Miejscowosc")
    private String miejscowosc;

    @JacksonXmlProperty(localName = "KodPocztowy")
    private String kodPocztowy;

    @JacksonXmlProperty(localName = "Ulica")
    private String ulica;

    @JacksonXmlProperty(localName = "Typ")
    private String typ;

    @JacksonXmlProperty(localName = "SilosID")
    private String silosID;

    @JacksonXmlProperty(localName = "NumerTelefonu")
    private String numerTelefonu;

    @JacksonXmlProperty(localName = "Email")
    private String email;

    @JacksonXmlProperty(localName = "pkdObjects")
    private List<PkdObject> pkdObject;

    public String getRegon() {
        return regon.substring(0, 9);
    }
}