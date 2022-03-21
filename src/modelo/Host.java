
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

    /* M�TODOS EST�TICOS */
    public static boolean validarMac(String mac) {        
        return true;
    }    

    public static boolean validarIp(String ip) {        
        return ip.matches("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))");
    }    
    
    public static boolean validarMascara(String mascara) {        
        return true;
    }        

    /* M�TODOS DE INSTANCIA */
    @Override
    public String toString() {
        String cad = "";
        cad += "HOST\n";
        cad += "====\n";
        cad += "Nombre: " + nombre + "\n";
        cad += "Direcci�n MAC: " + mac + "\n";
        cad += "Direcci�n IP: " + ip + "\n";
        cad += "M�scara: " + mascara + "\n";
        cad += "Puerta de enlace: " + gateway + "\n";
        cad += "Servidor/es DNS: " + Arrays.toString(dns) + "\n";
        
        return cad;
    }
        
    boolean addServidorDNS(String IpServidor) {
        if (!validarIp(IpServidor)) return false;
        if (dns[0] != null) {
            dns[0] = IpServidor;
        } else if (dns[1] != null) {
            dns[1] = IpServidor;
        } else {
            return false;
        }
        return true;
    }

    boolean delServidorDNS(String IpServidor) {
        if (dns[0].equals(IpServidor)) {
            dns[0] = null;
        } else if (dns[1].equals(IpServidor)) {
            dns[1] = null;
        } else {
            return false;
        }
        return true;
    }
    
    
}
