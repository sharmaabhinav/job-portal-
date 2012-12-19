/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.io.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;

/**
 *
 * @author RAGHU
 */
@WebServlet(name="DocsUpload", urlPatterns={"/DocsUpload"})
@MultipartConfig(location="E://OnlineJobPortal/web/RootDocs",maxFileSize=1024*1024*1024,maxRequestSize=1024*1024*1024*5)
public class DocsUpload extends HttpServlet {
   
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

       try {
           int i=(int)(Math.random()*10000);
            Part part=request.getPart("DocUp");//because enctype is set multipart/formdata in DocsUpload
            Part part2=request.getPart("desc");//text type in DocsUpload File
            Collection<String>c=part.getHeaderNames();//to get file header names of part in this page and DocUp field of type file n DocsUpload
            Iterator<String>it=c.iterator();
            String extn=null;
            if(it.hasNext())   //first header name only file name details that's why if is used instead of while loop
            {
                int k=0;
                String hn=it.next();
                String h=part.getHeader(hn);
                char[] head=h.toCharArray();
                char[] tr=new char[3];
                for(int t=head.length-4;t<=(head.length-2);t++)
                   tr[k++]=head[t];

                extn="."+String.copyValueOf(tr);
            }//end of if after this if we have extension of file name
            String name="Doc"+i+extn;// file name is changed to  name+random number+extension in order to identify uniqly the file name of a student
            part.write(regId+"/"+name);//now the problem of file extensions has been removed

            /*Obtaining Description*/
            InputStream is=part2.getInputStream();//To extract description from multipart/form-data used in (text type(name="desc") of DocsUpload.jsp page)
            int d;
            String desc="";
            while((d=is.read())!=-1)
              desc=desc+(char)d;
            String query1 = "insert into Documents values('"+regId+"','"+name+"','../RootDocs/"+regId+"/"+name+"','"+desc+"')";
              int n=ConnPack.ConnectionFactory.getInstance().setData(query1,"JOBDSN");
                  response.sendRedirect("Student/Home.jsp?N="+n);
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
