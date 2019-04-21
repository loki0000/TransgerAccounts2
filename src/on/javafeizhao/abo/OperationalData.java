package on.javafeizhao.abo;

import on.javafeizhao.servlet.User;
import on.javafeizhao.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OperationalData {
    //扣除金额
    public int rollOut(Connection conn,String username ,double money)throws SQLException {
        //连接数据库
        QueryRunner qr=new QueryRunner();
        String sql="update pey set money=money-? where username=?";
        int index=qr.update(conn,sql,money,username);
        return index;

    }
    //增加金额
    public int shiftTo(Connection conn,String username2,double money)throws SQLException{
        //连接数据库
        QueryRunner qr=new QueryRunner();
        String sql="update pey set money=money+? where username=?";
        int index=qr.update(conn,sql,money,username2);
        return index;
    }
    //查询全部信息
    public List getComplete() throws SQLException{
        //连接数据库
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from pey";
        List<User> list =qr.query(sql,new BeanListHandler<User>(User.class));
        return list;
    }
}
