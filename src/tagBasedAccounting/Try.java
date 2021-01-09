package tagBasedAccounting;

import java.sql.*;

public class Try {
    public static void main(String[] args){
        SQL sql = new SQL();
        sql.listTables();
    }




    /*public void selectAll(){
        String sql = "SELECT id, name, typ FROM Tags";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("typ"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/


    private static class SQL{

        private Connection db = null;

        public SQL(){
            connect();
        }

        private void connect() {
            // SQLite connection string
            String url = "jdbc:sqlite:./data/buchhaltung_test.sqlite3";
            try {
                db = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        

        void listTables(){
            String sql = "select name from sqlite_master where type = 'table' and name not like 'sqlite_%'";
            try(Statement stmt  = db.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
