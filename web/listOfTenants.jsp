<%@ page import = "ModelEntities.*" %>
<% Object o = request.getAttribute("tenants");
    out.println(o+"hola");%>

    <html>
    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
         <button type="submit">return to main page.</button>
      </form>
</html>