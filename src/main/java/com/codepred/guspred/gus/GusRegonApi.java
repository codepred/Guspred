package com.codepred.guspred.gus;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
class GusRegonApi {

    GusApiService gusApiService;
    GusDataParser gusDataParser;

    CompanyBasicData searchByNip(String nip) throws IOException {
        nip = nip.replaceAll("\\s+","");
        return fetchAndParseCompanyData(nip);
    }

    CompanyBasicData searchDetailByNip(String nip) throws IOException {
        nip = nip.replaceAll("\\s+","");
        var companyData = fetchAndParseCompanyData(nip);
        if(companyData.getDane().getTyp().equals("F")) {
            var pkdData = fetchAndParsePkdData(companyData.getDane().getRegon());
            var companyDetailData = fetchAndParseCompanyDetails(companyData.getDane().getRegon());
            companyData.getDane().setPkdObject(mapPkdData(pkdData));
            updateCompanyAddress(companyData.getDane(), companyDetailData.getDane());
            updateContactData(companyData.getDane(), companyDetailData.getDane());
            return companyData;
        }
        else if(companyData.getDane().getTyp().equals("P")){
            var pkdData = fetchAndParsePrawnaPkdData(companyData.getDane().getRegon());
            var companyDetailData = fetchAndParsePrawnaCompanyDetails(companyData.getDane().getRegon());
            companyData.getDane().setPkdObject(mapPkdData(pkdData));
            updateCompanyAddress(companyData.getDane(), companyDetailData.getDane());
            updateContactData(companyData.getDane(), companyDetailData.getDane());
            return companyData;
        }
        return null;
    }

    private CompanyBasicData fetchAndParseCompanyData(String nip) throws IOException {
        var companyDataJson = gusApiService.searchByNip(nip);
        if (companyDataJson == null || companyDataJson.trim().isEmpty()) {
            throw new GusApiException("Response from gusApiService::searchByNip is in wrong format: " + companyDataJson);
        }
        var companyJsonWrapper = gusDataParser.parseJson(companyDataJson, JsonWrapper.class);
        return gusDataParser.parseXml(companyJsonWrapper.d(), CompanyBasicData.class);
    }

    private CompanyPkdData fetchAndParsePrawnaPkdData(String regon) throws IOException {
        var pkdDataJson = gusApiService.fetchPrawnaPkdReport(regon);
        if (pkdDataJson == null || pkdDataJson.trim().isEmpty()) {
            throw new GusApiException("Response from gusApiService::fetchPrawnaPkdReport is in wrong format: " + pkdDataJson);
        }
        var pkdJsonWrapper = gusDataParser.parseJson(pkdDataJson, JsonWrapper.class);
        return gusDataParser.parseXml(pkdJsonWrapper.d(), CompanyPkdData.class);
    }

    private CompanyPkdData fetchAndParsePkdData(String regon) throws IOException {
        var pkdDataJson = gusApiService.fetchPkdReport(regon);
        if (pkdDataJson == null || pkdDataJson.trim().isEmpty()) {
            throw new GusApiException("Response from gusApiService::fetchAndParsePkdData is in wrong format: " + pkdDataJson);
        }
        var pkdJsonWrapper = gusDataParser.parseJson(pkdDataJson, JsonWrapper.class);
        return gusDataParser.parseXml(pkdJsonWrapper.d(), CompanyPkdData.class);
    }

    private CompanyPrawnaDetailData fetchAndParsePrawnaCompanyDetails(String regon) throws IOException {
        var companyDetailJson = gusApiService.fetchFullPrawnaReport(regon);
        if (companyDetailJson == null || companyDetailJson.trim().isEmpty()) {
            throw new GusApiException("Response from gusApiService::fetchAndParsePrawnaCompanyDetails is in wrong format: " + companyDetailJson);
        }
        var companyDetailWrapper = gusDataParser.parseJson(companyDetailJson, JsonWrapper.class);
        return gusDataParser.parseXml(companyDetailWrapper.d(), CompanyPrawnaDetailData.class);
    }

    private CompanyDetailData fetchAndParseCompanyDetails(String regon) throws IOException {
        var companyDetailJson = gusApiService.fetchFullReport(regon);
        if (companyDetailJson == null || companyDetailJson.trim().isEmpty()) {
            throw new GusApiException("Response from gusApiService::fetchAndParseCompanyDetails is in wrong format: " + companyDetailJson);
        }
        var companyDetailWrapper = gusDataParser.parseJson(companyDetailJson, JsonWrapper.class);
        return gusDataParser.parseXml(companyDetailWrapper.d(), CompanyDetailData.class);
    }

    private List<PkdObject> mapPkdData(CompanyPkdData pkdData) {
        return pkdData.getDane()
            .stream()
            .map(pkd -> new PkdObject(pkd.getPkdKod(), pkd.getPkdNazwa()))
            .collect(Collectors.toList());
    }

    private void updateContactData(Dane companyData, BIR11OsPrawna companyDetailData) {
        companyData.setEmail(companyDetailData.getAdresEmail());
        companyData.setNumerTelefonu(companyDetailData.getNumerTelefonu());
    }

    private void updateCompanyAddress(Dane companyData, BIR11OsPrawna companyDetailData) {
        companyData.setUlica(buildStreetAddress(companyDetailData));
    }

    private String buildStreetAddress(BIR11OsPrawna companyDetailData) {
        final var streetName = nonNullOrEmpty(companyDetailData.getUlicaNazwa());
        final var buildingNumber = nonNullOrEmpty(companyDetailData.getNumerNieruchomosci());
        final var apartmentNumber = nonNullOrEmpty(companyDetailData.getNumerLokalu());

        final var addressNumber = (apartmentNumber.isEmpty())
            ? buildingNumber
            : String.join("/", buildingNumber, apartmentNumber);

        return String.join(" ", streetName, addressNumber).trim();
    }

    private void updateContactData(Dane companyData, BIR11OsFizycznaDzialalnoscCeidg companyDetailData) {
        companyData.setEmail(companyDetailData.getFizAdresEmail());
        companyData.setNumerTelefonu(companyDetailData.getNumerTelefonu());
    }

    private void updateCompanyAddress(Dane companyData, BIR11OsFizycznaDzialalnoscCeidg companyDetailData) {
        companyData.setUlica(buildStreetAddress(companyDetailData));
    }

    private String buildStreetAddress(BIR11OsFizycznaDzialalnoscCeidg companyDetailData) {
        final var streetName = nonNullOrEmpty(companyDetailData.getFizAdSiedzUlicaNazwa());
        final var buildingNumber = nonNullOrEmpty(companyDetailData.getNumerNieruchomosci());
        final var apartmentNumber = nonNullOrEmpty(companyDetailData.getNumerLokalu());

        final var addressNumber = (apartmentNumber.isEmpty())
                ? buildingNumber
                : String.join("/", buildingNumber, apartmentNumber);

        return String.join(" ", streetName, addressNumber).trim();
    }

    private String nonNullOrEmpty(String value) {
        return value != null ? value : "";
    }

}
