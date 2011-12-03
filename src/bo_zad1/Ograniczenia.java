/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bo_zad1;

import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author banyaai
 */
public class Ograniczenia extends Funkcja {

    double valC;
    int znak;
    double poczatek = -10;
    double koniec = 10;
    XYSeries xYSeries;

    /**
     * 
     * @param valA
     * @param valB
     * @param valC
     * @param plusMinus 0 = +, 1 = -
     * @param znak 0 = >=, 1 = <=
     */
    public Ograniczenia(double valA, double valB, double valC, int plusMinus, int znak) {
        this.valC = valC;
        this.valA = valA;
        this.valB = valB;
        this.plusMinus = plusMinus;
        this.znak = znak;
    }

    private double zwrocY(double x) {
        if (plusMinus == 0) {
            return (valC - valA * x) / valB;
        } else {
            return (valC + valA * x) / valB;
        }
    }

    private double zwrocX() {
        return valC / valA;
    }

    public XYSeries dataSet(int numer) {
        int k = 0;
        xYSeries = new XYSeries(this.toString());
        for (double i = this.poczatek; i < this.koniec; i = i + 0.001) {
            if (valB != 0) {
                xYSeries.add(i, zwrocY(i));

                if (k == 100 + numer) {
                    k = 0;

                    if (znak == 0) {
                        xYSeries.add(i, zwrocY(i) + 10);
                    } else {
                        xYSeries.add(i, zwrocY(i) - 10);
                    }

                }
            } else {
                xYSeries.add(zwrocX(), i);
                if (k == 100 + numer) {
                    k = 0;

                    if (znak == 0) {
                        xYSeries.add(zwrocX()+10, i);
                    } else {
                        xYSeries.add(zwrocX()-10, i);
                    }

                }
            }
            k++;
        }
        return xYSeries;//new XYSeriesCollection(xYSeries);
    }

    @Override
    public String toString() {
        String tmp = new String();
        tmp += valA + "* X1";
        if (plusMinus == 0) {
            tmp += " + ";
        } else {
            tmp += " - ";
        }

        tmp += valB + "* X2";

        if (znak == 0) {
            tmp += " >= ";
        } else {
            tmp += " <= ";
        }

        return tmp + valC + "\n";
    }
}
