package on.javafeizhao.web;

import on.javafeizhao.servlet.TransferAccounts;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GainShow extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws IOException,ServletException{

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username= request.getParameter("username");
        String username2= request.getParameter("username2");
        String money_on= request.getParameter("money");
        double money=Double.parseDouble(money_on);

        TransferAccounts  ta=new TransferAccounts();
        boolean bool=ta.autoPay(username,username2,money);
        if (bool){
            response.getWriter().write("转账成功"+"<a href='payPage.jsp'>确定</a>");
        }else{
            response.getWriter().write("转账失败"+"<a href='payPage.jsp'>确定</a>");
        }



    }
}
