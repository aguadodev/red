
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
        String regex1 = "[0-9a-fA-F]{12}";
        String regex2 = "([0-9a-fA-F]{2}:){5}[0-9a-fA-F]{2}";
        String regex3 = "([0-9a-fA-F]{2}-){5}[0-9a-fA-F]{2}";
        String regex4 = "([0-9a-fA-F]{4}\\.){2}[0-9a-fA-F]{4}";
        
        if (mac.matches(regex1) || mac.matches(regex2) || 
            mac.matches(regex3) || mac.matches(regex4))
            return true;
        else
            return false;
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
