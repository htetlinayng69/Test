import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class UpdateCustomer {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public static void main(String[] args) {
		try {
			CallableStatement cst = con.prepareCall("call update_customer(?, ?)");
			cst.setInt(1, 6);
			cst.setString(2, "Npt");

			int result = cst.executeUpdate();
			if (result > 0) {
				System.out.println("Successfully Updated");
			}
			cst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
