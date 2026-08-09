package cl.duoc.inscripcion_sevice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CursoResponseDto {

    private Long id;
    private String nombre;
    private String duracion;
    private Double costo;
    private String instructor;

}
