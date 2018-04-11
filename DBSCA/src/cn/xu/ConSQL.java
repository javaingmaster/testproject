package cn.xu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConSQL {
	String ID;
	double Lng,Lat;
	String status;
	//声明Connection对象
	Connection con;
    //驱动程序名
    String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://localhost:3306/big_data";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "353142927";
    //遍历查询结果集
	public void insertData(String ID,double Lng,double Lat,String status) {
		try {
			 PreparedStatement psql;
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            psql = con.prepareStatement("insert into  bigdata(cluster_ID,Lng,Lat,status) "
                    + "values(?,?,?,?,?)");
            psql.setString(1, ID);              //设置参数1，创建id为3212的数据
            psql.setDouble(2, Lng);      //设置参数2，name 为王刚
            psql.setDouble(3, Lat);
            psql.setString(4,status);
            psql.executeUpdate();           //执行更新
        } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
	}
	
}
