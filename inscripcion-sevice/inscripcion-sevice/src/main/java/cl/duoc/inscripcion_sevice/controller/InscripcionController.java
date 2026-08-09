package cl.duoc.inscripcion_sevice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.inscripcion_sevice.dto.InscripcionDto;
import cl.duoc.inscripcion_sevice.dto.InscripcionResponseDto;
import cl.duoc.inscripcion_sevice.service.InscripcionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final InscripcionService service;

    public InscripcionController(InscripcionService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InscripcionResponseDto crearInscripcion(
            @Valid @RequestBody InscripcionDto dto) {

        return service.crearInscripcion(dto);
    }
}