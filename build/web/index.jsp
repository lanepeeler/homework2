<%-- 2016 © Lane Peeler, Nathan Young, & Jasmine Jones --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html"/>

<body>
  <h1>Future Value <br>Calculator</h1>

  <form action="calculate" method="post">
    <input type="hidden" name="action" value="compute">

    <!--Source for RegEx: http://jsfiddle.net/NfMQ7/178/ -->
    <p><label>Investment Amount</label> 
      <input type="text" name="investment-amount" 
             title="Positive integer or number to 2 decimal places required"
             pattern="^\d*(\.\d{2}$)?" required value="${sessionScope.invest}"> </p>
    <p><label>Yearly Interest Rate</label>
      <input type="text" name="interest-rate" 
             title="Positive integer or decimal required"
             pattern="\d+[.]?\d*" required value="${sessionScope.interest}"></p>
    <p><label>Number of Years</label>
      <input type="text" name="number-years" pattern="\d+"
             title="Positive integer required" required 
             placeholder="Integer number of years"> </p>
    <p><label id="blank-label">&nbsp;</label>
      <input type="submit" name="submit" value="Calculate"></p>
  </form>

  <c:import url="includes/footer.html"/>
