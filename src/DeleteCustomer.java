import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class DeleteCustomer {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	public static void main(String[] args) {
		try {
			CallableStatement cst = con.prepareCall("call delete_customer(?)");
			cst.setInt(1, 6);

			int result = cst.executeUpdate();
			if (result > 0) {
				System.out.println("Successfully Deleted");
			}
			cst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
