/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.modelo.dao.CidadeDao;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Cidade;
import br.edu.ifsuldeminas.infoh2026.servico.WebConstante;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author 02338079698
 */
@WebServlet(WebConstante.BASE_PATH + "/CidadeControlar")
public class CidadeControlador extends HttpServlet {
    
    Cidade objCidade = new Cidade();
    CidadeDao objCidadeDao = new CidadeDao();
    String nomeCidade = "";
    String ufCidade = "";
    
    @Override
    public void init() throws ServletException {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);

        try {
            String opcao = request.getParameter("opcao");
            if (opcao == null || opcao.isEmpty()) {

            }
            nomeCidade = request.getParameter("nomeCidade");
            ufCidade = request.getParameter("ufCidade");
            switch (opcao) {
                case "cadastrar":

            }

        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parâmetros não são números válidos" + e.getMessage());
        } catch (IllegalArgumentException e) {
            response.getWriter().println("Erro: " + e.getMessage());
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            objCidade.setNomeCidade(nomeCidade);
    }

}
