
package logingui;

import javax.swing.JOptionPane;

public class Seguridad {
    logingui login = new logingui();
    String res;
    void validarUsuario(String usuarios[], String user, String pwd, int intentos){
        boolean encontrado=false;
        
        for(int i=0; i < usuarios.length; i++){
            if(usuarios[i].equalsIgnoreCase(user) && usuarios[i+1].equals(pwd)){
                res ="¡Bienvenido! "+user;
                encontrado=true;
                JOptionPane.showMessageDialog(null, res," Inicio de sesión ",JOptionPane.INFORMATION_MESSAGE);
                intentos=0;
                login.setIntentos(intentos);
                //Nos lleva al formulario principal
                new frmPapa().setVisible(true);
                break;
            }
        }//FIN DEL FOR
        if (encontrado==false) {
            res=" ¡Clave y/o usuario erróneos!, Llevas "+intentos+" intentos fallidos.";
            JOptionPane.showMessageDialog(null, res," Inicio de sesión ",JOptionPane.ERROR_MESSAGE);
        }
        if (intentos>2){
            JOptionPane.showMessageDialog(null,"3 intentos fallidos, intentalo de nuevo", " Inicio de sesión ",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
