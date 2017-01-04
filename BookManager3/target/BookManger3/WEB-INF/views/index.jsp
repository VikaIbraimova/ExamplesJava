<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Proselyte</title>
</head>
<body>
<h3>Proselyte presents</h3>
<h3><a href="downloadPDF">Download PDF Document</a></h3>
<p style="text-align: left"><button>Excel</button>
<input type="button" value="Excel2" onClick='location.href="<c:url value="/books"/>"'>
<br/>
<a href="<c:url value="/books"/>" target="_blank">Books list</a>
<br/>
</body>
</html>