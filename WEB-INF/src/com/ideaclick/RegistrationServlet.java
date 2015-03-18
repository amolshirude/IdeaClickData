package com.ideaclick;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class RegistrationServlet extends MVCPortlet {
	
	public void init() {
        viewJSP = getInitParameter("Registration-jsp");
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
	
	@ProcessAction(name="Register")
	public void Register(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException{
		
		String fname = ParamUtil.get(actionRequest, "fname", StringPool.BLANK);
		String lname= ParamUtil.get(actionRequest, "lname", StringPool.BLANK);
		String email= ParamUtil.get(actionRequest, "email", StringPool.BLANK);
		String contact = ParamUtil.get(actionRequest, "contact", StringPool.BLANK);
		String address = ParamUtil.get(actionRequest, "address", StringPool.BLANK);
		
		
		
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
             pstmt.setString(4,contact);
             pstmt.setString(5,address);
             pstmt.executeUpdate();
             System.out.println("Data Successfully saved into the database");
           
       }catch(Exception e)
        {
        	System.out.println("Error"+e);
        }
	


}
	}
