/* 2016 © Lane Peeler & Nathan Young */

package edu.elon.calculate;

import edu.elon.bean.Bean;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet {

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    String url = "/index.jsp";

    // get current action
    String action = request.getParameter("action");

    if (action == null) {
      action = "input";  // default action
    }

    //If comes from another source, redirect to index.jsp
    if (action.equals("input")) {
      url = "/index.jsp";
    } //If comes from form, extract info, add to request, send to "submitted" page
    else if (action.equals("compute")) {
      // direct to calculate.jsp
      url = "/calculate.jsp";
      
      // get parameters from the request
      String investAmt = request.getParameter("investment-amount");
      String interestRate = request.getParameter("interest-rate");
      String numYears = request.getParameter("number-years");
      
      // convert Strings to numbers and calculate future value
      double invAmt = Double.parseDouble(investAmt);
      double intRate = Double.parseDouble(interestRate);
      double intrCalc = 1 + (intRate/100);
      int yrs = Integer.parseInt(numYears);
      double futureValue = invAmt * Math.pow(intrCalc, yrs);
      
      // format so money values report two decimal places
      // and interest value reports one decimal place
      // convert back to numbers
//      NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
      
      String s = String.format("%.2f", invAmt);
//      String s = nf.format(invAmt);
//      String[] num = s.split(",");
      invAmt = Double.parseDouble(s);
      String t = String.format("%.1f", intRate);
//      String t = nf.format(intRate);
      intRate = Double.parseDouble(t);
      String r = String.format("%.2f", futureValue);
//      String r = nf.format(futureValue);
      futureValue = Double.parseDouble(r);

      
      // store data in Bean object
      Bean bean = new Bean(invAmt, intRate, yrs, futureValue);
      
      // set Bean object in request object
      request.setAttribute("bean", bean);
      
//      request.setAttribute("investAmt", invAmt);
//      request.setAttribute("interestRate", intRate);
//      request.setAttribute("numYears", yrs);
//      request.setAttribute("futureValue", futureValue);
      
//      System.out.println("The invest amount value is: " + investAmt);
//      System.out.println("The interestRate value is: " + interestRate);
//      System.out.println("The years value is: " + numYears);
//      System.out.println("The action value is: " + action);
    }
    getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);

  }

}
