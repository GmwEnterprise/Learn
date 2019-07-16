package cn.gmwenterprise.website.generator;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public class DBHelp {

    private Connection conn;
    private DatabaseMetaData databaseMetaData;

    DBHelp() throws Exception {
        conn = DbHelper.getConnection();
        databaseMetaData = conn.getMetaData();
    }

    void getTableStruct(String tableName) throws SQLException {
        ResultSet trs = databaseMetaData.getTables(conn.getCatalog(), "%", tableName, null);
        List<TableStruct> tableStructs = new ArrayList<>();
        while (trs.next()) {
            TableStruct tableStruct = new TableStruct();
            tableStruct.setTableName(trs.getString("TABLE_NAME"));
            tableStruct.setTableComment(trs.getString("REMARKS"));
            tableStruct.setColumnList(getColumnStructList(tableStruct.getTableName()));
            tableStruct.setEntityName(nameConversion(tableStruct.getTableName(), 2));
            tableStruct.setEntityName(nameConversion(tableStruct.getTableName(), 1));
            tableStructs.add(tableStruct);
        }
        System.out.println(tableStructs);
    }

    List<ColumnStruct> getColumnStructList(String tableName) throws SQLException {
        ResultSet columns = databaseMetaData.getColumns(conn.getCatalog(), "%", tableName, "%");
        List<ColumnStruct> list = new ArrayList<>();
        while (columns.next()) {
            ColumnStruct struct = new ColumnStruct();
            struct.setColumnName(columns.getString("COLUMN_NAME"));
            struct.setColumnComment(columns.getString("REMARKS"));
            struct.setColumnType(columns.getString("TYPE_NAME"));
            struct.setColumnTypeNo(columns.getInt("DATA_TYPE"));
            struct.setFieldName(nameConversion(struct.getColumnName(), 1));

            list.add(struct);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        new DBHelp().getTableStruct("account");
    }

    private String nameConversion(String original, int type) {
        switch (type) {
            case 1:
                // table_name => tableName
                String[] strings = original.split("_");
                if (strings.length == 1) {
                    return original;
                }
                String collect = Arrays.stream(strings)
                        .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                        .collect(Collectors.joining());
                char[] chars = collect.toCharArray();
                chars[0] += 32;
                return String.valueOf(chars);
            case 2:
                // table_name => TableName
                String[] string2 = original.split("_");
                if (string2.length == 1) {
                    char[] chars1 = original.toCharArray();
                    chars1[0] -= 32;
                    return String.valueOf(chars1);
                }
                return Arrays.stream(string2)
                        .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                        .collect(Collectors.joining());
            default:
                return null;
        }
    }
}
