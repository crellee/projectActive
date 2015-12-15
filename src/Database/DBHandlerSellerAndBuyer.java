package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by christianhasselstrom on 11/12/2015.
 */
public class DBHandlerSellerAndBuyer
{
    public static ResultSet isUnique() {
        ResultSet rs = null;

        try {
            Connection conn = DBConnection.getConnection();
            String sqlString = "SELECT s1.email, b1.businessEmail FROM sql499918.Sellers AS s1 INNER JOIN sql499918.Buyers AS b1 ";
            rs = conn.createStatement().executeQuery(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
