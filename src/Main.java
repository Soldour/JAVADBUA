import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Main {

    public static void main(String[] args) {
        //   System.out.println("Hello World!");

        try {
            Connection conn=DriverManager.getConnection("jdbc:sqlite:/home/solomon/Documents/projects/Java/SQDB/src/Test.db");

            // Class.forName("org.sqlite.JDBC");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABlE IF NOT EXISTS contacts"+  // IF NOT EXITS WILL PREVENT FORM RECREATING THE TABLE
                    "(name TEXT, phone INTEGER, email TEXT)");
            statement.execute( "SELECT * FROM contacts");
            ResultSet results=statement.getResultSet();
            while ( results.next()){

                System.out.println(results.getString("name") +" "+
                        results.getInt("phone") + " "+
                        results.getString("email"));
            }
            results.close();

            statement.execute("INSERT INTO contacts (name, phone, email)"+
                    "VALUES('solomon', '123987456' , 'solabh@kpi.ua')");
            statement.execute("INSERT INTO contacts (name, phone, email)"+
                    "VALUES('Samrawit', '554987456' , 'samabh@kpi.ua')");
            statement.execute("INSERT INTO contacts (name, phone, email)"+
                    "VALUES('nati', '1788587456' , 'snatabh@kpi.ua')");
            statement.execute("INSERT INTO contacts (name, phone, email)"+
                    "VALUES('Abu', '19347456' , 'abu@kpi.ua')");
            statement.execute("UPDATE contacts SET phone =5252369 WHERE name='Abu'");
         /*   statement.execute("DELETE FROM contacts where name='Abu'");
            statement.execute("DELETE FROM contacts where name='solomon'");
            statement.execute("DELETE FROM contacts where name='Samrawit'");
            statement.execute("DELETE FROM contacts where name='nati'");
*/
            statement.close();
            conn.close();
        } catch (SQLException e) {

            System.out.println("Somethiing went wrong: " + e.getMessage());
        }


    }
}