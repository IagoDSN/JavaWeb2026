
import br.edu.ifsuldeminas.infoh2026.modelo.dao.ProdutoDao;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Produto;
import br.edu.ifsuldeminas.infoh2026.servico.WebConstante;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(WebConstante.BASE_PATH + "/ProdutoControlador")
public class ProdutoControlador extends HttpServlet {

    Produto objProduto = new Produto();
    ProdutoDao objProdutoDao = new ProdutoDao();

    String descricao = "";
    String precoCompra = "";
    String precoVenda = "";
    String quantidadeEstoque = "";
    String opcao = "";
    String codigo = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            opcao = request.getParameter("opcao");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }

            codigo = request.getParameter("codigo");
            descricao = request.getParameter("descricao");
            precoCompra = request.getParameter("precoCompra");
            precoVenda = request.getParameter("precoVenda");
            quantidadeEstoque = request.getParameter("quantidadeEstoque");

            switch (opcao) {
                case "cadastrar":
                    cadastrar(request, response);
                    break;

                case "enviarAlterar":
                    enviarAlterar(request, response);
                    break;

                case "enviarExcluir":
                    enviarExcluir(request, response);
                    break;

                case "confirmarAlterar":
                    confirmarAlterar(request, response);
                    break;

                case "confirmarExcluir":
                    confirmarExcluir(request, response);
                    break;

                case "cancelar":
                    cancelar(request, response);
                    break;

                default:
                    throw new IllegalArgumentException("Opção inválida: " + opcao);
            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: parâmetros inválidos " + e.getMessage());
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        objProduto.setDescricao(descricao);
        objProduto.setPrecoCompra(Double.valueOf(precoCompra));
        objProduto.setPrecoVenda(Double.valueOf(precoVenda));
        objProduto.setQuantidadeEstoque(Integer.parseInt(quantidadeEstoque));

        objProdutoDao.salvar(objProduto);

        request.setAttribute("mensagem", "Produto cadastrado com sucesso!");
        encaminharParaPagina(request, response);
    }

    private void enviarAlterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("codigo", codigo);
        request.setAttribute("descricao", descricao);
        request.setAttribute("precoCompra", precoCompra);
        request.setAttribute("precoVenda", precoVenda);
        request.setAttribute("quantidadeEstoque", quantidadeEstoque);
        request.setAttribute("opcao", "confirmarAlterar");
        request.setAttribute("mensagem", "Edite os dados e clique em salvar");

        encaminharParaPagina(request, response);
    }

    private void enviarExcluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("codigo", codigo);
        request.setAttribute("descricao", descricao);
        request.setAttribute("precoCompra", precoCompra);
        request.setAttribute("precoVenda", precoVenda);
        request.setAttribute("quantidadeEstoque", quantidadeEstoque);
        request.setAttribute("opcao", "confirmarExcluir");
        request.setAttribute("mensagem", "Confirme e clique para excluir");

        encaminharParaPagina(request, response);
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        objProduto.setCodigo(Integer.valueOf(codigo));
        objProdutoDao.excluir(objProduto);

        encaminharParaPagina(request, response);
    }

    private void confirmarAlterar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        objProduto.setCodigo(Integer.valueOf(codigo));
        objProduto.setDescricao(descricao);
        objProduto.setPrecoCompra(Double.valueOf(precoCompra));
        objProduto.setPrecoVenda(Double.valueOf(precoVenda));
        objProduto.setQuantidadeEstoque(Integer.parseInt(quantidadeEstoque));

        objProdutoDao.alterar(objProduto);

        encaminharParaPagina(request, response);
    }

    private void encaminharParaPagina(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Produto> produtos = objProdutoDao.buscarTodosProdutos();
        request.setAttribute("produtos", produtos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/CadastroProduto.jsp");
        dispatcher.forward(request, response);
    }

    private void cancelar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("codigo", "0");
        request.setAttribute("opcao", "cadastrar");
        request.setAttribute("descricao", "");
        request.setAttribute("precoCompra", "0");
        request.setAttribute("precoVenda", "0");
        request.setAttribute("quantidadeEstoque", "0");

        encaminharParaPagina(request, response);
    }
}