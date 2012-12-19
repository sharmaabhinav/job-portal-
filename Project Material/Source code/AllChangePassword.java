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
@WebServlet(name="AllChangePassword", urlPatterns={"/AllChangePassword"})
public class AllChangePassword extends HttpServlet {
   
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
             javax.servlet.http.HttpSession session=request.getSession();
             String regId=session.getAttribute("regId").toString();
           if(session.getAttribute("pageInfo").toString().equals("StudentChangePassword")){
            try{
            String newPass=request.getParameter("newPass");
            String oldPass=request.getParameter("oldPass");
            String query5="select Password from StudentMaster where StudentId='"+regId+"'";
            java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query5, "JOBDSN");
            rs.next();
            String dbPass=rs.getString(1);
            if(dbPass.equals(oldPass)){
             String query3="update StudentMaster set Password='"+newPass+"' where StudentId='"+regId+"'";
             int n1=ConnPack.ConnectionFactory.getInstance().setData(query3, "JOBDSN");
           }else
               response.sendRedirect("Invalid.jsp");
             response.sendRedirect("Student/Home.jsp");
              }catch(Exception e){}
           }else if (session.getAttribute("pageInfo").toString().equals("CollegeChangePassword")) {
                try{
            String newPass=request.getParameter("newPass");
            String oldPass=request.getParameter("oldPass");
            String query5="select Password from CollegeReg where CollegeId='"+regId+"'";
            java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query5, "JOBDSN");
            rs.next();
            String dbPass=rs.getString(1);
            if(dbPass.equals(oldPass)){
             String query3="update CollegeReg set Password='"+newPass+"' where CollegeId='"+regId+"'";
             int n1=ConnPack.ConnectionFactory.getInstance().setData(query3, "JOBDSN");
           }else
               response.sendRedirect("Invalid.jsp");
             response.sendRedirect("College/Home.jsp");
              }catch(Exception e){}




           }else if(session.getAttribute("pageInfo").toString().equals("CompanyChangePassword")){
                 try{
            String newPass=request.getParameter("newPass");
            String oldPass=request.getParameter("oldPass");
            String query5="select Password from CompanyReg where CompanyId='"+regId+"'";
            java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query5, "JOBDSN");
            rs.next();
            String dbPass=rs.getString(1);
            if(dbPass.equals(oldPass)){
             String query3="update CompanyReg set Password='"+newPass+"' where CompanyId='"+regId+"'";
             int n1=ConnPack.ConnectionFactory.getInstance().setData(query3, "JOBDSN");
           }else
               response.sendRedirect("Invalid.jsp");
             response.sendRedirect("Company/Home.jsp");
              }catch(Exception e){}
           }





        } catch(Exception e) {
            out.println("Some error has occurred : " + e.getMessage());
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
