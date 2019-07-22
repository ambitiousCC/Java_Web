package usejdbc.common;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public final class ConnectionUtils {
    private static final ComboPooledDataSource datasource = new ComboPooledDataSource();

    static {
        Properties props = new Properties();
        InputStream in = ConnectionUtils.class.getClassLoader().getResourceAsStream("ConnectionUtils.c3p0.properties");
        System.out.println("testforconnection");
        try {
            props.load(in);
            datasource.setDriverClass(props.getProperty("driverClass"));
            datasource.setJdbcUrl(props.getProperty("jdbcUrl"));
            datasource.setUser(props.getProperty("user"));
            datasource.setPassword(props.getProperty("password"));
            System.out.println("testc3p0");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = datasource.getConnection();
        return conn;
    }

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet resultSet) {
        release(conn, pstmt);
        if(pstmt!=null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pstmt = null;
        }
    }
    public static void release(Connection conn, PreparedStatement pstmt) {
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn = null;
        }
        if(pstmt!=null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pstmt = null;
        }
    }
}
