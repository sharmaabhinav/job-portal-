

package Beans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author RAGHU
 */
public class PersonalBean implements Serializable {
    private String firstName=null;
    private String middleName=null;
    private String lastName=null;
    private String emailId=null;
    private String gender=null;
    private String dob=null;
    private String nationality=null;
    private String country=null;
    private String cdetails=null;
    private String regId=null;
    public PersonalBean(){

    }
    public void setData(String id){
        this.regId=id;
        setValues(id);
    }
    private void setValues(String regId){
        String query1="select * from StudentMaster where StudentId='"+regId+"'";
        java.sql.ResultSet rs1=ConnPack.ConnectionFactory.getInstance().getResultSet(query1,"JOBDSN");
        String query2="select * from Personal where StudentId='"+regId+"'";
        java.sql.ResultSet rs2=ConnPack.ConnectionFactory.getInstance().getResultSet(query2,"JOBDSN");
       try{
        if(rs1.next()){
                this.firstName=rs1.getString(3);
                this.middleName=rs1.getString(4);
                this.lastName=rs1.getString(5);
                this.emailId=rs1.getString(9);
       }
        if(rs2.next()){
            this.gender=rs2.getString(2);
            this.cdetails=rs2.getString(6);
            this.country=rs2.getString(5);
            this.nationality=rs2.getString(4);
            this.dob=rs2.getString(3);
        }
        }catch(Exception e){
            
        }
    }
    public String getFirstName(){
       return this.firstName;
   }
    public String getMiddleName(){
       return this.middleName;
   }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmailId(){
        return this.emailId;
    }
    public String getGender(){
        return this.gender;
    }
    public String getCountry(){
        return this.country;
    }
    public String getCdetails(){
        return this.cdetails;
    }
    public String getNationality(){
        return this.nationality;
    }
    public String getDob(){
        return this.dob;
    }
    public void setFirstName(String fn){
         String query="update StudentMaster set FirstName='"+fn+"' where StudentId='"+regId+"'";
         ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
         this.firstName=fn;
      
   }
    public void setMiddleName(String mn){
        String query="update StudentMaster set MiddleName='"+mn+"' where StudentId='"+regId+"'";
        ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
        this.middleName=mn;
   }
    public void setLastName(String ln){
        if(ln != null && (ln.equalsIgnoreCase("null")==false)){
        String query="update StudentMaster set LastName='"+ln+"' where StudentId='"+regId+"'";
         ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
        }
        this.lastName = ln;
    }
    public void  setEmailId(String em){
        String query="update StudentMaster set EmailId='"+em+"' where StudentId='"+regId+"'";
         ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
         this.emailId=em;
    }
    public void  setGender(String gd){
        String query="update Personal set Gender='"+gd+"' where StudentId='"+regId+"'";
         ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
          this.gender=gd;
    }
    public void setCountry(String c){
         String query="update Personal set CountryOfResidence='"+c+"' where StudentId='"+regId+"'";
         ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
        this.country=c;
    }
    public void setCdetails(String cd){
        String query="update Personal set ContactNumber='"+cd+"' where StudentId='"+regId+"'";
        ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
        this.cdetails=cd;
    }
    public void setNationality(String nt){
         String query="update Personal set Nationality='"+nt+"' where StudentId='"+regId+"'";
         ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
        this.nationality=nt;
    }
    public void setDob(String db){
        String query="update Personal set DateOfBirth='"+db+"' where StudentId='"+regId+"'";
         ConnPack.ConnectionFactory.getInstance().setData(query,"JOBDSN");
         this.dob=db;
    }
}
