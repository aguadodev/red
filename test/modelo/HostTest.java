
package modelo;

import org.junit.Test;
import static org.junit.Assert.*;


public class HostTest {
    
    public HostTest() {
    }
    
    @Test
    public void validarMac() {
        assertTrue(Host.validarMac("FFFFFFFFFFFF"));
        assertTrue(Host.validarMac("5C260A242A60"));
        assertTrue(Host.validarMac("5C:26:0A:24:2A:60"));
        assertTrue(Host.validarMac("5C-26-0A-24-2A-60"));
        assertTrue(Host.validarMac("5C26.0A24.2A60"));
        
        assertFalse(Host.validarMac("5C260A242A6G"));
        assertFalse(Host.validarMac("5C:26:0A:24:2A.60"));
        assertFalse(Host.validarMac("5C-26-0A-24-2A-609"));
        assertFalse(Host.validarMac("5C26.0A24..2A60"));
        assertFalse(Host.validarMac("5C26$0A24H2A60"));        
        assertFalse(Host.validarMac(""));
    }
    
    @Test
    public void validarIp() {
        assertTrue(Host.validarIp("192.168.0.9"));
        assertTrue(Host.validarIp("192.168.100.0"));
        assertTrue(Host.validarIp("255.255.255.255"));
        assertTrue(Host.validarIp("0.0.0.0"));

        assertFalse(Host.validarIp(""));
        assertFalse(Host.validarIp("..."));
        assertFalse(Host.validarIp("192.168..9"));
        assertFalse(Host.validarIp("192.168:0.9"));
        assertFalse(Host.validarIp("192.16x.0.9"));
        assertFalse(Host.validarIp("192.168.0.009"));
        assertFalse(Host.validarIp("192.168.0.9."));
        assertFalse(Host.validarIp(".192.168.0.9"));
        assertFalse(Host.validarIp("256.0.0.0"));
        assertFalse(Host.validarIp("255.256.0.0"));
    }        

    @Test
    public void validarMascara() {
        assertTrue(Host.validarMascara("255.0.0.0"));
        assertTrue(Host.validarMascara("254.0.0.0"));
        assertTrue(Host.validarMascara("252.0.0.0"));
        assertTrue(Host.validarMascara("192.0.0.0"));
        assertFalse(Host.validarMascara("256.0.0.0"));
        assertFalse(Host.validarMascara("194.0.0.0"));
        assertFalse(Host.validarMascara("10.0.0.0"));
        assertFalse(Host.validarMascara("20.0.0.0"));
        assertFalse(Host.validarMascara("0.0.0.0"));

        //Pruebas en el segundo octeto
        assertTrue(Host.validarMascara("255.255.0.0"));
        assertTrue(Host.validarMascara("255.254.0.0"));
        assertTrue(Host.validarMascara("255.252.0.0"));
        assertTrue(Host.validarMascara("255.192.0.0"));
        assertFalse(Host.validarMascara("255.256.0.0"));
        assertFalse(Host.validarMascara("255.194.0.0"));
        assertFalse(Host.validarMascara("255.10.0.0"));
        assertFalse(Host.validarMascara("255.20.0.0"));

        //Pruebas en el tercer octeto
        assertTrue(Host.validarMascara("255.255.255.0"));
        assertTrue(Host.validarMascara("255.255.254.0"));
        assertTrue(Host.validarMascara("255.255.252.0"));
        assertTrue(Host.validarMascara("255.255.128.0"));
        assertFalse(Host.validarMascara("255.255.197.0"));
        assertFalse(Host.validarMascara("255.255.8.0"));
        assertFalse(Host.validarMascara("255.255.25.0"));
        assertFalse(Host.validarMascara("255.255.250.0"));

        //Pruebas en el cuarto octeto
        assertTrue(Host.validarMascara("255.255.255.255"));
        assertTrue(Host.validarMascara("255.255.255.254"));
        assertTrue(Host.validarMascara("255.255.255.192"));
        assertTrue(Host.validarMascara("255.255.255.128"));
        assertFalse(Host.validarMascara("255.255.255.127"));
        assertFalse(Host.validarMascara("255.255.255.257"));
        assertFalse(Host.validarMascara("255.255.255.194"));

        assertFalse(Host.validarMascara(""));
    }    
    
}
