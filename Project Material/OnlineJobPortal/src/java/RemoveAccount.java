/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RAGHU
 */
@WebServlet(name="RemoveAccount", urlPatterns={"/RemoveAccount"})
public class RemoveAccount extends HttpServlet {
   
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
        HttpSession session=request.getSession();
       String regId=session.getAttribute("regId").toString();
        String query1="delete from Diploma where StudentID='"+regId+"'";
         String query2="delete from StudentMaster where StudentID='"+regId+"'";
          String query3="delete from Academic where StudentID='"+regId+"'";
           String query4="delete from Personal where StudentID='"+regId+"'";
            String query5="delete from Documents where StudentID='"+regId+"'";
             String query6="delete from Graduation where StudentID='"+regId+"'";
             String query7="delete from GradDegreeRecord where StudentID='"+regId+"'";
              String query8="delete from PostGraduation where StudentID='"+regId+"'";
               String query9="delete from Doctorate where StudentID='"+regId+"'";
                String query10="delete from Professional where StudentID='"+regId+"'";
        
          int n1=ConnPack.ConnectionFactory.getInstance().setData(query1, "JOBDSN");
             int n2=ConnPack.ConnectionFactory.getInstance().setData(query2, "JOBDSN");
                int n3=ConnPack.ConnectionFactory.getInstance().setData(query3, "JOBDSN");
                   int n4=ConnPack.ConnectionFactory.getInstance().setData(query4, "JOBDSN");
                      int n5=ConnPack.ConnectionFactory.getInstance().setData(query5, "JOBDSN");
                         int n6=ConnPack.ConnectionFactory.getInstance().setData(query6, "JOBDSN");
                            int n7=ConnPack.ConnectionFactory.getInstance().setData(query7, "JOBDSN");
                               int n8=ConnPack.ConnectionFactory.getInstance().setData(query8, "JOBDSN");
                                  int n9=ConnPack.ConnectionFactory.getInstance().setData(query9, "JOBDSN");
                                     int n10=ConnPack.ConnectionFactory.getInstance().setData(query10, "JOBDSN");
                                       File f=new File("E://OnlineJobPortal/web/RootDocs/"+regId);
                                       File farr[]=f.listFiles();
                                       for(int i=0;i<farr.length;i++)
                                           farr[i].delete();
                                       f.delete();

           response.sendRedirect("index.jsp");
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
