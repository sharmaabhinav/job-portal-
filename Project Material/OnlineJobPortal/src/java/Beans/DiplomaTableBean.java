package Beans;
import java.beans.*;
import java.io.Serializable;
public class DiplomaTableBean implements Serializable {
    private String regId=null;
    private String diplomaDegree[]=null;
    private String field[]=null;
    private String organisation[]=null;
    private int rowCount=-1;
    public DiplomaTableBean(){
            
    }
   public void setRegId(String id){
       this.regId=id;

   }
   public int getRowCount(){
       return this.rowCount;
   }
   public void setData(){
       String query="select * from Diploma where StudentId='"+regId+"'";
       java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query,"JOBDSN");
       int N=0;
       try{
           while(rs.next()){
               N++;
           }
           this.diplomaDegree=new String[N];
           this.field=new String[N];
           this.organisation=new String[N];
           rs.beforeFirst();
           int k=0;
       while(rs.next()){
           this.diplomaDegree[k]=rs.getString(2);
           this.field[k]=rs.getString(3);
           this.organisation[k]=rs.getString(4);
           k++;
       }
       this.rowCount=N;
       }catch(Exception e){
        this.rowCount=-2;
       }
   }
   public String getRegId(){
       return this.regId;
   }
   public String[] getDiplomaDegree(){
      
       return this.diplomaDegree;
   }
   public String[] getField(){
       return this.field;
   }
   public String[] getOrganisation(){
       return this.organisation;
   }
}
