<%-- 
    Document   : CadastroCidade
    Created on : 23 de fev. de 2026, 15:02:15
    Author     : Tulio Dias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="Menu.jsp" %>
    </head>
    <body>
        <h1>Cadastro Cidade</h1>
        <form name="cadastro" method="get" section="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">
            <p><label>Cidade</label> <input type="text" name="nomeCidade" value=""></p>
            <p><label>Cidade</label> <input type="text" name="ufCidade" value=""></p>
            <input type="submit" value="salvar" name="salvar">
        </form>
    </body>
</html>
