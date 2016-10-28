<%-- 2016 © Lane Peeler & Nathan Young --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html"/>

<body id="calc-body">
<h1 id="calc-h1">Future Value <br>Calculator</h1>

<jsp:useBean id="bean" scope="request" class="edu.elon.bean.Bean"/>
  <label class="calc-label">Investment Amount:</label> 
  <span>&dollar;<jsp:getProperty name="bean" property="investAmt"/></span><br>
  <label class="calc-label">Yearly Interest Rate:</label>
  <span><jsp:getProperty name="bean" property="interestRate"/></span><br>
  <label class="calc-label">Number of Years:</label>
  <span><jsp:getProperty name="bean" property="numYears"/></span><br>
  <label class="calc-label" id="future-value">Future Value:</label>
  <span>&dollar;<jsp:getProperty name="bean" property="futureValue"/></span><br>

<c:import url="includes/footer.html"/>
