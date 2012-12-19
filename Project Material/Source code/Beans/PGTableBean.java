/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author RAGHU
 */
public class PGTableBean implements Serializable {


     private String regId=null;
    private String degree[]=null;
    private String branch[]=null;
    private String collegeName[]=null;
    private int rowCount=-1;
   
   public void setRegId(String id){
       this.regId=id;

   }
   public int getRowCount(){
       return this.rowCount;
   }
   public void setData(){
       String query="select * from PostGraduation where StudentId='"+regId+"'";
       java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query,"JOBDSN");
       int N=0;
       try{
           while(rs.next()){
               N++;
           }
           this.degree=new String[N];
           this.branch=new String[N];
           this.collegeName=new String[N];
           rs.beforeFirst();
           int k=0;
       while(rs.next()){
           this.degree[k]=rs.getString(2);
           this.branch[k]=rs.getString(3);
           this.collegeName[k]=rs.getString(4);
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
   public String[] getDegree(){

       return this.degree;
   }
   public String[] getBranch(){
       return this.branch;
   }
   public String[] getCollegeName(){
       return this.collegeName;
   }
    public PGTableBean() {
    }


}
