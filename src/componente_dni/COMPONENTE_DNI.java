/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente_dni;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author valde
 */
public class COMPONENTE_DNI  extends JTextField implements Serializable, FocusListener{

    private String DNI;

    public COMPONENTE_DNI(){
        init();
    }
    
    public void init(){
        this.setToolTipText("");
        addFocusListener(this);
    }
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public void focusGained(FocusEvent e) {
        pintar(1);
    }

    @Override
    public void focusLost(FocusEvent e) {
        pintar(validarDNI(this.getText()));
    }

    //El valor devuelto indica si el dni introducido es válido.
    //Siendo "0" válido y "-1" invalido.
    //La variable se inicia en "2" para saber si ha llegado a modificarse.
    public int validarDNI(String dni){
        int DNIvalido = 2;
        if(dni.length()==9 | dni.length()==10){
            if(dni.length()==10){
                if(dni.substring(dni.length() - 2, dni.length() - 1).equals("-")){
                    dni = dni.substring(0, 8) + dni.substring(dni.length()-1, dni.length());
                }
            }
            try{
                int numero = Integer.parseInt(dni.substring(0,8));
                int numPosicionLetra = numero % 23;
                String cadenaLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
                if(cadenaLetras.substring(numPosicionLetra, numPosicionLetra + 1).equals(dni.substring(8,9))){
                    DNIvalido = 0;
                }else{
                    DNIvalido = -1;
                }
            }catch(Exception e){
                DNIvalido = -1;
            }
        }
        return DNIvalido;
    }
    
    //INVALIDO: -1
    //VALIDO: 0
    //POR DEFECTO: 1
    public void pintar(int color){
        if(color == -1){
            setForeground(Color.red);
        }else if(color == 0){
            setForeground(Color.green);
        }else if(color == 1){
            setForeground(Color.black);
        }
    }
}
    
