package pl.itsqc.utils;

import org.apache.log4j.Logger;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Collector {
    private final Logger logger = Logger.getLogger(Collector.class);
    /**
     *
     * @return name of the current OS
     */
    public String getOSName(){
        String osName = System.getProperty("os.name");
        logger.info(new StringBuilder("Working on ").append(osName));
        return osName;
    }
    /**
     *
     * @return current time
     */
    public String getTime(){
        ZoneId zoneId = ZoneId.of("Europe/Warsaw");
        ZonedDateTime zdt = ZonedDateTime.now( zoneId );
        LocalTime hour = zdt.toLocalTime();
        return hour.toString();
    }
}
