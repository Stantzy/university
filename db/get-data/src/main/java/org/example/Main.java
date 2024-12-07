package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JavaToMySQL.CheckConnection();

        ArrayList<String> tables = JavaToMySQL.GetTables();
        ArrayList<ArrayList<Object>> result = new ArrayList<>();

        for (String s: tables) {
            ArrayList<Object> obj = JavaToMySQL.ReadTable(s);
            result.add(obj);
        }

    }
}
