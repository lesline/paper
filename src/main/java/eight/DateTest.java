package eight;

import java.time.*;
import java.util.Date;
import java.util.TimeZone;

/**
 * 〈一句话功能简述〉<br>
 * 〈Data〉
 *
 * @author zhangshaolin
 * @create 2018/2/6
 * @since 1.0.0
 */
public class DateTest {
    public static void main(String[] args) {

        Date afterOrBeforeDayTime = new Date();
        long time = afterOrBeforeDayTime.getTime();
        long zero = time / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
        System.out.println(String.valueOf(zero));

        System.out.println("----------------");

        LocalDate localDate = LocalDate.now().minusDays(1);
        LocalDateTime localTime = localDate.atTime(LocalTime.MIN);
        ZonedDateTime zdt = localTime.atZone(ZoneId.systemDefault());
        Date date = Date.from(zdt.toInstant());

        System.out.println(date);
        System.out.println(date.getTime());
    }

}