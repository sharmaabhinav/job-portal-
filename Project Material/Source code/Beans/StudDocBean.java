

package Beans;

import java.io.Serializable;


public class StudDocBean implements Serializable {
    private String docLink=null;

    public StudDocBean() {
    }
    public String getDocLink(String regId){
        String query="select DocLink from Documents where StudentID='"+regId+"' and DocDesc='Image'";
        java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query, "JOBDSN");
        try{
             if(rs.next())
                 this.docLink=rs.getString(1);

        }catch(Exception e){

        }
        return this.docLink;
    }

}
