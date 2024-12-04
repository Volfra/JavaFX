package co.edu.poli.demo.servicios;

import co.edu.poli.demo.modelo.Estudiante;

public interface OperacionArchivo {
    
    public String serializar(Estudiante[] estudiantes, String path, String name);

    public Estudiante[] deserializar(String path, String name);

}
