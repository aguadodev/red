
package modelo;

import java.util.Arrays;


public class Host {
    String nombre;
    String mac;
    String ip;
    String mascara;
    String gateway;
    String[] dns;

    
    /* CONSTRUCTORES */
    public Host() {
    }

    public Host(String nombre) {
        this.nombre = nombre;
    }

    public Host(String ip, String mascara) {
        this("", ip, mascara, "");
    }

    public Host(String nombre, String ip, String mascara) {
        this(nombre, ip, mascara, "");
    }

    public Host(String nombre, String ip, String mascara, String gateway) {
        this.nombre = nombre;
        
        if (validarIp(ip))
            this.ip = ip;
        
        if (validarIp(ip))
            this.mascara = mascara;

        if (validarIp(ip))       
            this.gateway = gateway;
    }

    /* MÉTODOS ESTÁTICOS */
    public static boolean validarMac(String mac) {        
        return true;
    }    

    public static boolean validarIp(String ip) {        
        return ip.matches("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))");
    }    
    
    public static boolean validarMascara(String mascara) {        
        return true;
    }        

    /* MÉTODOS DE INSTANCIA */
    @Override
    public String toString() {
        String cad = "";
        cad += "HOST\n";
        cad += "====\n";
        cad += "Nombre: " + nombre + "\n";
        cad += "Dirección MAC: " + mac + "\n";
        cad += "Dirección IP: " + ip + "\n";
        cad += "Máscara: " + mascara + "\n";
        cad += "Puerta de enlace: " + gateway + "\n";
        cad += "Servidor/es DNS: " + Arrays.toString(dns) + "\n";
        
        return cad;
    }
        
    
    
    
}
