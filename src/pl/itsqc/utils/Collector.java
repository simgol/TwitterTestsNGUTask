package pl.itsqc.utils;


import org.apache.log4j.Logger;

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
}
