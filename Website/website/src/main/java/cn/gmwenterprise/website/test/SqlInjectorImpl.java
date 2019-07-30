package cn.gmwenterprise.website.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SqlInjectorImpl implements SqlInjector {

    @Override
    public String inject(String origin, Object instance) throws Exception {
        if (origin.contains("?")) {
            String trim = origin.trim();
            if ("insert".equals(trim.substring(0, 6).toLowerCase())) {
                // insert语句
                String tableStart = trim.substring(10);
                String tableName = null;
                int a = -1;
                String[] columns = null;
                List<String> results = new ArrayList<>();
                for (int i = 0; i < tableStart.length(); i++) {
                    if (tableStart.charAt(i) == '(') {
                        tableName = tableStart.substring(0, i);
                        a = i + 1;
                    }
                    if (tableStart.charAt(i) == ')') {
                        columns = tableStart.substring(a, i).split(",");
                    }
                }
                if (columns != null) {
                    for (String column : columns) {
                        String s = "get" + case2Camel(column, true);
                        Method method = instance.getClass().getMethod(s);
                        Object result = method.invoke(instance);
                        results.add(field2StringParam(result));
                    }
                }
            }
            // TODO 将结果集插入语句中
        } else {

        }
        return null;
    }

    private String field2StringParam(Object result) {
        return null;
    }

    private String camel2Case(String string) {
        List<String> strings = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i)) && i != 0) {
                strings.add(string.substring(start, i).toLowerCase());
                start = i;
            } else if (i == string.length() - 1) {
                strings.add(string.substring(start).toLowerCase());
            }
        }
        return String.join("_", strings);
    }

    private String case2Camel(String string, boolean startWithUppercase) {
        String collect = Arrays.stream(string.split("_"))
            .map(str -> {
                if (str.length() == 1) {
                    return str;
                }
                return str.substring(0, 1).toUpperCase() + str.substring(1);
            })
            .collect(Collectors.joining());
        return startWithUppercase ? collect : collect.substring(0, 1).toLowerCase() + collect.substring(1);
    }

    public static void main(String[] args) {
        SqlInjectorImpl sqlInjector = new SqlInjectorImpl();
        System.out.println(sqlInjector.case2Camel("tbm_main_inst", true));
        System.out.println(sqlInjector.case2Camel("tbm_main_inst", false));

        System.out.println(sqlInjector.camel2Case("TbmMainInst"));
        System.out.println(sqlInjector.camel2Case("tbmMainInst"));
    }

    public static void main1(String[] args) throws Exception {
        String sql1 = "insert into user (id, user_name, sex, remark) values (?, ?, ?, ?)";
        String sql2 = "insert into user (id, user_name, sex, remark) values (:id, :userName, :sex, :remark)";
        SqlInjector injector = new SqlInjectorImpl();
        System.out.println(injector.inject(sql1, new User(1, "Gmw", "男", "无")));
        System.out.println(injector.inject(sql2, new User(2, "夏夕空", "男", "有！！！")));
    }
}
