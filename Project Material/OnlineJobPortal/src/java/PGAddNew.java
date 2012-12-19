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
@WebServlet(name="PGAddNew", urlPatterns={"/PGAddNew"})
public class PGAddNew extends HttpServlet {
   
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
            String Degree = request.getParameter("Degree");
            String Branch = request.getParameter("Branch");
            String Duration=request.getParameter("Duration");
            String Institute =request.getParameter("name");
            String University = request.getParameter("university");
            String YOB = request.getParameter("yob");
            String YOP = request.getParameter("yop");
            String ScoreType = request.getParameter("grp1");
            String Value=request.getParameter("value");
           // out.println(" "+Degree+" "+Branch+" "+Duration+" "+Institute+" "+University+" "+YOB+" "+YOP+" "+ScoreType+" "+Value+" ");

             String query1 = "insert into PostGraduation values('"+regId+"'"
                      + ",'" + Degree+ "'"
                      + ",'" + Branch +"'"
                      + ",'" +Institute + "'"
                      + ",'" +University + "'"
                      + ",'" +YOB + "'"
                      + ",'" + YOP + "'"
                      + ",'" + ScoreType + "'"
                      + ",'" + Duration + "'"
                      + ",'" +Value+"')";
              int n=ConnPack.ConnectionFactory.getInstance().setData(query1,"JOBDSN");
              if(n==-1 || n==0)
                  out.println("query not executed");
              else
                response.sendRedirect("Student/Profile.jsp");

               }catch(Exception e){
                   out.println("Some error has occurred : "+ e.getMessage());

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
