package com.ideaclick;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class loginservlet extends MVCPortlet {

	public void init() {
        viewJSP = getInitParameter("view-template");
    }
   
    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
       
       String currentViewPage=renderRequest.getParameter("jspPage");
       if(currentViewPage!=null&&!currentViewPage.equals("")){
              include(currentViewPage, renderRequest, renderResponse);
       }else{
              include(viewJSP, renderRequest, renderResponse);
       }
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            //_log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }

    protected String viewJSP;


	@ProcessAction(name="addName")
	public void addName(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException{
		
		String userName1 = ParamUtil.get(actionRequest, "uname", StringPool.BLANK);
		String userPassword1 = ParamUtil.get(actionRequest, "pass", StringPool.BLANK);
		
		
		actionRequest.setAttribute("userName", userName1);
		
		//System.out.println("User Name:"+userName1);
		//System.out.println("User Password:"+userPassword1);
		
		ResultSet rs=null;
        Connection conn=null;
        //PreparedStatement pstmt=null;
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
             //System.out.println("Class Found");
             conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/liferay4me","root","root");
             //System.out.println("Driver found");
             Statement st=conn.createStatement();
             String str="select * from  login where t_username='"+userName1+"'and t_password='"+userPassword1+"'";
 			 rs=st.executeQuery(str);
 			if(rs.next())
 			{
 				System.out.println("Succesfully login");
 				
 	         }
 			else
 			{
 				
 				System.out.println("Unsuccesfull");
 			}
       }catch(Exception e)
        {
        	System.out.println("Error"+e);
        }
	
	
	
}

	@ProcessAction(name="Register")
	public void Register(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException{
		
		String fname = ParamUtil.get(actionRequest, "fname", StringPool.BLANK);
		String lname= ParamUtil.get(actionRequest, "lname", StringPool.BLANK);
		String email= ParamUtil.get(actionRequest, "email", StringPool.BLANK);
		String contact = ParamUtil.get(actionRequest, "contact", StringPool.BLANK);
		String address = ParamUtil.get(actionRequest, "address", StringPool.BLANK);
		int contactno=Integer.parseInt(contact);
		
		
		System.out.println("Data:"+fname+lname+email+contact+address);
				
		
        Connection con=null;
        PreparedStatement pstmt=null;
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
             System.out.println("Class Found");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/liferay4me","root","root");
             System.out.println("Driver found");
             pstmt=con.prepareStatement("Insert into A_Registration(t_fname,t_lname,t_email,t_contact,t_address) Values(?,?,?,?,?)");
             pstmt.setString(1,fname);
             pstmt.setString(2,lname);
             pstmt.setString(3,email);
             
             pstmt.setInt(4,contactno);
             pstmt.setString(5,address);
             pstmt.executeUpdate();
             System.out.println("Data Successfully saved into the database");
           
       }catch(Exception e)
        {
        	System.out.println("Error"+e);
        }
	


}
		}