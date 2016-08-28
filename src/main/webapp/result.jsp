<%@ page import="java.util.*" %>

<html>
    <body>
        <h1 align="center">Beer Recommendations JSP</h1>
        <br>
        Contact email:
        <%
            out.print((String)request.getAttribute("adminEmail"));
        %>
        <br>
        <p>
        <%
            List styles = (List)request.getAttribute("styles");
            Iterator it = styles.iterator();
            while (it.hasNext()) {
                out.print("<br>try: " + it.next());
            }
        %>
        <br>
        <br>
        Chosen sizes:<br>
        <%
            String[] chosenSizes = (String[])request.getAttribute("sizes");
            if (chosenSizes == null) {
                out.print("No sizes chosen");
            } else {
                for (int i = 0; i < chosenSizes.length; i++) {
                    out.print(chosenSizes[i] + "<br>");
                }
            }
        %>
    </body>
</html>
