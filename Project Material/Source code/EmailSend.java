/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.mail.*;
import javax.mail.internet.*;
import java.util.* ;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Collection;


/**
 *
 * @author RAGHU
 */
@WebServlet(name="EmailSend", urlPatterns={"/EmailSend"})
public class EmailSend extends HttpServlet {
   
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
       String host="smtp.gmail.com";
        int port = 465;
        String sender = request.getParameter("from");
        String recepient = request.getParameter("to");
        String pass=request.getParameter("pass");
        String subject =request.getParameter("sub");
        String text =request.getParameter("message");
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.user", sender);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.auth", "true");
         InternetAddress fromAddress = null;
         InternetAddress toAddress = null;
         InternetAddress other = null;
        Session sess = Session.getInstance(props);
        /*Collection<Part> Parts=request.getParts();
            Part part=request.getPart("Attachement");
            java.util.Iterator<Part> parts= Parts.iterator();
            part.write("myfile");*/
        try {
            toAddress = new InternetAddress(recepient);
            fromAddress = new InternetAddress(sender);
            other = new InternetAddress(request.getParameter("cc"));
           Message message = new MimeMessage(sess);
            message.setFrom(fromAddress);
            Transport transport = sess.getTransport("smtps");
            transport.connect(host, port, sender, pass);
             message.setSubject(subject);
            message.setText(text);
                        message.addRecipient(MimeMessage.RecipientType.TO,toAddress);
                        transport.sendMessage(message, message.getAllRecipients());
                        message.addRecipient(MimeMessage.RecipientType.CC,other);
                        transport.sendMessage(message, message.getAllRecipients());
                        transport.close();


        }catch(Exception e){
            e.printStackTrace();
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
