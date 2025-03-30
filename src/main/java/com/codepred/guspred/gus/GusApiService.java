package com.codepred.guspred.gus;

import java.io.IOException;

interface GusApiService {

    void login() throws IOException;

    String searchByNip(String nip) throws IOException;

    String fetchFullReport(String regon) throws IOException;

    String fetchPkdReport(String regon) throws IOException;

    String fetchFullPrawnaReport(String regon) throws IOException;

    String fetchPrawnaPkdReport(String regon) throws IOException;
}
