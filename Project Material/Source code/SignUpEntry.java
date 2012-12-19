/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RAGHU
 */
@WebServlet(name="SignUpEntry", urlPatterns={"/SignUpEntry"})
public class SignUpEntry extends HttpServlet {
   
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
        String content=request.getParameter("content");
         String cap=request.getParameter("code");
       String captcha=(String) request.getSession().getAttribute("captcha");
       if(captcha.equals(cap)==false){
            response.sendRedirect("Student/SignUp.jsp?content=captchawrong");

        }else{


        try {


            String regId=request.getParameter("regId");
            String pass=request.getParameter("password");
            String fname=request.getParameter("fname");
            String mname=request.getParameter("mname");
            String lname=request.getParameter("lname");
            String email=request.getParameter("email");
            String collegeName=request.getParameter("collegeList");
            String secQuest=request.getParameter("secQuest");
            String secAns=request.getParameter("secAns");
            String enroll=request.getParameter("enroll");
            out.println("<h1>"+regId+" "+pass+" "+fname+" "+mname+" "+lname+" "+email+" "+collegeName+" "+enroll+"</h1>");
            String query1="insert into StudentMaster values("
                    +"'"+regId+"',"
                    +"'"+pass+"',"
                    +"'"+fname+"',"
                    +"'"+mname+"',"
                    +"'"+lname+"',"
                    +"'"+collegeName+"',"
                    +"'"+enroll+"',"
                    +"'"+new java.util.Date().toString()+"',"
                    +"'"+email+"')";
            String query2="insert into Personal(StudentId,Gender,SecurityQuest,Answer,IndustrialExp) values('"+regId+"','MALE','"+secQuest+"','"+secAns+"','0')";
            String query3="insert into Academic(StudentId,Status) values('"+regId+"','F')";
            File f=new File("E://OnlineJobPortal/web/RootDocs/"+regId);//enter portable code
            f.mkdir();
            String query6="insert into Documents values('"
           +regId+"','unknown.jpg','../RootDocs/unknown.jpg','Image')";
            int n1=ConnPack.ConnectionFactory.getInstance().setData(query1, "JOBDSN");
            int n2=ConnPack.ConnectionFactory.getInstance().setData(query2, "JOBDSN");
            int n3=ConnPack.ConnectionFactory.getInstance().setData(query3, "JOBDSN");
            int n6=ConnPack.ConnectionFactory.getInstance().setData(query6, "JOBDSN");
            if(n1 == -1 || n2==-1 || n3==-1 || n6==-1  )
                out.println("query not executed");
            else
            response.sendRedirect("index.jsp");
        } catch(Exception e){
                       out.println("HI Error Occurred");
                }
        }//end of else
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
