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
@WebServlet(name="AcademicAddNew", urlPatterns={"/AcademicAddNew"})
public class AcademicAddNew extends HttpServlet {
   
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

                try{
                String SecBoard=request.getParameter("secBoard");
                String SenSecBoard=request.getParameter("senSecBoard");
                String SecYOP=request.getParameter("secYOP");
                String SenSecYOP=request.getParameter("senSecYOP");
                String SecScoreType=request.getParameter("secScoreType");
                String SenSecScoreType=request.getParameter("senSecScoreType");
                String SecValue=request.getParameter("secValue");
                String SenSecValue=request.getParameter("senSecValue");
                String query7="update  Academic set SecBoard = "
                +"'"+SecBoard+"'"
                +", SecYOP = '"+SecYOP+"'"
                +", SecScoreType = '"+SecScoreType+"'"
                +", SecValue = '"+SecValue+"'"
                 +", SenSecBoard ='"+SenSecBoard+"'"
                 +", SenSecYOP = '"+SenSecYOP+"'"
                +", SenSecScoreType = '"+SenSecScoreType+"'"
                +", SenSecValue = '"+SenSecValue+"'"+", Status = 'T'"
                 +" where StudentId = '"+regId+"'";
                 int n1=ConnPack.ConnectionFactory.getInstance().setData(query7, "JOBDSN");
                 response.sendRedirect("Student/Profile.jsp");
             }catch(Exception e){
                out.println(e.getMessage() + "<br>"+ e);

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
