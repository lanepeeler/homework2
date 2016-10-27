/* 2016 © Lane Peeler & Nathan Young */
package edu.elon.bean;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Bean implements Serializable {
    private double investAmt;
    private double interestRate;
    private int numYears;
    private double futureValue;
    private NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
    
    public Bean() {
        investAmt = 0;
        interestRate = 0;
        numYears = 0;
        futureValue = 0;
    }
    
    public Bean(double investAmt, double interestRate, int numYears, double futureValue) {
        this.investAmt = investAmt;
        this.interestRate = interestRate;
        this.numYears = numYears;
        this.futureValue = futureValue;
    }

    /**
     * @return the investAmt
     */
    public double getInvestAmt() {
//        return nf.format(investAmt);
        return investAmt;
    }

    /**
     * @param investAmt the investAmt to set
     */
    public void setInvestAmt(double investAmt) {
        this.investAmt = investAmt;
    }

    /**
     * @return the interestRate
     */
    public double getInterestRate() {
//        String t = String.format("%.1f", interestRate);
//        return Double.parseDouble(t);
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the numYears
     */
    public int getNumYears() {
        return numYears;
    }

    /**
     * @param numYears the numYears to set
     */
    public void setNumYears(int numYears) {
        this.numYears = numYears;
    }

    /**
     * @return the futureValue
     */
    public double getFutureValue() {
//        return nf.format(futureValue);
        return futureValue;
    }

    /**
     * @param futureValue the futureValue to set
     */
    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }
}
