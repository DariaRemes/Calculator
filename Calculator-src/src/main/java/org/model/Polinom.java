package org.model;

import java.util.*;

public class Polinom {
    private Map<Integer, Double> monom;

    public Polinom(Map<Integer, Double> monom) {
        this.monom = new TreeMap<>(monom);
    }

    public Map<Integer, Double> getMonom() {
        return monom;
    }

    public void setMonom(Map<Integer, Double> monom) {
        this.monom = monom;
    }

    public void addMonom(int exponent, double coeficient) {
        monom.put(exponent, coeficient);
    }

    public String printPolinom() {
        String polinom = "";
        for (Map.Entry<Integer, Double> entry : monom.entrySet()) {
            if (entry.getKey() != 0) {
                if(entry.getKey() == 1) {
                    if (entry.getValue() < 0) {
                        if (entry.getValue() == -1) {
                            polinom += "-" + "X";
                        } else {
                            polinom += entry.getValue() + "X";
                        }
                    } else {
                        if (entry.getValue() == 0) {
                            polinom += "";
                        } else {
                            if (entry.getValue() == 1) {
                                polinom += "+" + "X";
                            } else {
                                polinom += "+" + entry.getValue() + "X";
                            }
                        }
                    }
                }else{
                    if (entry.getValue() < 0) {
                        if (entry.getValue() == -1) {
                            polinom += "-" + "X^" + entry.getKey();
                        } else {
                            polinom += entry.getValue() + "X^" + entry.getKey();
                        }
                    } else {
                        if (entry.getValue() == 0) {
                            polinom += "";
                        } else {
                            if (entry.getValue() == 1) {
                                polinom += "+" + "X^" + entry.getKey();
                            } else {
                                polinom += "+" + entry.getValue() + "X^" + entry.getKey();
                            }
                        }
                    }
                }
            } else {
                polinom += entry.getValue();
            }

        }
        return polinom;
    }
}
