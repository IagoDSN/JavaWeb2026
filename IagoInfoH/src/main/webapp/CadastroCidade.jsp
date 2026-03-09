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
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <h1>Hello World!</h1>
        <form type="hidden" name="cadastro" method="get" 
              action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">
            <input type="hidden" id="opcao" name="opcao" value="${opcao}">
            <p><label>Cidade:</label> <input type="text" name="nomeCidade" value="" size="40"></p>
            <p><label>UF:</label> <input type="text" name="ufCidade" value="" size="5"></p>
            <input type="submit" value="Salvar" name="Salvar">
        </form>
    </body>
</html>
