package cn.gmwenterprise.website.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class DateUtils {

    // 获取系统时间

    public static LocalDate getSysLocalDate() {
        return LocalDate.now();
    }

    public static LocalTime getSysLocalTime() {
        return LocalTime.now();
    }

    public static LocalDateTime getSysLocalDateTime() {
        return LocalDateTime.now();
    }
}
