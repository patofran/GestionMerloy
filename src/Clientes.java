/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author patof
 */
public class Clientes {
    
    private int codigoCli;
    private String nombreCli;
    private String nombreContacto;
    private String apellidosContacto;
    private String telefonoCli; 
    private String faxCli;
    private String direccion1;
    private String direccion2;
    private String ciudadCli;
    private String regionCli;
    private String paisCli;
    private String CodPostal;
    private int codEmpVentas;
    private double limiteCredito;

    public Clientes(int codigoCli, String nombreCli, String nombreContacto, String apellidosContacto, String telefonoCli, String faxCli, String direccion1, String direccion2, String ciudadCli, String regionCli, String paisCli, String CodPostal, int codEmpVentas, double limiteCredito) {
        this.codigoCli = codigoCli;
        this.nombreCli = nombreCli;
        this.nombreContacto = nombreContacto;
        this.apellidosContacto = apellidosContacto;
        this.telefonoCli = telefonoCli;
        this.faxCli = faxCli;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
        this.ciudadCli = ciudadCli;
        this.regionCli = regionCli;
        this.paisCli = paisCli;
        this.CodPostal = CodPostal;
        this.codEmpVentas = codEmpVentas;
        this.limiteCredito = limiteCredito;
    }

    @Override
    public String toString() {
        return "Clientes{" + "codigoCli=" + codigoCli + ", nombreCli=" + nombreCli + ", nombreContacto=" + nombreContacto + ", apellidosContacto=" + apellidosContacto + ", telefonoCli=" + telefonoCli + ", faxCli=" + faxCli + ", direccion1=" + direccion1 + ", direccion2=" + direccion2 + ", ciudadCli=" + ciudadCli + ", regionCli=" + regionCli + ", paisCli=" + paisCli + ", CodPostal=" + CodPostal + ", codEmpVentas=" + codEmpVentas + ", limiteCredito=" + limiteCredito + '}';
    }    
    
}
