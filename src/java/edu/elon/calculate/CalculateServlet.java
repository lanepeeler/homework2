/* 2016 © Lane Peeler & Nathan Young */

package edu.elon.calculate;

import java.io.IOException;
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
      // get parameters from the request
      url = "/calculate.jsp";
      String investAmt = request.getParameter("investment-amount");
      String interestRate = request.getParameter("interest-rate");
      String numYears = request.getParameter("number-years");
      
      double inv = Double.parseDouble(investAmt);
      double intr = Double.parseDouble(interestRate);
      double intrCalc = 1 + (intr/100);
      int yrs = Integer.parseInt(numYears);
      double futureValue = inv * Math.pow(intrCalc, yrs);
      
      String s = String.format("%.2f", inv);
      String t = String.format("%.1f", intr);
      String r = String.format("%.2f", futureValue);
      
      request.setAttribute("investAmt", s);
      request.setAttribute("interestRate", t);
      request.setAttribute("numYears", yrs);
      request.setAttribute("futureValue", r);
      
      System.out.println("The invest amount value is: " + investAmt);
      System.out.println("The interestRate value is:" + interestRate);
      System.out.println("The years value is: " + numYears);
      System.out.println("The action value is: " + action);
    }
    getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);

  }

}
