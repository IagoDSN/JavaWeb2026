<%-- 
    Document   : CadastroProduto
    Created on : 2 de mar de 2026
    Author     : 13410289682
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <%@include file="Menu.jsp" %>
        <h1>Gerenciamento de Produtos</h1>
        
        <form type="hidden" name="cadastro" method="get" 
              action="${pageContext.request.contextPath}${URL_BASE}/ProdutoControlador">
            <input type="hidden" id="opcao" name="opcao" value="${opcao}">
            <p>${opcao}</p>
            <input type="hidden" name="codigo" value="${codigo}">
            
            <p><label>Descrição:</label> <input type="text" name="descricao" required="" value="${descricao}" size="40"></p>
            <p><label>Preço Compra:</label> <input type="text" name="precoCompra" required="" value="${precoCompra}" size="10"></p>
            <p><label>Preço Venda:</label> <input type="text" name="precoVenda" required="" value="${precoVenda}" size="10"></p>
            <p><label>Estoque:</label> <input type="number" name="quantidadeEstoque" required="" value="${quantidadeEstoque}" size="5"></p>
            
            <input type="submit" value="Salvar" name="Salvar" style="float:left; margin-right: 3px">
        </form>
            
        <form id="cadastroForm" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ProdutoControlador">
            <input type="submit" value="Cancelar" name="btnCancelar">
             <input type="hidden" name="opcao" value="cancelar">
        </form>    
            
        <h3>${mensagem}</h3>
        
        <table border="1">
            <c:if test="${not empty produtos}">
                <tr>
                    <th>CÓDIGO</th>
                    <th>DESCRIÇÃO</th>
                    <th>PREÇO COMPRA</th>
                    <th>PREÇO VENDA</th>
                    <th>ESTOQUE</th>
                    <th>ALTERAR</th>
                    <th>EXCLUIR</th>
                </tr>
            </c:if>

            <c:forEach var="prod" items="${produtos}">
                <tr>
                    <td>${prod.codigo}</td>
                    <td>${prod.descricao}</td>
                    <td>${prod.precoCompra}</td>
                    <td>${prod.precoVenda}</td>
                    <td>${prod.quantidadeEstoque}</td>
                    <td>
                        <form type="hidden" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ProdutoControlador">
                            <input type="hidden" name="codigo" value="${prod.codigo}">
                            <input type="hidden" name="descricao" value="${prod.descricao}">
                            <input type="hidden" name="precoCompra" value="${prod.precoCompra}">
                            <input type="hidden" name="precoVenda" value="${prod.precoVenda}">
                            <input type="hidden" name="quantidadeEstoque" value="${prod.quantidadeEstoque}">
                            <input type="hidden" name="opcao" value="enviarAlterar">
                            <button type="submit">Alterar</button>
                        </form>
                    </td>
                    <td>
                        <form type="hidden" name="cadastro" method="get" action="${pageContext.request.contextPath}${URL_BASE}/ProdutoControlador">
                            <input type="hidden" name="codigo" value="${prod.codigo}">
                            <input type="hidden" name="descricao" value="${prod.descricao}">
                            <input type="hidden" name="precoCompra" value="${prod.precoCompra}">
                            <input type="hidden" name="precoVenda" value="${prod.precoVenda}">
                            <input type="hidden" name="quantidadeEstoque" value="${prod.quantidadeEstoque}">
                            <input type="hidden" name="opcao" value="enviarExcluir">
                            <button type="submit">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>