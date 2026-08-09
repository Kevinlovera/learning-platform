package cl.duoc.curso_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CursoDTO {


    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;


    @NotBlank(message = "El instructor es obligatorio")
    private String instructor;

     @NotBlank(message = "La duración es obligatoria")
    private String duracion;

    @Positive(message = "El costo debe ser mayor que 0")
    private Double costo;

   

    public CursoDTO(Long id, String nombre, String instructor, String duracion, Double costo) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.duracion = duracion;
        this.costo = costo;
    }
}
