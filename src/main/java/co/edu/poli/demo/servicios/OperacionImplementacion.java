package co.edu.poli.demo.servicios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.poli.demo.modelo.Estudiante;

public class OperacionImplementacion implements Operacion {

    private Estudiante[] Estudiantes;

    public OperacionImplementacion() {
        Estudiantes = new Estudiante[1];
    }

    
    /** 
     * @param Estudiantes
     */
    public void setEstudiantes(Estudiante[] Estudiantes) {
        this.Estudiantes = Estudiantes;
    }

    
    /** 
     * @param e
     * @return String
     */
    @Override
    public String create(Estudiante e) {
        for (int i = 0; i < Estudiantes.length; i++) {
            if (Estudiantes[i] == null) {
                Estudiantes[i] = e;
                return "Save!";
            }
        }
        Estudiante[] Estudiantesaux = new Estudiante[Estudiantes.length * 2];
        System.arraycopy(Estudiantes, 0, Estudiantesaux, 0, Estudiantes.length);
        Estudiantesaux[Estudiantes.length] = e;
        Estudiantes = Estudiantesaux;
        return "Save!!";
    }

    
    /** 
     * @param cod
     * @return Estudiante
     */
    @Override
    public Estudiante read(String cod) {
        for (int i = 0; i < Estudiantes.length; i++) {
            if (!(Estudiantes[i] == null))
                if (Estudiantes[i].getCodigo().equals(cod))
                    return Estudiantes[i];
        }
        return null;
    }

    
    /** 
     * @return Estudiante[]
     */
    @Override
    public Estudiante[] readall() {
        return Estudiantes;
    }

    @Override
    public String update(String cod, Estudiante e) {
        for (int i = 0; i < Estudiantes.length; i++) {
            if (!(Estudiantes[i] == null))
                if (Estudiantes[i].getCodigo().equals(cod)) {
                    Estudiantes[i] = e;
                    return "Update!";
                }
        }
        return "Cod is not in the array!";
    }

    @Override
    public Estudiante delete(String cod) {
        Estudiante temp = null;
        for (int i = 0; i < Estudiantes.length; i++) {
            if (!(Estudiantes[i] == null))
                if (Estudiantes[i].getCodigo().equals(cod)) {
                    temp = Estudiantes[i];
                    Estudiantes[i] = null;
                    return temp;
                }
        }
        return temp;
    }

    @Override
    public String serializar(Estudiante[] estudiantes, String path, String name) {
        try {
            FileOutputStream fos = new FileOutputStream(path + name);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(estudiantes);
            oos.close();
            fos.close();
            return "File create!!";
        } catch (IOException ioe) {
            return "Error file " + ioe.getMessage();
        }
    }

    @Override
    public Estudiante[] deserializar(String path, String name) {
        Estudiante[] a = null;
        try {
            FileInputStream fis = new FileInputStream(path + name);
            ObjectInputStream ois = new ObjectInputStream(fis);

            a = (Estudiante[]) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch (ClassNotFoundException c) {
            System.err.println(c.getMessage());
        }
        return a;
    }

}
