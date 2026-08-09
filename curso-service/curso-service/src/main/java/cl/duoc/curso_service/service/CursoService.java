package cl.duoc.curso_service.service;

import cl.duoc.curso_service.dto.CursoDTO;
import cl.duoc.curso_service.entity.Curso;
import cl.duoc.curso_service.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<CursoDTO> listarCursos() {

        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    private CursoDTO convertirDTO(Curso curso) {

        return new CursoDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getInstructor(),
                curso.getDuracion(),
                curso.getCosto()
        );
    }
   
    public CursoDTO guardarCurso(CursoDTO dto) {

    Curso curso = new Curso();

    curso.setNombre(dto.getNombre());
    curso.setInstructor(dto.getInstructor());
    curso.setDuracion(dto.getDuracion());
    curso.setCosto(dto.getCosto());

    Curso cursoGuardado = repository.save(curso);

    return convertirDTO(cursoGuardado);
}

public CursoDTO obtenerCursoPorId(Long id) {

    Curso curso = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

    return convertirDTO(curso);
}

public CursoDTO actualizarCurso(Long id, CursoDTO dto) {

    Curso curso = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

    curso.setNombre(dto.getNombre());
    curso.setInstructor(dto.getInstructor());
    curso.setDuracion(dto.getDuracion());
    curso.setCosto(dto.getCosto());

    Curso actualizado = repository.save(curso);

    return convertirDTO(actualizado);
}

public void eliminarCurso(Long id) {

    if (!repository.existsById(id)) {
        throw new RuntimeException("Curso no encontrado");
    }

    repository.deleteById(id);
}
}



 /* 
    Sin DTO

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<Curso> listarCursos() {
        return repository.findAll();
    }*/
