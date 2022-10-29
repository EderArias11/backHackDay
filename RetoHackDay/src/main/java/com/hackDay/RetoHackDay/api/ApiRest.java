package com.hackDay.RetoHackDay.api;

import com.hackDay.RetoHackDay.usecase.KonectaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiRest {

    public final KonectaUseCase konectaUseCase;

    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getData() throws IOException {

        String data = konectaUseCase.getData();

        return data;
    }

}
