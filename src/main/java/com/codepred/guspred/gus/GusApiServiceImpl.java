package com.codepred.guspred.gus;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
class GusApiServiceImpl implements GusApiService {

    private static final String LOGIN_URL = "https://wyszukiwarkaregon.stat.gov.pl/wsBIR/UslugaBIRzewnPubl.svc/ajaxEndpoint/Zaloguj";
    private static final String SEARCH_DATA_URL = "https://wyszukiwarkaregon.stat.gov.pl/wsBIR/UslugaBIRzewnPubl.svc/ajaxEndpoint/daneSzukaj";
    private static final String FULL_REPORT_URL = "https://wyszukiwarkaregon.stat.gov.pl/wsBIR/UslugaBIRzewnPubl.svc/ajaxEndpoint/danePobierzPelnyRaport";
    private static final long SESSION_TIMEOUT = 3000000;

    @Value("${gus_key}")
    private String apiKey;

    private String session = null;
    private long lastActivityTime = 0;

    @Override
    public String searchByNip(String nip) throws IOException {
        log.info("Executed function searchByNip");
        checkAndRenewSession();
        final var payload = String.format("{\"pParametryWyszukiwania\":{\"Nip\":\"%s\"}}", nip);
        return makeRequest(payload, SEARCH_DATA_URL);
    }

    @Override
    public String fetchFullReport(String regon) throws IOException {
        log.info("Executed function fetchFullReport");
        checkAndRenewSession();
        final var payload = String.format("{\"pRegon\":\"%s\", \"pNazwaRaportu\":\"BIR11OsFizycznaDzialalnoscCeidg\"}", regon);
        return makeRequest(payload, FULL_REPORT_URL);
    }

    @Override
    public String fetchPkdReport(String regon) throws IOException {
        log.info("Executed function fetchPkdReport");
        checkAndRenewSession();
        final var payload = String.format("{\"pRegon\":\"%s\", \"pNazwaRaportu\":\"BIR11OsPrawnaPkd\"}", regon);
        return makeRequest(payload, FULL_REPORT_URL);
    }

    @Override
    public String fetchFullPrawnaReport(String regon) throws IOException {
        log.info("Executed function fetchFullPrawnaReport");
        checkAndRenewSession();
        final var payload = String.format("{\"pRegon\":\"%s\", \"pNazwaRaportu\":\"BIR11OsPrawna\"}", regon);
        return makeRequest(payload, FULL_REPORT_URL);
    }

    @Override
    public String fetchPrawnaPkdReport(String regon) throws IOException {
        log.info("Executed function fetchPrawnaPkdReport");
        checkAndRenewSession();
        final var payload = String.format("{\"pRegon\":\"%s\", \"pNazwaRaportu\":\"BIR11OsPrawnaPkd\"}", regon);
        return makeRequest(payload, FULL_REPORT_URL);
    }

    private void checkAndRenewSession() throws IOException {
        log.info("SESSION ID is: {}", session);
        long currentTime = System.currentTimeMillis();
        if (session == null || (currentTime - lastActivityTime) > SESSION_TIMEOUT) {
            login();
            lastActivityTime = currentTime;
        }
    }

    @Override
    public void login() throws IOException {
        final var payload = String.format("{\"pKluczUzytkownika\":\"%s\"}", apiKey);
        session = makeRequest(payload, LOGIN_URL);
        lastActivityTime = System.currentTimeMillis();
        log.info("Logged in successfully. Session ID: {}", session);
    }

    private String makeRequest(String payload, String url) throws IOException {
        final var connection = getHttpURLConnection(payload, url);

        try (var os = connection.getOutputStream()) {
            os.write(payload.getBytes(StandardCharsets.UTF_8));
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            final var response = readResponse(connection);
            long currentTime = System.currentTimeMillis();
            if (session == null || (currentTime - lastActivityTime) > SESSION_TIMEOUT) {
                return new ObjectMapper().readTree(response).get("d").asText();
            } else {
                return response.replace("\\u000d\\u000a", "");
            }
        } else {
            log.error("HTTP error code: {}", responseCode);
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    private HttpURLConnection getHttpURLConnection(String payload, String url) throws IOException {
        final var apiUrl = new URL(url);
        final var connection = (HttpURLConnection) apiUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Content-Length", String.valueOf(payload.getBytes(StandardCharsets.UTF_8).length));
        if (session != null) {
            connection.setRequestProperty("sid", session);
        }
        log.info("Using session: {}", session);
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(10000);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        return connection;
    }

    private String readResponse(HttpURLConnection connection) throws IOException {
        try (final var br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            final var response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }
}