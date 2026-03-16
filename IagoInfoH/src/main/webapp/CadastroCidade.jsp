<%-- 
    Document   : CadastroCidade
    Created on : 23 de fev. de 2026, 15:02:15
    Author     : Tulio Dias
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <h1>Cadastro Cidade</h1>
        <form type="hidden" name="cadastro" method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">
            <input type="hidden" id="opcao" name="opcao" value="${opcao}">
            <input type="hidden" name="codigoCidade" value="${codigoCidade}">
            <p><label>Cidade:</label> <input type="text" name="nomeCidade" value="" size="40"></p>
            <p><label>UF:</label> <input type="text" name="ufCidade" value="" size="5"></p>
            <input type="submit" value="Salvar" name="Salvar">
        </form>
        <h3>${mensagem}</h3>
        <table border="1">
            <c:if test="${not empty listaCidade}">
            <tr>
                <th>CÓDIGO </th>
                <th>NOME</th>
                <th>UF</th>
                <th>ALTERAR</th>
                <th>EXCLUIR</th>
            </tr>
            </c:if>
            <c:forEach var="cidades" items="${listaCidade}">
                <tr>
                    <td>${cidades.codigoCidade}</td>
                    <td>${cidades.nomeCidade}</td>
                    <td>${cidades.ufCidade}</td>
                    <td><form type="hidden" name="cadastro" method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">
                            <input type="hidden" name="codigoCidade" value="${cidades.codigoCidade}">
                            <input type="hidden" name="nomeCidade" value="${cidades.nomeCidade}">
                            <input type="hidden" name="ufCidade" value="${cidades.ufCidade}">
                            <input type="hidden" name="opcao" value="enviarAlterar">
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td><form type="hidden" name="cadastro" method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/CidadeControlador">
                            <input type="hidden" name="codigoCidade" value="${cidades.codigoCidade}">
                            <input type="hidden" name="nomeCidade" value="${cidades.nomeCidade}">
                            <input type="hidden" name="ufCidade" value="${cidades.ufCidade}">
                            <input type="hidden" name="opcao" value="enviarExcluir">
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
