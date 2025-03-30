package com.codepred.guspred.gus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class BIR11OsFizycznaDzialalnoscCeidg {

    @JacksonXmlProperty(localName = "fiz_regon9")
    private String regon;

    @JacksonXmlProperty(localName = "fiz_nazwa")
    private String nazwa;

    @JacksonXmlProperty(localName = "fiz_nazwaSkrocona")
    private String nazwaSkrocona;

    @JacksonXmlProperty(localName = "fiz_dataPowstania")
    private String dataPowstania;

    @JacksonXmlProperty(localName = "fiz_dataRozpoczeciaDzialalnosci")
    private String dataRozpoczeciaDzialalnosci;

    @JacksonXmlProperty(localName = "fiz_dataWpisuDzialalnosciDoRegon")
    private String dataWpisuDzialalnosciDoRegon;

    @JacksonXmlProperty(localName = "fiz_dataZawieszeniaDzialalnosci")
    private String dataZawieszeniaDzialalnosci;

    @JacksonXmlProperty(localName = "fiz_dataWznowieniaDzialalnosci")
    private String dataWznowieniaDzialalnosci;

    @JacksonXmlProperty(localName = "fiz_dataZaistnieniaZmianyDzialalnosci")
    private String dataZaistnieniaZmianyDzialalnosci;

    @JacksonXmlProperty(localName = "fiz_dataZakonczeniaDzialalnosci")
    private String dataZakonczeniaDzialalnosci;

    @JacksonXmlProperty(localName = "fiz_dataSkresleniaDzialalnosciZRegon")
    private String dataSkresleniaDzialalnosciZRegon;

    @JacksonXmlProperty(localName = "fiz_dataOrzeczeniaOUpadlosci")
    private String dataOrzeczeniaOUpadlosci;

    @JacksonXmlProperty(localName = "fiz_dataZakonczeniaPostepowaniaUpadlosciowego")
    private String dataZakonczeniaPostepowaniaUpadlosciowego;

    @JacksonXmlProperty(localName = "fiz_adSiedzKraj_Symbol")
    private String krajSymbol;

    @JacksonXmlProperty(localName = "fiz_adSiedzWojewodztwo_Symbol")
    private String wojewodztwoSymbol;

    @JacksonXmlProperty(localName = "fiz_adSiedzPowiat_Symbol")
    private String powiatSymbol;

    @JacksonXmlProperty(localName = "fiz_adSiedzGmina_Symbol")
    private String gminaSymbol;

    @JacksonXmlProperty(localName = "fiz_adSiedzKodPocztowy")
    private String kodPocztowy;

    @JacksonXmlProperty(localName = "fiz_adSiedzMiejscowoscPoczty_Symbol")
    private String miejscowoscPocztySymbol;

    @JacksonXmlProperty(localName = "fiz_adSiedzMiejscowosc_Symbol")
    private String miejscowoscSymbol;

    @JacksonXmlProperty(localName = "fiz_adSiedzUlica_Symbol")
    private String ulicaSymbol;

    @JacksonXmlProperty(localName = "fiz_adSiedzNumerNieruchomosci")
    private String numerNieruchomosci;

    @JacksonXmlProperty(localName = "fiz_adSiedzNumerLokalu")
    private String numerLokalu;

    @JacksonXmlProperty(localName = "fiz_adSiedzNietypoweMiejsceLokalizacji")
    private String nietypoweMiejsceLokalizacji;

    @JacksonXmlProperty(localName = "fiz_numerTelefonu")
    private String numerTelefonu;

    @JacksonXmlProperty(localName = "fiz_numerWewnetrznyTelefonu")
    private String numerWewnetrznyTelefonu;

    @JacksonXmlProperty(localName = "fiz_numerFaksu")
    private String fizNumerFaksu;

    @JacksonXmlProperty(localName = "fiz_adresEmail")
    private String fizAdresEmail;

    @JacksonXmlProperty(localName = "fiz_adresStronyinternetowej")
    private String fizAdresStronyInternetowej;

    @JacksonXmlProperty(localName = "fiz_adSiedzKraj_Nazwa")
    private String fizAdSiedzKrajNazwa;

    @JacksonXmlProperty(localName = "fiz_adSiedzWojewodztwo_Nazwa")
    private String fizAdSiedzWojewodztwoNazwa;

    @JacksonXmlProperty(localName = "fiz_adSiedzPowiat_Nazwa")
    private String fizAdSiedzPowiatNazwa;

    @JacksonXmlProperty(localName = "fiz_adSiedzGmina_Nazwa")
    private String fizAdSiedzGminaNazwa;

    @JacksonXmlProperty(localName = "fiz_adSiedzMiejscowosc_Nazwa")
    private String fizAdSiedzMiejscowoscNazwa;

    @JacksonXmlProperty(localName = "fiz_adSiedzMiejscowoscPoczty_Nazwa")
    private String fizAdSiedzMiejscowoscPocztyNazwa;

    @JacksonXmlProperty(localName = "fiz_adSiedzUlica_Nazwa")
    private String fizAdSiedzUlicaNazwa;

    @JacksonXmlProperty(localName = "fizC_dataWpisuDoRejestruEwidencji")
    private String fizCDataWpisuDoRejestruEwidencji;

    @JacksonXmlProperty(localName = "fizC_dataSkresleniaZRejestruEwidencji")
    private String fizCDataSkresleniaZRejestruEwidencji;

    @JacksonXmlProperty(localName = "fizC_numerWRejestrzeEwidencji")
    private String fizCNumerWRejestrzeEwidencji;

    @JacksonXmlProperty(localName = "fizC_OrganRejestrowy_Symbol")
    private String fizCOrganRejestrowySymbol;

    @JacksonXmlProperty(localName = "fizC_OrganRejestrowy_Nazwa")
    private String fizCOrganRejestrowyNazwa;

    @JacksonXmlProperty(localName = "fizC_RodzajRejestru_Symbol")
    private String fizCRodzajRejestruSymbol;

    @JacksonXmlProperty(localName = "fizC_RodzajRejestru_Nazwa")
    private String fizCRodzajRejestruNazwa;

    @JacksonXmlProperty(localName = "fizC_NiePodjetoDzialalnosci")
    private String fizCNiePodjetoDzialalnosci;
}
