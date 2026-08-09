package cl.duoc.inscripcion_sevice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.duoc.inscripcion_sevice.dto.CursoResponseDto;
import cl.duoc.inscripcion_sevice.dto.InscripcionDto;
import cl.duoc.inscripcion_sevice.dto.InscripcionResponseDto;
import cl.duoc.inscripcion_sevice.entity.Inscripcion;
import cl.duoc.inscripcion_sevice.entity.InscripcionCurso;
import cl.duoc.inscripcion_sevice.repository.InscripcionCursoRepository;
import cl.duoc.inscripcion_sevice.repository.InscripcionRepository;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final InscripcionCursoRepository inscripcionCursoRepository;
    private final CursoClient cursoClient;

    public InscripcionService(
            InscripcionRepository inscripcionRepository,
            InscripcionCursoRepository inscripcionCursoRepository,
            CursoClient cursoClient) {

        this.inscripcionRepository = inscripcionRepository;
        this.inscripcionCursoRepository = inscripcionCursoRepository;
        this.cursoClient = cursoClient;
    }

    @Transactional
    public InscripcionResponseDto crearInscripcion(InscripcionDto dto) {

        List<CursoResponseDto> cursos = new ArrayList<>();
        double total = 0.0;

        for (Long cursoId : dto.getCursos()) {

            CursoResponseDto curso = cursoClient.obtenerCurso(cursoId);

            cursos.add(curso);

            total += curso.getCosto();
        }

        Inscripcion inscripcion = new Inscripcion();

        inscripcion.setEstudiante(dto.getEstudiante());
        inscripcion.setFechaInscripcion(LocalDate.now());
        inscripcion.setTotal(total);

        Inscripcion inscripcionGuardada =
                inscripcionRepository.save(inscripcion);

        for (Long cursoId : dto.getCursos()) {

            InscripcionCurso inscripcionCurso = new InscripcionCurso();

            inscripcionCurso.setInscripcion(inscripcionGuardada);
            inscripcionCurso.setCursoId(cursoId);

            inscripcionCursoRepository.save(inscripcionCurso);
        }

        return new InscripcionResponseDto(
                inscripcionGuardada.getId(),
                inscripcionGuardada.getEstudiante(),
                inscripcionGuardada.getFechaInscripcion(),
                cursos,
                inscripcionGuardada.getTotal()
        );
    }}
