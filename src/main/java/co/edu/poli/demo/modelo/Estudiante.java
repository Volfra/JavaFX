package co.edu.poli.demo.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author wsoto
 */
public class Estudiante implements Serializable {

    private String codigo;

    private String nombres;
    
    private String sexo;

    private String fecNac;

    private String programa;
    
    private List<String> habilidades;

    public Estudiante(String codigo, String nombres, String sexo, String fecNac, String programa,
            List<String> habilidades) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.sexo = sexo;
        this.fecNac = fecNac;
        this.programa = programa;
        this.habilidades = habilidades;
    }
    

    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getNombres() {
        return nombres;
    }


    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public String getSexo() {
        return sexo;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getFecNac() {
        return fecNac;
    }


    public void setFecNac(String fecNac) {
        this.fecNac = fecNac;
    }


    public String getPrograma() {
        return programa;
    }


    public void setPrograma(String programa) {
        this.programa = programa;
    }


    public List<String> getHabilidades() {
        return habilidades;
    }


    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    
    @Override
    public String toString() {
        return "Estudiante [codigo=" + codigo + ", nombres=" + nombres + ", sexo=" + sexo + ", fecNac=" + fecNac
                + ", programa=" + programa + ", habilidades=" + habilidades + "]";
    }


    public int calcularEdad () {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(fecNac, formatter);
            int year = date.getYear();            
            return LocalDateTime.now().getYear() - year;    
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
