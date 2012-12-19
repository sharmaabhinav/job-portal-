package Beans;
import java.io.Serializable;
public class AcademicBean implements Serializable {
       private String secBoard=null;
       private String senSecBoard=null;
       private String secYOP=null;
       private String senSecYOP=null;
       private String secScoreType=null;
       private String senSecScoreType=null;
       private String secValue=null;
       private String senSecValue=null;
       private String regId=null;

       public AcademicBean(){

       }
       public String getRegId(){
           return this.regId;
       }
       public void setRegId(String id){
           this.regId=id;
           setData(id);
       }
       private void setData(String regId){
           String query="select * from Academic where StudentId='"+regId+"'";
           java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query,"JOBDSN");
           try{
           if(rs.next()){
                this.secBoard=rs.getString(2);
                this.secYOP=rs.getString(3);
                this.secScoreType=rs.getString(4);
                this.secValue=rs.getString(5);
                this.senSecBoard=rs.getString(6);
                this.senSecYOP=rs.getString(7);
                this.senSecScoreType=rs.getString(8);
                this.senSecValue=rs.getString(9);

           }
               }catch(Exception e){
                   
               }
       }
       public String getSecBoard(){
             return  this.secBoard;

       }
       public String getSenSecBoard(){
           return this.senSecBoard;
       }
       public String getSecYOP(){
           return this.secYOP;

       }
       public String getSenSecYOP(){
           return this.senSecYOP;
       }
       public String getSecScoreType(){
           return this.secScoreType;
       }
       public String getSenSecScoreType(){
           return this.senSecScoreType;
       }
       public String getSecValue(){
           return this.secValue;
       }
       public String getSenSecValue(){
           return this.senSecValue;
       }
       public void setSecBoard(String sb){
           String query="update Academic set SecBoard='"+sb+"' where StudentId='"+regId+"'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           String query1="update Academic set Status='T' where StudentId='"+regId+"'";
           ConnPack.ConnectionFactory.getInstance().setData(query1,"JOBDSN");
           this.secBoard=sb;
       }
       public void setSenSecBoard(String ssb){
            String query="update Academic set SenSecBoard='"+ssb+"' where StudentId='"+regId+"'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           this.senSecBoard=ssb;
       }
       public void setSecYOP(String syop){
            String query="update Academic set SecYOP='"+syop+"' where StudentId='"+regId+"'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           this.secYOP=syop;
       }
       public void setSenSecYOP(String ssyop){
           String query="update Academic set SenSecYOP='"+ssyop+"' where StudentId='"+regId+"'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           this.senSecYOP=ssyop;
       }
       public void setSecScoreType(String st){
            String query="update Academic set SecScoreType='"+st+"' where StudentId='"+regId+"'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           this.secScoreType=st;
       }
       public void setSenSecScoreType(String sst){
           String query="update Academic set SenSecScoreType='"+sst+"' where StudentId='"+regId+"'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           this.senSecScoreType=sst;
       }
       public void setSecValue(String sv){
           String query="update Academic set SecValue='"+sv+"' where StudentId='"+regId+"'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           this.secValue=sv;
       }
       public void setSenSecValue(String ssv){
           String query="update Academic set SenSecValue='"+ssv+"' where StudentId='"+regId+"'";
           ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
           this.senSecValue=ssv;
       }

}
