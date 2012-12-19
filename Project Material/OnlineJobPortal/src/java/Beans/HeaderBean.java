package Beans;
import java.io.Serializable;
public class HeaderBean implements Serializable {
    private String firstName=null;
    private String middleName=null;
    private String lastName=null;
    private String collegeName=null;
    public HeaderBean() {
          
    }
    public void setValues(String regId){
          String query="select FirstName,MiddleName,LastName,CollegeName from StudentMaster where StudentId='" + regId + "'";
          java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query, "JOBDSN");
          try{

            if(rs.next()){
                this.firstName=rs.getString(1);
                this.middleName=rs.getString(2);
                this.lastName=rs.getString(3);
                this.collegeName=rs.getString(4);
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
   public String getCollegeName(){
       return this.collegeName;
   }

}
