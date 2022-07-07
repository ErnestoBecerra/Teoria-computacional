/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa01;

import java.util.Objects;

/**
 *
 * @author ERNESTO
 */
public class Cadena {

    private final String caracteres;

    public Cadena(String caracteres) {
        this.caracteres = caracteres;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (!(objeto instanceof Cadena)) {
            return false;
        }
        Cadena laCadena = (Cadena) objeto;
        return caracteres.equals(laCadena.caracteres);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.caracteres);
        return hash;
    }

    @Override
    public String toString() {
        if (length() == 0) {
            return "E";
        }
        return this.caracteres;
    }

    public int length() {
        return caracteres.length();
    }

    public Cadena[] obtenSubcadena(Cadena caden) {
        String temporal = caden.caracteres;
        String[] temporales = this.caracteres.split(temporal);
        String x = "";
        String w = "";
        String y = "";
        if (temporales.length != 1) {
            x = temporales[0];
            w = temporal;
            y = temporales[1];
        }
        Cadena[] lasCadenas = new Cadena[3];
        if (!w.isEmpty()) {
            lasCadenas[0] = new Cadena("Anterior: " + x);
            lasCadenas[1] = new Cadena("Ingresada: " + w);
            lasCadenas[2] = new Cadena("Siguiente: " + y);
        } else {
            lasCadenas = null;
        }
        return lasCadenas;
    }

    public Cadena[] obtenerPrefijo(Cadena laCadena) {
        int longitud = laCadena.length();
        String x = "";
        String y = "";
        Cadena[] lasCadenas = new Cadena[2];
        if (longitud <= length()) {
            String subCadena = caracteres.substring(0, longitud);

            if (laCadena.length() == 0) {
                x = "E";
                y = caracteres;
            } else {
                if (subCadena.equals(laCadena.caracteres)) {
                    x = laCadena.caracteres;
                    y = caracteres.substring(longitud, length());
                }
            }
        }
        if (!x.isEmpty()) {
            lasCadenas[0] = new Cadena("Ingresado: " + x);
            lasCadenas[1] = new Cadena("Prefijos: " + y);
        } else {
            lasCadenas = null;
        }
        return lasCadenas;
    }

    public Cadena[] obtenerSufijo(Cadena laCadena) {
        int longitud = laCadena.length();
        String x = "";
        String y = "";
        Cadena[] lasCadenas = new Cadena[2];
        String temporal = caracteres.substring(length() - longitud, length());
        System.out.println(temporal);
        if (temporal.equals(laCadena.caracteres)) {
            x = caracteres.substring(0, length() - longitud);
            y = temporal;
        }
        if (!y.isEmpty()) {
            lasCadenas[0] = new Cadena("Sufijos:" + x);
            lasCadenas[1] = new Cadena("Ingresado:" + y);
        } else {
            lasCadenas = null;
        }
        return lasCadenas;
    }
}
