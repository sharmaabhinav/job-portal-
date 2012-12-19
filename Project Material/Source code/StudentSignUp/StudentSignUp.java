package StudentSignUp;
import java.beans.*;
import java.io.Serializable;

public class StudentSignUp implements Serializable {
    private String[] collegeName=null;
    public StudentSignUp(){
        
    }
    public void setCollegeName(String str){
        
        

    }
    public String[] getCollegeName()
    {
      try{
        String query="select NameOfCollege from CollegeProfile";
        java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query, "JOBDSN");
        int num=0;
        while(rs.next()){
            num++;
        }
        rs.beforeFirst();
        collegeName=new String[num];
        int S=0;
        while(rs.next()){
            collegeName[S++]=rs.getString(1);
        }
        
        }catch(Exception e){
            

        }
        return this.collegeName;
    }
}
