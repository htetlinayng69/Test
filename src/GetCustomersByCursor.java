import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class GetCustomersByCursor {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public static void main(String[] args) {
		try {
			CallableStatement cst = con.prepareCall("call get_customers_by_cursor(?,?)");
			cst.setString(1, "Ygn");
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.setString(2, "");
			cst.executeUpdate();
			String result = cst.getString(2);
			System.out.println("result : " + result);
			cst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
