package pl.itsqc.utils;



public class Collector {
    /**
     *
     * @return name of the current OS
     */
    public String getOSName(){
        String osName = System.getProperty("os.name");
        System.out.println(new StringBuilder("Working on ").append(osName));
        return osName;
    }
}
