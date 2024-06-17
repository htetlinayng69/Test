import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class AddCustomer {

	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public static void main(String[] args) {
		try {
			CallableStatement cst = con.prepareCall("call add_customer(?, ?, ?, ?)");
			cst.setInt(1, 10);
			cst.setString(2, "Lookman");
			cst.setString(3, "Mdy");
			cst.setDouble(4, 2500.00);

			int result = cst.executeUpdate();
			if (result > 0) {
				System.out.println("Successfully Inserted");
			}
			cst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
