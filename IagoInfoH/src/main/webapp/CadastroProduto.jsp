<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="Latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=Latin1">
        <title>Cadastro de Produto</title>
    </head>
    <body>

        <%@include file="Menu.jsp" %>

        <h1>Cadastro de Produto</h1>

        <form method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/ProdutoControlador">

            <input type="hidden" name="opcao" value="${opcao}">
            <input type="hidden" name="codigo" value="${codigo}">

            <p>
                <label>Descrição:</label>
                <input type="text" name="descricao" required value="${descricao}" size="40">
            </p>

            <p>
                <label>Preço Compra:</label>
                <input type="text" name="precoCompra" required value="${precoCompra}">
            </p>

            <p>
                <label>Preço Venda:</label>
                <input type="text" name="precoVenda" required value="${precoVenda}">
            </p>

            <p>
                <label>Quantidade:</label>
                <input type="text" name="quantidadeEstoque" required value="${quantidadeEstoque}">
            </p>

            <input type="submit" value="Salvar" style="float:left; margin-right: 3px">
        </form>

        <!-- CANCELAR -->
        <form method="get"
              action="${pageContext.request.contextPath}${URL_BASE}/ProdutoControlador">

            <input type="hidden" name="opcao" value="cancelar">
            <input type="submit" value="Cancelar">
        </form>

        <h3>${mensagem}</h3>

        <!-- ? TABELA -->
        <table border="1">

            <tr>
                <th>CÓDIGO</th>
                <th>DESCRIÇÃO</th>
                <th>PREÇO COMPRA</th>
                <th>PREÇO VENDA</th>
                <th>ESTOQUE</th>
                <th>ALTERAR</th>
                <th>EXCLUIR</th>
            </tr>

            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>${produto.codigo}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.precoCompra}</td>
                    <td>${produto.precoVenda}</td>
                    <td>${produto.quantidadeEstoque}</td>

                    <!-- ALTERAR -->
                    <td>
                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/ProdutoControlador">

                            <input type="hidden" name="codigo" value="${produto.codigo}">
                            <input type="hidden" name="descricao" value="${produto.descricao}">
                            <input type="hidden" name="precoCompra" value="${produto.precoCompra}">
                            <input type="hidden" name="precoVenda" value="${produto.precoVenda}">
                            <input type="hidden" name="quantidadeEstoque" value="${produto.quantidadeEstoque}">
                            <input type="hidden" name="opcao" value="enviarAlterar">

                            <button type="submit">Alterar</button>
                        </form>
                    </td>

                    <!-- EXCLUIR -->
                    <td>
                        <form method="get"
                              action="${pageContext.request.contextPath}${URL_BASE}/ProdutoControlador">

                            <input type="hidden" name="codigo" value="${produto.codigo}">
                            <input type="hidden" name="descricao" value="${produto.descricao}">
                            <input type="hidden" name="precoCompra" value="${produto.precoCompra}">
                            <input type="hidden" name="precoVenda" value="${produto.precoVenda}">
                            <input type="hidden" name="quantidadeEstoque" value="${produto.quantidadeEstoque}">
                            <input type="hidden" name="opcao" value="enviarExcluir">

                            <button type="submit">Excluir</button>
                        </form>
                    </td>

                </tr>
            </c:forEach>

        </table>

    </body>
</html>