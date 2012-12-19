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
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 *
 * @author RAGHU
 */
@WebServlet(name="ImageUpload", urlPatterns={"/ImageUpload"})
@MultipartConfig(location="E://OnlineJobPortal/web/RootDocs",maxFileSize=1024*1024*1024,maxRequestSize=1024*1024*1024*5)
public class ImageUpload extends HttpServlet {
   
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
    
  
          String extn=null;
        String query=null;
         Part part=request.getPart("fileup");
        try
        {
             Collection<String>c=part.getHeaderNames();//to get file header names of part in this page and DocUp field of type file n DocsUpload
            Iterator<String>it=c.iterator();
            String extension=null;
            if(it.hasNext())   //first header name only file name details that's why if is used instead of while loop
            {
                int k=0;
                String hn=it.next();
                String h=part.getHeader(hn);
                char[] head=h.toCharArray();
                char[] tr=new char[3];
                for(int t=head.length-4;t<=(head.length-2);t++)
                   tr[k++]=head[t];

                extension="."+String.copyValueOf(tr);
            }//end of if after this if we have extension of file name

            part.write(regId+"/"+regId+extension);   //file extension

           query="update Documents set DocLink='../RootDocs/"+regId+"/"+regId+extension+"' where StudentID='"+regId+"' and DocDesc ='Image'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           query="update Documents set DocName='"+regId+extension+"' where StudentID='"+regId+"' and DocDesc ='Image'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           response.sendRedirect("Student/Home.jsp");
        }
        catch(Exception ex)
        {
            out.println(ex);
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
