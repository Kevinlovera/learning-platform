package cl.duoc.inscripcion_sevice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class InscripcionDto {

     @NotBlank(message = "El estudiante es obligatorio")
    private String estudiante;

    @NotEmpty(message = "Debe seleccionar al menos un curso")
    private List<Long> cursos;

}
