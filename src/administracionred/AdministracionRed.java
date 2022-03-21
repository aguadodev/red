
package administracionred;

import modelo.Host;

public class AdministracionRed {

    public static void main(String[] args) {

        Host equipoProfeDAM1 = new Host ("EQ-DI5-01", "192.168.117.200", "255.255.0.0", "192.168.0.11");
        
        System.out.println(equipoProfeDAM1);
        
    }

}
