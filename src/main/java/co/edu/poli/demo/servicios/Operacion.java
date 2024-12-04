package co.edu.poli.demo.servicios;

import co.edu.poli.demo.modelo.Estudiante;

public interface Operacion {

    public String create(Estudiante est);

    public Estudiante read(String cod);

    public Estudiante[] readall ();

    public String update(String cod, Estudiante est);

    public Estudiante delete(String cod);
    
}
