<%-- 2016 © Lane Peeler & Nathan Young --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html"/>
<body id="calc-body">
<h1 id="calc-h1">Future Value <br>Calculator</h1>

  <label class="calc-label">Investment Amount:</label> 
  <span>&dollar;${investAmt}</span><br>
  <label class="calc-label">Yearly Interest Rate:</label>
  <span>${interestRate}</span><br>
  <label class="calc-label">Number of Years:</label>
  <span>${numYears}</span><br>
  <label class="calc-label" id="future-value">Future Value:</label>
  <span>&dollar;${futureValue}</span><br>

<c:import url="includes/footer.html"/>
