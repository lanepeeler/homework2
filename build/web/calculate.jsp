<%-- 2016 © Lane Peeler, Nathan Young, & Jasmine Jones --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="elon" uri="/WEB-INF/tlds/custom_tags.tld" %>

<c:import url="/includes/header.html"/>

<body id="calc-body">
  <h1 id="calc-h1">Future Value <br>Calculator</h1>

  <label class="calc-label">Investment <br class="break">Amount:</label>
  <span><elon:currencyFormat value="${bean.investAmt}"/></span><br>
  <label class="calc-label">Yearly Interest <br class="break">Rate:</label>
  <span>${bean.interestRate}</span><br>
  <label class="calc-label">Number of Years:</label>
  <span>${bean.numYears}</span><br>
  <label class="calc-label future-value">Future Value:</label>
  <table>
    <tr>
      <th id="yr-head">Year</th>
      <td id="mid-head">&nbsp;</td>
      <th id="val-head">Value</th>
    </tr>
    <c:forEach var="item" items="${map}">
        <tr>
          <td id="yr">${item.key}</td>
          <td id="mid">&nbsp;</td>
          <td id="val"><elon:currencyFormat value="${item.value}"/></td>
        </tr>
    </c:forEach>
  </table>

  <a href="<c:url value='/calculate'/>">Return to Calculator</a>

  <c:import url="includes/footer.html"/>
