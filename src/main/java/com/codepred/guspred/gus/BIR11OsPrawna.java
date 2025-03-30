package com.codepred.guspred.gus;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class BIR11OsPrawna {

    @JacksonXmlProperty(localName = "praw_regon9")
    private String regon;

    @JacksonXmlProperty(localName = "praw_nip")
    private String nip;

    @JacksonXmlProperty(localName = "praw_statusNip")
    private String statusNip;

    @JacksonXmlProperty(localName = "praw_nazwa")
    private String nazwa;

    @JacksonXmlProperty(localName = "praw_nazwaSkrocona")
    private String nazwaSkrocona;

    @JacksonXmlProperty(localName = "praw_numerWRejestrzeEwidencji")
    private String numerWRejestrzeEwidencji;

    @JacksonXmlProperty(localName = "praw_dataWpisuDoRejestruEwidencji")
    private String dataWpisuDoRejestruEwidencji;

    @JacksonXmlProperty(localName = "praw_dataPowstania")
    private String dataPowstania;

    @JacksonXmlProperty(localName = "praw_dataRozpoczeciaDzialalnosci")
    private String dataRozpoczeciaDzialalnosci;

    @JacksonXmlProperty(localName = "praw_dataWpisuDoRegon")
    private String dataWpisuDoRegon;

    @JacksonXmlProperty(localName = "praw_dataZawieszeniaDzialalnosci")
    private String dataZawieszeniaDzialalnosci;

    @JacksonXmlProperty(localName = "praw_dataWznowieniaDzialalnosci")
    private String dataWznowieniaDzialalnosci;

    @JacksonXmlProperty(localName = "praw_dataZaistnieniaZmiany")
    private String dataZaistnieniaZmiany;

    @JacksonXmlProperty(localName = "praw_dataZakonczeniaDzialalnosci")
    private String dataZakonczeniaDzialalnosci;

    @JacksonXmlProperty(localName = "praw_dataSkresleniaZRegon")
    private String dataSkresleniaZRegon;

    @JacksonXmlProperty(localName = "praw_dataOrzeczeniaOUpadlosci")
    private String dataOrzeczeniaOUpadlosci;

    @JacksonXmlProperty(localName = "praw_dataZakonczeniaPostepowaniaUpadlosciowego")
    private String dataZakonczeniaPostepowaniaUpadlosciowego;

    @JacksonXmlProperty(localName = "praw_adSiedzKraj_Symbol")
    private String krajSymbol;

    @JacksonXmlProperty(localName = "praw_adSiedzWojewodztwo_Symbol")
    private String wojewodztwoSymbol;

    @JacksonXmlProperty(localName = "praw_adSiedzPowiat_Symbol")
    private String powiatSymbol;

    @JacksonXmlProperty(localName = "praw_adSiedzGmina_Symbol")
    private String gminaSymbol;

    @JacksonXmlProperty(localName = "praw_adSiedzKodPocztowy")
    private String kodPocztowy;

    @JacksonXmlProperty(localName = "praw_adSiedzMiejscowoscPoczty_Symbol")
    private String miejscowoscPocztySymbol;

    @JacksonXmlProperty(localName = "praw_adSiedzMiejscowosc_Symbol")
    private String miejscowoscSymbol;

    @JacksonXmlProperty(localName = "praw_adSiedzUlica_Symbol")
    private String ulicaSymbol;

    @JacksonXmlProperty(localName = "praw_adSiedzNumerNieruchomosci")
    private String numerNieruchomosci;

    @JacksonXmlProperty(localName = "praw_adSiedzNumerLokalu")
    private String numerLokalu;

    @JacksonXmlProperty(localName = "praw_adSiedzNietypoweMiejsceLokalizacji")
    private String nietypoweMiejsceLokalizacji;

    @JacksonXmlProperty(localName = "praw_numerTelefonu")
    private String numerTelefonu;

    @JacksonXmlProperty(localName = "praw_numerWewnetrznyTelefonu")
    private String numerWewnetrznyTelefonu;

    @JacksonXmlProperty(localName = "praw_numerFaksu")
    private String numerFaksu;

    @JacksonXmlProperty(localName = "praw_adresEmail")
    private String adresEmail;

    @JacksonXmlProperty(localName = "praw_adresStronyinternetowej")
    private String adresStronyInternetowej;

    @JacksonXmlProperty(localName = "praw_adSiedzKraj_Nazwa")
    private String krajNazwa;

    @JacksonXmlProperty(localName = "praw_adSiedzWojewodztwo_Nazwa")
    private String wojewodztwoNazwa;

    @JacksonXmlProperty(localName = "praw_adSiedzPowiat_Nazwa")
    private String powiatNazwa;

    @JacksonXmlProperty(localName = "praw_adSiedzGmina_Nazwa")
    private String gminaNazwa;

    @JacksonXmlProperty(localName = "praw_adSiedzMiejscowosc_Nazwa")
    private String miejscowoscNazwa;

    @JacksonXmlProperty(localName = "praw_adSiedzMiejscowoscPoczty_Nazwa")
    private String miejscowoscPocztyNazwa;

    @JacksonXmlProperty(localName = "praw_adSiedzUlica_Nazwa")
    private String ulicaNazwa;

    @JacksonXmlProperty(localName = "praw_podstawowaFormaPrawna_Symbol")
    private String podstawowaFormaPrawnaSymbol;

    @JacksonXmlProperty(localName = "praw_szczegolnaFormaPrawna_Symbol")
    private String szczegolnaFormaPrawnaSymbol;

    @JacksonXmlProperty(localName = "praw_formaFinansowania_Symbol")
    private String formaFinansowaniaSymbol;

    @JacksonXmlProperty(localName = "praw_formaWlasnosci_Symbol")
    private String formaWlasnosciSymbol;

    @JacksonXmlProperty(localName = "praw_organZalozycielski_Symbol")
    private String organZalozycielskiSymbol;

    @JacksonXmlProperty(localName = "praw_organRejestrowy_Symbol")
    private String organRejestrowySymbol;

    @JacksonXmlProperty(localName = "praw_rodzajRejestruEwidencji_Symbol")
    private String rodzajRejestruEwidencjiSymbol;

    @JacksonXmlProperty(localName = "praw_podstawowaFormaPrawna_Nazwa")
    private String podstawowaFormaPrawnaNazwa;

    @JacksonXmlProperty(localName = "praw_szczegolnaFormaPrawna_Nazwa")
    private String szczegolnaFormaPrawnaNazwa;

    @JacksonXmlProperty(localName = "praw_formaFinansowania_Nazwa")
    private String formaFinansowaniaNazwa;

    @JacksonXmlProperty(localName = "praw_formaWlasnosci_Nazwa")
    private String formaWlasnosciNazwa;

    @JacksonXmlProperty(localName = "praw_organZalozycielski_Nazwa")
    private String organZalozycielskiNazwa;

    @JacksonXmlProperty(localName = "praw_organRejestrowy_Nazwa")
    private String organRejestrowyNazwa;

    @JacksonXmlProperty(localName = "praw_rodzajRejestruEwidencji_Nazwa")
    private String rodzajRejestruEwidencjiNazwa;

    @JacksonXmlProperty(localName = "praw_liczbaJednLokalnych")
    private Integer liczbaJednLokalnych;

}