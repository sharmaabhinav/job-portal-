package CreateResume;
import java.io.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class Resume implements Serializable {
    public Resume() {
    
    }
    public void set(){

    }
    public void get(){
        
    }
    public String createResume(String regId)throws DocumentException, IOException{
        String resumeFileName=regId+"Resume.pdf";
        File filename=new File("E://OnlineJobPortal/web/RootDocs/"+regId+"/"+resumeFileName);
        String resumePathRel="../RootDocs/"+regId+"/"+resumeFileName;
        String Desc="Resume";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        document.add(new Paragraph("This is my Resume created by Online Job Portal  "));
        try{
        String query1="select * from StudentMaster where StudentId='"+regId+"'";
        java.sql.ResultSet rs1=ConnPack.ConnectionFactory.getInstance().getResultSet(query1,"JOBDSN");
        boolean f1=rs1.next();
        String query2="select * from Graduation where StudentId='"+regId+"'";
        java.sql.ResultSet rs2=ConnPack.ConnectionFactory.getInstance().getResultSet(query2,"JOBDSN");
        boolean f2=rs2.next();
        String query3="select * from Academic where StudentId='"+regId+"'";
        java.sql.ResultSet rs3=ConnPack.ConnectionFactory.getInstance().getResultSet(query3,"JOBDSN");
        boolean f3=rs3.next();
        if(f1==false || f2==false || f3==false)
            return "query 123 has some error";
        else{
                document.add(new Paragraph(rs1.getString(3)+" "+" "+" "+rs1.getString(5)+"                   "+rs1.getString(7)     ));
                document.add(new Paragraph(rs2.getString(4)+"                  "+rs2.getString(2)));
                document.add(new Paragraph("Specialzation: "+rs2.getString(3)));
                document.add(new Paragraph("___________________________________________________________________________"));
                document.add(new Paragraph("Examination                 Institute/Board               Year            ScorType     Value   "));
                document.add(new Paragraph("___________________________________________________________________________"));
                document.add(new Paragraph("Secondary                   "+rs3.getString(2)+"          "+rs3.getString(3)+"       "+rs3.getString(4)+"    "+rs3.getString(5)));
                document.add(new Paragraph("SeniorSecondary            "+rs3.getString(6)+"          "+rs3.getString(7)+"       "+rs3.getString(8)+"    "+rs3.getString(9)));
                document.add(new Paragraph("__________________________________________________________________________________"));
                document.add(new Paragraph("For Graduation Details Please go to AccountSection "));
                String query6="insert into Documents values('"+regId+"','"+resumeFileName+"','"+resumePathRel+"','"+Desc+"')";
                int n6=ConnPack.ConnectionFactory.getInstance().setData(query6, "JOBDSN");
                if(n6==0 || n6==-1)
                    return "query 6 not executed";
            }



        }catch(Exception e){
             document.close();
            return "exception occurred:   "+e.getMessage();
        }
        

        document.close();
        return "true";
        
    }
}
