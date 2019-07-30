package cn.gmwenterprise.website.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

    private static String insertSqlInject(String sql, Object po) throws Exception {
        List<String> sqlParts = new ArrayList<>();
        List<String> paramNames = new ArrayList<>();
        List<String> paramValues = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < sql.length(); i++) {
            char temp = sql.charAt(i);
            if (end < start) {
                // param
                if (temp == ',' || temp == ')' || temp == ' ') {
                    end = i;
                    paramNames.add(sql.substring(start + 1, end));
                } else if (i == sql.length() - 1) {
                    paramNames.add(sql.substring(start + 1));
                }
            } else {
                // parts
                if (temp == ':') {
                    start = i;
                    sqlParts.add(sql.substring(end, start));
                } else if (i == sql.length() - 1) {
                    sqlParts.add(sql.substring(i));
                }
            }
        }
        Class<?> clazz = po.getClass();
        for (String paramName : paramNames) {
            Method method = clazz.getMethod("get" + paramName.substring(0, 1).toUpperCase() + paramName.substring(1));
            Object invoke = method.invoke(po);
            paramValues.add(type2SqlParamString(invoke));
        }
        StringBuilder resultSql = new StringBuilder();
        if (sqlParts.size() >= paramValues.size()) {
            for (int i = 0; i < paramValues.size(); i++) {
                resultSql.append(sqlParts.get(i)).append(paramValues.get(i));
            }
            if (sqlParts.size() - paramValues.size() == 1) {
                resultSql.append(sqlParts.get(paramValues.size()));
            }
            return resultSql.toString();
        }
        throw new Exception("注入失败");
    }

    private static String type2SqlParamString(Object type) {
        if (type instanceof String || type instanceof Character) {
            return "'" + type + "'";
        } else if (type instanceof Date) {
            return "to_date('yyyy-mm-dd hh24:mi:ss')";
        } else {
            return String.valueOf(type);
        }
    }

    static class User {
        private long id;
        private String userName;
        private int sex;
        private String remark;
        private String workAddress;
        private Date birth;

        public User(long id, String userName, int sex, String remark, String workAddress, Date birth) {
            this.id = id;
            this.userName = userName;
            this.sex = sex;
            this.remark = remark;
            this.workAddress = workAddress;
            this.birth = birth;
        }

        public long getId() {
            return id;
        }

        public String getUserName() {
            return userName;
        }

        public int getSex() {
            return sex;
        }

        public String getRemark() {
            return remark;
        }

        public String getWorkAddress() {
            return workAddress;
        }

        public Date getBirth() {
            return birth;
        }
    }

    public static void main(String[] args) throws Exception {
        User po = new User(1L, "夏夕空", 1, "备注", "重庆渝中", new Date());
        System.out.println(insertSqlInject("" +
                "insert into users(id, user_name, sex, remark, work_address, birth) " +
                "values (:id, :userName, :sex, :remark, :workAddress, :birth)",
            po));
        System.out.println(insertSqlInject("" +
                "     update users set user_name = :userName, " +
                "sex = :sex, remark =    :remark, work_address =      :workAddress, birth = :birth " +
                "where id = :id       ",
            po));
        System.out.println(insertSqlInject("" +
                "select user_name from users where " +
                "id = :id and user_name = :userName and birth = :birth",
            po));
    }
}
