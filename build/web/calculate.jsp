<%-- 2016 © Lane Peeler & Nathan Young --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="elon" uri="/WEB-INF/tlds/custom_tags.tld" %>

<c:import url="/includes/header.html"/>

<body id="calc-body">
<h1 id="calc-h1">Future Value <br>Calculator</h1>

  <label class="calc-label">Investment Amount:</label>
  <span><elon:currencyFormat value="${bean.investAmt}"/></span><br>
  <label class="calc-label">Yearly Interest Rate:</label>
  <span>${bean.interestRate}</span><br>
  <label class="calc-label">Number of Years:</label>
  <span>${bean.numYears}</span><br>
  <label class="calc-label" id="future-value">Future Value:</label>
  <span><elon:currencyFormat value="${bean.futureValue}"/></span><br>

<c:import url="includes/footer.html"/>
