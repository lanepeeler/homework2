<%-- 
2016 © Lane Peeler & Nathan Young
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html"/>

  <label>Investment Amount:</label> 
  <span>&dollar;${investAmt}</span><br>
  <label>Yearly Interest Rate:</label>
  <span>${interestRate}</span><br>
  <label>Number of Years:</label>
  <span>${numYears}</span><br>
  <label>Future Value:</label>
  <span>&dollar;${futureValue}</span><br>

<c:import url="includes/footer.jsp"/>
