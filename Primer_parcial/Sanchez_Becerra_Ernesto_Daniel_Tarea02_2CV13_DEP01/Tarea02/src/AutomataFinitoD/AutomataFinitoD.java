/*
    El siguiente programa realiza un Automata Finito Determinista en el cual se especifican las siguientes 
    características para un correcto funcionamiento:
    E = {0,1}
    Q = {q0,q1,q2}
    s = q0
    F = q2

    A partir de esto, podemos observar que nuestro alfabeto está compuesto por "0" y "1" y el estado de aceptación 
    será q2.
    También podemos guiarnos a partir de la siguiente tabla:
      &     0      1
    ----|------|------|
     q0 |  q0  |   q1 |
    ----|------|------|
     q1 |  q1  |  q2  |
    ----|------|------|
     q2 |qError|  q2  |
    ----|------|------|

*/
package AutomataFinitoD;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author ERNESTO
 */
public class AutomataFinitoD {
    int cont = 0;
    boolean aceptado;
    char [] cad;
    
    @SuppressWarnings("deprecation")
    public static String leer(){
		String s = "";
		DataInputStream sd = new DataInputStream(System.in);
		System.out.flush();
		try{
		 s = sd.readLine();
		}
		catch(IOException e){
		 System.out.println("ERROR: No se introdujo el dato");
		 System.out.println(e);
		}
		return s;
	}
    
    public static void main(String [] args){
        AutomataFinitoD aut = new AutomataFinitoD();
        String cadena = "";
        System.out.println("Introduzca una cadena: ");
        cadena = leer();
        aut.cad = cadena.toCharArray();
        aut.inicio();    
        if(aut.aceptado){
             System.out.println("Cadena aceptada");
        }
        else{
             System.out.println("Cadena no aceptada");
        }
    }
    
     private void inicio() {
        cont = 0;
        aceptado = false;
        q0();
    }
    
    public void q0(){
        System.out.println("Estoy en q0");
        if(cont < cad.length){
            if(cad[cont] == '0'){
                cont++;
                q0();
            }
            else if(cad[cont] == '1'){
                cont++;
                q1();
            }
        }
    }

    private void q1() {
        System.out.println("Estoy en q1");
        aceptado = false;
        if(cont < cad.length){
            if(cad[cont] == '0'){
                cont++;
                q1();
            }
            else if(cad[cont] == '1'){
                cont++;
                q2();
            }
        }
    }

    private void q2() {
        System.out.println("Estoy en q2 --> Estado de aceptacion");
        aceptado = true; 
        if(cont < cad.length){
            if(cad[cont] == '1'){
                cont++;
                q2();   
            }
            else if(cad[cont] == '0'){
                cont++;
                qError();
            }
        }
    }

    private void qError() {
        aceptado = false;
        if(cont < cad.length){
            if(cad[cont] == '1'){
                cont++;
                System.out.println("Estoy en q2 --> Estado de aceptacion");
                q2();   
            }
            else if(cad[cont] == '0'){
                cont++;
                System.out.println("La cadena no termina en estado de aceptacion q2");
                qError();
            }
        }
    }
}

   