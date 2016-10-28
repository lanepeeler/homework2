/* 2016 © Lane Peeler & Nathan Young */

package edu.elon.bean;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

/*
Bean used for holding the datamembers Investment Amount, Yearly Interest Rate, 
Number of Years and Future Value. Bean also does formatting.
*/
public class Bean implements Serializable {
    private double investAmt;
    private double interestRate;
    private int numYears;
    private double futureValue;
    private NumberFormat nf;
    
    /*
    Constructor taking no arguments, setting instance variables to 0 and 
    numberformat to US.
    */
    public Bean() {
        investAmt = 0;
        interestRate = 0;
        numYears = 0;
        futureValue = 0;
        nf = NumberFormat.getNumberInstance(Locale.US);
    }
    
    /*
    Constructor setting the values of the Bean
    @param investAmt amount invested
    @param interestRate percent the investment amount goes up per year
    @param numYears the number of years which the money grows
    @param futureValue the value after the money has grown
    */
    public Bean(double investAmt, double interestRate, int numYears, double futureValue) {
        this.investAmt = investAmt;
        this.interestRate = interestRate;
        this.numYears = numYears;
        this.futureValue = futureValue;
        nf = NumberFormat.getNumberInstance(Locale.US);
    }

    /**
     * Gets the formatted investment amount with commas and period in correct place
     * @return the investAmt
     */
    public String getInvestAmt() {
        String s = nf.format(investAmt);
        if (!s.contains(".")) {
            s = s + ".00";
        } else if (s.indexOf(".")+1 == s.length()-1) {
            s = s + "0";
        }
        return s;
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
     * Gets the formatted future value
     * @return the futureValue
     */
    public String getFutureValue() {
        String s = nf.format(futureValue);
        int length = s.length();
        if (s.indexOf(".")+3 == length-1) {
            int last = Integer.parseInt(s.substring(length-1));
            int second = Integer.parseInt(s.substring(length-2, length-1));
            if (last >= 5) {
                second++;
            }
            s = s.substring(0, length-2) + second;
        }
        return s;
    }

    /**
     * @param futureValue the futureValue to set
     */
    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }

}
