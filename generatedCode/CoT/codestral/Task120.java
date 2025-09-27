package CoT.codestral;
<%@ page import="java.util.*" %>
<%
    String userInput = request.getParameter("userInput");
    String safeInput = org.apache.commons.text.StringEscapeUtils.escapeHtml4(userInput);
%>
<html>
<body>
    <p>User Input: <%= safeInput %></p>
</body>
</html>