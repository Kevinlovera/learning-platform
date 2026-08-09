

    /* 
    private final RestClient restClient;

    public  CursoClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public CursoResponseDto obtenerCurso(Long id)
 {
    return restClient.get().uri("http://localhost:8081/api/cursos/{id}", id).
    retrieve().
    body(CursoResponseDto.class);
 } */

    package cl.duoc.inscripcion_sevice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import cl.duoc.inscripcion_sevice.dto.CursoResponseDto;
import cl.duoc.inscripcion_sevice.exception.CursoNoEncontradoException;

@Component
public class CursoClient {

    private final RestClient restClient;
    private final String cursoServiceUrl;

    public CursoClient(
            RestClient restClient,
            @Value("${curso-service.url}") String cursoServiceUrl) {

        this.restClient = restClient;
        this.cursoServiceUrl = cursoServiceUrl;
    }

    public CursoResponseDto obtenerCurso(Long id) {

        return restClient
                .get()
                .uri(cursoServiceUrl + "/api/cursos/{id}", id)
                .retrieve()
                .onStatus(
                        status -> status.value() == 404,
                        (request, response) -> {
                            throw new CursoNoEncontradoException(id);
                        }
                )
                .body(CursoResponseDto.class);
    }
}