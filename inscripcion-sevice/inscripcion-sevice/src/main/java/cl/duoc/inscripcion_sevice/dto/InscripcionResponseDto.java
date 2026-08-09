package cl.duoc.inscripcion_sevice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionResponseDto {

    private Long id;
    private String estudiante;
    private LocalDate fechaInscripcion;
    private List<CursoResponseDto> cursos;
    private Double total;
}