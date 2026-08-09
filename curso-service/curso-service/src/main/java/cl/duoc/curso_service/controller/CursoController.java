package cl.duoc.curso_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.curso_service.dto.CursoDTO;
import cl.duoc.curso_service.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Cursos", description = "Operaciones relacionadas con los cursos")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @Operation(summary = "Obtener todos los cursos")
   @GetMapping
    public List<CursoDTO> listarCursos() {
        return service.listarCursos();
    }

   /*  @GetMapping
    public List<Curso> listarCursos() {
        return service.listarCursos();
    }*/

        @Operation(summary = "Crear un nuevo curso")
        @PostMapping
        public CursoDTO guardarCurso(@Valid @RequestBody CursoDTO cursoDTO) {
            //TODO: process POST request
            
            return service.guardarCurso(cursoDTO);
        }

        @GetMapping("/{id}")
public CursoDTO obtenerCurso(@PathVariable Long id) {
    return service.obtenerCursoPorId(id);
}

@Operation(summary = "Actualizar un curso")
@PutMapping("/{id}")
public CursoDTO actualizarCurso(
        @PathVariable Long id,
        @Valid @RequestBody CursoDTO cursoDTO) {

    return service.actualizarCurso(id, cursoDTO);
}

@Operation(summary = "Eliminar un curso")
@DeleteMapping("/{id}")
public void eliminarCurso(@PathVariable Long id) {
    service.eliminarCurso(id);
}


}
        
