/* 2016 © Lane Peeler, Nathan Young, & Jasmine Jones */
package edu.elon.bean;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Bean used for holding the datamembers Investment Amount, Yearly Interest Rate, 
Number of Years and Future Value. Bean also does formatting.
 */
public class Bean implements Serializable {

    private double investAmt;
    private double interestRate;
    private int numYears;
    private double futureValue;

    /*
    Constructor taking no arguments, setting instance variables to 0 and 
    numberformat to US.
     */
    public Bean() {
        investAmt = 0;
        interestRate = 0;
        numYears = 0;
        futureValue = 0;
    }

    /*
    Constructor setting the values of the Bean
    @param investAmt amount invested
    @param interestRate percent the investment amount goes up per year
    @param numYears the number of years which the money grows
    @param futureValue the value after the money has grown
     */
    public Bean(double investAmt, double interestRate, int numYears) {
        this.investAmt = investAmt;
        this.interestRate = interestRate;
        this.numYears = numYears;
        futureValue = calculate(investAmt, interestRate, numYears);
    }

    public double calculate(double investAmt, double interestRate, int numYears) {
        double intrCalc = 1 + (interestRate / 100);
        setFutureValue(investAmt * Math.pow(intrCalc, numYears));
        return getFutureValue();
    }

    public HashMap<Integer, Double> getMap() {
        HashMap<Integer, Double> collection = new HashMap<>();
        for (int i = 0; i < numYears; i++) {
            collection.put(i, futureValue);
        }
        return collection;
    }

    /**
     * Gets the formatted investment amount with commas and period in correct
     * place
     *
     * @return the investAmt
     */
    public double getInvestAmt() {
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
        return futureValue;
    }

    /**
     * @param futureValue the futureValue to set
     */
    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }

}
