/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
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
@WebServlet(name="CheckId", urlPatterns={"/CheckId"})
public class CheckId extends HttpServlet {
   
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
       try
        {

            String regId=request.getParameter("regId");
            String pass=request.getParameter("password");
            String role=request.getParameter("grp1");
            String query=null;
            String url=null;
            int n1=-2;
               String d=new Date().toString();
            boolean status=false;
            if(role.equals("Student")){
                query="select * from StudentMaster where StudentID='" + regId + "' and Password='" + pass + "'";
                url="Student/Home.jsp";
            }else if(role.equals("College")){
                query="select * from CollegeReg where CollegeID='" + regId + "' and Password='" + pass + "'";
                url="College/Home.jsp";
            }else if(role.equals("Company")){
                query="select * from CompanyReg where CompanyID='" + regId + "' and Password='" + pass + "'";
                url="Company/Home.jsp";
            }
           java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query, "JOBDSN");
           if(rs.next()){
               javax.servlet.http.HttpSession session=request.getSession();
               session.setAttribute("regId", regId);
               session.setAttribute("role", role);
               response.sendRedirect(url);

                 if(role.equals("College")){
                 String query1="update CollegeProfile set LastAccessDate='"+d+"' where CollegeId='"+regId+"'";
                 n1=ConnPack.ConnectionFactory.getInstance().setData(query1, "JOBDSN");

             }else if(role.equals("Company")){
                 String query2="update CompanyProfile set LastAccessDate='"+d+"' where CompanyId='"+regId+"'";
                  n1=ConnPack.ConnectionFactory.getInstance().setData(query2, "JOBDSN");
             }else if(role.equals("Student")){
                 String query3="update Personal set LastAccessDate='"+d+"' where StudentId='"+regId+"'";
                  n1=ConnPack.ConnectionFactory.getInstance().setData(query3, "JOBDSN");
             }
              if(n1 == 0 || n1 == -1)
                  out.println("query not executed");





               
           }
           else
               response.sendRedirect("Invalid.jsp");
        }
        catch(Exception ex)
        {

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
