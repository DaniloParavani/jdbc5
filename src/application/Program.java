package application;

import db.DB;
import db.DbIntegretyException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM department "
                    + "WHERE "
                    + "Id = ?");

            st.setInt(1, 5);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e){
            throw new DbIntegretyException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}



















