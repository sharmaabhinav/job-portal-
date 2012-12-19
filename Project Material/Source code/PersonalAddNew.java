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
@WebServlet(name="PersonalAddNew", urlPatterns={"/PersonalAddNew"})
public class PersonalAddNew extends HttpServlet {
   
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
      javax.servlet.http.HttpSession session=request.getSession();
             String regId=session.getAttribute("regId").toString();
              String fname=request.getParameter("firstName");
                String mname=request.getParameter("middleName");
                String lname=request.getParameter("lastName");
                String gender=request.getParameter("gender");
                String dob=request.getParameter("dob");
                String nationality=request.getParameter("nationality");
                String country=request.getParameter("country");
                String cdetails=request.getParameter("cdetails");
                String email=request.getParameter("emailId");

                String query1="update  Personal set Gender = "
                +"'"+gender+"'"
                +", DateOfBirth = '"+dob+"'"
                +", Nationality = '"+nationality+"'"
                +", CountryOfResidence = '"+country+"'"
                 +", ContactNumber ='"+cdetails+"'"
                 +" where StudentId = '"+regId+"'";

               String query2="update StudentMaster set FirstName = "
                 +"'"+fname+"'"
                 +",MiddleName = '"+mname+"'"
                 +",LastName = '"+lname+"'"
                 +",EmailID ='"+email+"'"
                 +" where StudentId = '"+regId+"'";
          try{
            int n1=ConnPack.ConnectionFactory.getInstance().setData(query1, "JOBDSN");
            int n2=ConnPack.ConnectionFactory.getInstance().setData(query2, "JOBDSN");
            response.sendRedirect("Student/Profile.jsp");
        }catch(Exception ex){ response.sendRedirect("Error.jsp?ErrorDet="+ex.getMessage());}
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
