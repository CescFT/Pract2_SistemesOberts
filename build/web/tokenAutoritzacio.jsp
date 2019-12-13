<%@ page import = "ModelEntities.*" %>
<% Object o = request.getAttribute("token");
    out.println(o+"ioo");%>

    <html>
    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
         <button type="submit">return to main page.</button>
      </form>
</html>