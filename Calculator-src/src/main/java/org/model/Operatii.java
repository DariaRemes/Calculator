package org.model;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatii {

    // Suma
    public static Polinom suma(Polinom p1, Polinom p2) {
        Map<Integer, Double> rezultat = new TreeMap<>(); //monom pentru suma
        boolean pereche;

        //parcurg primul polinom de intrare si il pun in rezultat
        for (Map.Entry<Integer, Double> entryP1 : p1.getMonom().entrySet()) {
            rezultat.put(entryP1.getKey(), entryP1.getValue());
        }
        //parcurg polinomul 2 si rezultatul
        //unde puterile sunt egale adun coeficientii si modific rezultatul
        for (Map.Entry<Integer, Double> entryP2 : p2.getMonom().entrySet()) {
            pereche = false;
            for (Map.Entry<Integer, Double> entryRez : rezultat.entrySet()) {
                if (entryP2.getKey() == entryRez.getKey()) {
                    pereche = true;
                    rezultat.put(entryRez.getKey(), entryP2.getValue() + entryRez.getValue());
                }
            }
            //daca in polinomul 2 exista monom care nu are coresponedent in rezultat il adaug la rezultat
            if (pereche == false) {
                rezultat.put(entryP2.getKey(), entryP2.getValue());
            }
        }
        Polinom polinom = new Polinom(rezultat);
        return polinom;
    }

    //diferenta
    public static Polinom diferenta(Polinom p1, Polinom p2) {
        Map<Integer, Double> rezultat = new TreeMap<>(); //monom pentru diferenta
        boolean pereche;

        //parcurg primul polinom de intrare si il pun in rezultat
        for (Map.Entry<Integer, Double> entryP1 : p1.getMonom().entrySet()) {
            rezultat.put(entryP1.getKey(), entryP1.getValue());
        }
        //parcurg al doilea polinom si polinomul rezultat
        //scadcieficientii acolo unde puterile sunt egale
        for (Map.Entry<Integer, Double> entryP2 : p2.getMonom().entrySet()) {
            pereche = false;
            for (Map.Entry<Integer, Double> entryRez : rezultat.entrySet()) {
                if (entryP2.getKey() == entryRez.getKey()) {
                    pereche = true;
                    rezultat.put(entryRez.getKey(), entryRez.getValue() - entryP2.getValue());
                }
            }
            if (pereche == false) {
                rezultat.put(entryP2.getKey(), -entryP2.getValue());
            }
        }
        Polinom polinom = new Polinom(rezultat);
        return polinom;
    }

    //produs
    public static Polinom produs(Polinom p1, Polinom p2) {
        Map<Integer, Double> rezultat = new TreeMap<>();

        for (Map.Entry<Integer, Double> entryP1 : p1.getMonom().entrySet()) {
            for (Map.Entry<Integer, Double> entryP2 : p2.getMonom().entrySet()) {

                int exponent = entryP1.getKey() + entryP2.getKey();
                double coeficient = entryP1.getValue() * entryP2.getValue();

                rezultat.put(exponent, rezultat.getOrDefault(exponent, 0.0) + coeficient); //getOrDefault => valoarea asociata cheii
            }
        }
        Polinom polinom = new Polinom(rezultat);
        return polinom;
    }

    //derivare
    public static Polinom derivat(Polinom p1) {
        Map<Integer, Double> rezultat = new TreeMap<>();

        for (Map.Entry<Integer, Double> entryP1 : p1.getMonom().entrySet()) {
            if (entryP1.getKey() == 0) {
                rezultat.put(0, 0.0);
            } else {
                rezultat.put(entryP1.getKey() - 1, entryP1.getValue() * entryP1.getKey());
            }
        }
        Polinom polinom = new Polinom(rezultat);
        return polinom;
    }

    //integrare
    public static Polinom integrala(Polinom p1) {
        Map<Integer, Double> rezultat = new TreeMap<>();

        for (Map.Entry<Integer, Double> entryP1 : p1.getMonom().entrySet()) {
            rezultat.put(entryP1.getKey() + 1, entryP1.getValue() / (entryP1.getKey() + 1));

        }
        Polinom polinom = new Polinom(rezultat);
        return polinom;
    }

    //parsare
    public static Polinom parsare(String polinom) {
        Map<Integer, Double> p = new TreeMap<>();
        Pattern pattern = Pattern.compile("((-?\\d+?(\\.\\d+)?)[xX]?\\^?(-?\\d+)?)");
        Matcher matcher = pattern.matcher(polinom);
        while (matcher.find()) {
            p.put(Integer.parseInt(matcher.group(4)), Double.parseDouble(matcher.group(2)));
        }
        Polinom rezultat = new Polinom(p);
        return rezultat;
    }

}
