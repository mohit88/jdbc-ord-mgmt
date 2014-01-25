import junit.framework.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdMgmtTest {
    final String DB_URL = "jdbc:mysql://10.4.31.147/javaordermgmt";
    final String USER = "mohit";
    final String PASS = "P@ssw0rd";
    Connection conn = null;
    Statement stmt = null;

    public OrdMgmtTest() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);;
        stmt = conn.createStatement();
    }

    @Test
    public void testCreationOfEmptyTable() throws SQLException {
        String sql = "CREATE TABLE javaordermgmt.order(order_id INT);";
        Assert.assertEquals(0,stmt.executeUpdate(sql));
        sql = "DROP TABLE javaordermgmt.order";
        Assert.assertEquals(0,stmt.executeUpdate(sql));
    }


}
