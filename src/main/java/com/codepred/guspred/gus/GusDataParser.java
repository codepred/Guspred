package com.codepred.guspred.gus;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Service
@FieldDefaults(makeFinal = true, level = PRIVATE)
class GusDataParser {

    ObjectMapper objectMapper = new ObjectMapper();
    XmlMapper xmlMapper = new XmlMapper();

    <T> T parseJson(String json, Class<T> clazz) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(json, clazz);
    }

    <T> T parseXml(String xml, Class<T> clazz) throws IOException {
        log.info("Parsing data from gus");
        log.info(xml);

        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return xmlMapper.readValue(xml, clazz);
    }
}
