/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.infoh2026.controlador;

import br.edu.ifsuldeminas.infoh2026.servico.WebConstante;
import br.edu.ifsuldeminas.infoh2026.modelo.dao.CidadeDao;
import br.edu.ifsuldeminas.infoh2026.modelo.entidade.Cidade;
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

@WebServlet(WebConstante.BASE_PATH+"/CidadeControlador")
//designar uma classe como um servelts, mapeando de URL no Servidor Web(GlassFish)
public class CidadeControlador extends HttpServlet{
    
    Cidade objCidade = new Cidade();
    CidadeDao objCidadeDaO = new CidadeDao();
    String nomeCidade=""; 
    String ufCidade= "";
    String opcao = "";
    @Override
    public void init() throws ServletException {
     
    }

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response); 
        
        try {
            opcao = request.getParameter("opcao");
            if (opcao == null || opcao.isEmpty()) {
                opcao = "cadastrar";
            }
            nomeCidade = request.getParameter("nomeCidade");
            ufCidade = request.getParameter("ufCidade");
            
            switch (opcao) {
                case "cadastrar": 
                    cadastrar(request, response); 
                break;
            }
            
        } catch (NumberFormatException e) {
            response.getWriter().println("Erro: um ou mais parametros não são número válido"+e.getMessage());
        }catch (IllegalArgumentException ex){
            response.getWriter().println("Erro: "+ex.getMessage());
        }
    }
    
    
    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        objCidade.setNomeCidade(nomeCidade);
        objCidade.setUfCidade(ufCidade);
        System.out.println("chegou");
        objCidadeDaO.salvar(objCidade);
    }
    
}