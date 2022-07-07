/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasePrincipal;

import analisis.Alfabeto;
import analisis.AnalizadorSintactico;
import estructuras.AFN;
import estructuras.TablaTransicion;

public class Main {
	
    public static void main(String args[]) throws Exception{

        Alfabeto alfa = new Alfabeto("abc");
        String er = "a+b+c";
        AnalizadorSintactico as = new AnalizadorSintactico(alfa, er);
        
        /*
         *  CONVERSION REGEX -> AFN
         *  ALGORITMO DE THOMPSON
         */ 
       
        AFN salida = as.analizar();
        System.out.printf("AFN:\n%s", salida);
        
               
        /* Imprimir la Tabla transicion del AFN */
        System.out.println();
        TablaTransicion tabla = salida.getTablaTransicion();
        
               
        for (int i=0; i < tabla.getColumnCount(); i++)
            System.out.printf("%s\t", tabla.getColumnName(i));
       
        System.out.println();
        for (int i=0; i < tabla.getRowCount(); i++) {
            for (int j=0; j < tabla.getColumnCount(); j++)
                System.out.printf("%s\t", tabla.getValueAt(i, j));
           
            System.out.println();
        }
       
        System.out.printf("\nAnalisis algoritmo de thompson:\n%s", as.getLog());    
    }

}

