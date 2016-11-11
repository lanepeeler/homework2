/* 2016 © Lane Peeler, Nathan Young, & Jasmine Jones */
package edu.elon.calculate;

import edu.elon.bean.Bean;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
Controls the flow between the view files and the Bean business object
Also handles http requests and small calculations
 */
public class CalculateServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        // get current action
        String action = request.getParameter("action");

        if (action == null) {
            action = "input";  // default action
        }

        // if comes from another source, redirect to index.jsp
        if (action.equals("input")) {
            url = "/index.jsp";
        } // if comes from form, extract info, add to request, send to 
         //"submitted" page
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
            int yrs = Integer.parseInt(numYears);

            // save session attributes
            HttpSession session = request.getSession();
            session.setAttribute("invest", invAmt);
            session.setAttribute("interest", intRate);

            // store data in Bean object
            Bean bean = new Bean(invAmt, intRate, yrs);

            // set Bean object in request object
            request.setAttribute("bean", bean);

            // make and store map
            HashMap<Integer, Double> collection = new HashMap<>();
            for (int i = 0; i < yrs; i++) {
                collection.put(i + 1, bean.calculate(invAmt, intRate, i + 1));
            }
            session.setAttribute("map", collection);

        }
        getServletContext().getRequestDispatcher(url).
                forward(request, response);

    }

}
