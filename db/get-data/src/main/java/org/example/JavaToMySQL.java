package org.example;

import org.example.tables.*;
import java.sql.*;
import java.util.ArrayList;


/*
    The class of the program responsible for program's
     interaction with the database.
 */

public class JavaToMySQL {

    private static final String url = Config.getUrl();
    private static final String username = Config.getUsername();
    private static final String password = Config.getPassword();

    public static void CheckConnection(){
        // Check connection to the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static ArrayList<String> GetTables(){
        // Output available tables from the database to the console
        ArrayList<String> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password)){

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SHOW TABLES");
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }

        } catch (SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return result;
    }

    public static ArrayList<Object> ReadTable(String table){
        // Output the table to the console

        try (Connection connection = DriverManager.getConnection(url, username, password)){

            Statement statement = connection.createStatement();

            ArrayList<Object> result = new ArrayList<>();

            switch (table){
                case ("визиты"):
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM визиты");
                    while(resultSet.next()){
                        Visit v = new Visit();
                        v.setId(resultSet.getInt(1));
                        v.setDate(resultSet.getDate(2));
                        v.setClientId(resultSet.getInt(3));
                        result.add(v);
                    }
                    break;
                case("клиенты"):
                    ResultSet resultSet1 = statement.executeQuery("SELECT * FROM клиенты");
                    while(resultSet1.next()){
                        Client c = new Client();
                        c.setId(resultSet1.getInt(1));
                        c.setFirstName(resultSet1.getString(2));
                        c.setLastName(resultSet1.getString(3));
                        result.add(c);
                    }
                    break;
                case("мастера"):
                    ResultSet resultSet2 = statement.executeQuery("SELECT * FROM мастера");
                    while(resultSet2.next()){
                        Master m = new Master();
                        m.setId(resultSet2.getInt(1));
                        m.setFirstName(resultSet2.getString(2));
                        m.setLastName(resultSet2.getString(3));
                        result.add(m);
                    }
                    break;
                case("услуги"):
                    ResultSet resultSet3 = statement.executeQuery("SELECT * FROM услуги");
                    while(resultSet3.next()){
                        Service s = new Service();
                        s.setId(resultSet3.getInt(1));
                        s.setService(resultSet3.getString(2));
                        s.setPrice(resultSet3.getFloat(3));
                        result.add(s);
                    }
                    break;
                case("чеки"):
                    ResultSet resultSet4 = statement.executeQuery("SELECT * FROM чеки");
                    while(resultSet4.next()){
                        Receipt r = new Receipt();
                        r.setId(resultSet4.getInt(1));
                        r.setTime(resultSet4.getTime(2));
                        r.setIdVisit(resultSet4.getInt(3));
                        r.setIdService(resultSet4.getInt(4));
                        r.setIdMaster(resultSet4.getInt(5));
                        result.add(r);
                    }
                    break;
            }
            return result;
        } catch (SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
