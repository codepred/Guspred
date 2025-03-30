package com.codepred.guspred.gus;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@FieldDefaults(makeFinal = true, level = PRIVATE)
class GusController {

    GusRegonApi gusClient;

    @GetMapping("/search")
    ResponseEntity<CompanyBasicData> searchByNip(@RequestParam String nip) throws IOException {
        return ResponseEntity.ok(gusClient.searchByNip(nip));
    }

    @GetMapping("/search/detail")
    ResponseEntity<CompanyBasicData> searchDetailByNip(@RequestParam String nip) throws IOException {
        return ResponseEntity.ok(gusClient.searchDetailByNip(nip));
    }

}
