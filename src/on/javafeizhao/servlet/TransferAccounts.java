package on.javafeizhao.servlet;
import on.javafeizhao.abo.OperationalData;
import on.javafeizhao.utils.MyDataSourceUtils;
import java.sql.Connection;
import java.sql.SQLException;

public class TransferAccounts {

    Connection conn=null;
    //给指定用户转账，并返回boolean
    public boolean autoPay(String username,String username2,double money){
        boolean bool=false;
        OperationalData od=new OperationalData();
        try{
            conn=MyDataSourceUtils.getCurrentConnection();//获取同一个Connection
            conn.setAutoCommit(false); //开启mysql的事物
            int index=od.rollOut( conn,username, money);
            int index2=od.shiftTo(conn,username2,money);
            if (index>0&&index2>0) {
                conn.commit(); //提交事物
                bool = true;
            }else{
                conn.rollback();//事物回滚
            }
        }catch (SQLException e){
            try{
                bool=false;
                conn.rollback();//事物回滚
            }catch(SQLException e1){
                e1.printStackTrace();
            }

            e.printStackTrace();
        }

        return bool;
    }

}
