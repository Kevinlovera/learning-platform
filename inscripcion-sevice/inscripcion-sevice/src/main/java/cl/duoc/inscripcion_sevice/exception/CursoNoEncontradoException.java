package cl.duoc.inscripcion_sevice.exception;

public class CursoNoEncontradoException extends RuntimeException {

    public CursoNoEncontradoException(Long id) {
        super("No existe un curso con el ID: " + id);
    }
}