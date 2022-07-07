/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa01;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author ERNESTO
 */
public class Programa01 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean esPalabraValida = true;
        System.out.println("Introduzca el alfabeto: ");
        String alfabeto = entrada.nextLine();
        System.out.println("Introduzca la cadena: ");
        String cadena = entrada.nextLine();

        Cadena cade = new Cadena(cadena);
        //Cadena ewe = new Cadena(cadenados);

        for (int i = 0; i < cadena.length(); i++) {
            String letra = Character.toString(cadena.charAt(i));
            if (!alfabeto.contains(letra)) {
                esPalabraValida = false;
                System.out.println(letra + " no pertenece al alfabeto");
            }
        }
        if (esPalabraValida) {
            System.out.println("La cadena -" + cadena + "- es valida para el alfabeto: " + alfabeto);
            out.println();
            System.out.println("Ingrese la subcadena: ");
            String cadenados = entrada.nextLine();
            Cadena[] lasCadenas = cade.obtenSubcadena(new Cadena(cadenados));
            if (lasCadenas == null) {
                System.out.println("No hay subcadena");
            } else {
                for (Cadena caden : lasCadenas) {
                    System.out.println(caden);
                }
            }
            out.println();
            System.out.println("Escribe una cadena para buscar prefijos: ");
            String cadenatres = entrada.nextLine();
            lasCadenas = cade.obtenerPrefijo(new Cadena(cadenatres));
            if (lasCadenas == null) {
                System.out.println("No hay prefijos");
            } else {
                for (Cadena laCadena : lasCadenas) {
                    System.out.println(laCadena);
                }
            }

            out.println();
            System.out.println("Escribe una cadena para buscar sufijos: ");
            String uwu = entrada.nextLine();
            lasCadenas = cade.obtenerSufijo(new Cadena(uwu));
            if(lasCadenas == null){
                System.out.println("No hay sufijos");
            }else{
                for(Cadena laCadena: lasCadenas){
                    System.out.println(laCadena);
                }
            }
        }
        entrada.close();
    }
}
