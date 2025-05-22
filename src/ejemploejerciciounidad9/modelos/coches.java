/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploejerciciounidad9.modelos;

/**
 *
 * @author Franc
 */
public class coches {
    private String matricula;
    private String modelo;

    public coches(String matricula, String modelo) {
        this.matricula = matricula;
        this.modelo = modelo;
    }

    public coches() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
        
    
}
