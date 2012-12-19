/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RAGHU
 */
@WebServlet(name="NewRegServ", urlPatterns={"/NewRegServ"})
public class NewRegServ extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       try {
            String role=request.getParameter("newreg");
            String regId=request.getParameter("regId");
            String pass=request.getParameter("password");
            String query1="";
            String query2="";
            if(role.equals("Company"))
            {
                query1="insert into CompanyReg values(" +
                        "'" + regId + "'," +
                        "'" + pass + "'," +
                        "'" + "1" + "'," +
                        "'" + new java.util.Date().toString() + "')";
                query2="insert into CompanyProfile (CompanyId) values('" + regId + "')";
            }
            if(role.equals("College"))
            {
                query1="insert into CollegeReg values(" +
                        "'" + regId + "'," +
                        "'" + pass + "'," +
                        "'" + "1" + "'," +
                        "'" + new java.util.Date().toString() + "')";
                query2="insert into CollegeProfile (CollegeId) values('" + regId + "')";
            }
            ConnPack.ConnectionFactory.getInstance().setData(query1, "JOBDSN");
            ConnPack.ConnectionFactory.getInstance().setData(query2, "JOBDSN");
            response.sendRedirect("Admin/Admin_Home.jsp");

        } finally {

        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
