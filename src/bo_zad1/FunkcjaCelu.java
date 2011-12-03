/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo_zad1;

/**
 *
 * @author banyaai
 */
public class FunkcjaCelu extends Funkcja {

    int minMax;
    double valCCel;
    
    public FunkcjaCelu(int minMax, double valA, double valB) {
        this.valA = valA;
        this.valB = valB;
        this.minMax = minMax;
    }

//    private double zwrocY(double x) {
//        if (plusMinus == 0) {
//            return (valC - valA * x) / valB;
//        } else {
//            return (valC + valA * x) / valB;
//        }
//    }
}
