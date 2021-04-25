package selenium_core;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(String BROWSER) {
        DriverManager driverManager;

        switch (BROWSER) {
            case "FIREFOX":
                driverManager = new FirefoxDriverManager();
                break;

            case "CHROME":
            default:
                driverManager = new ChromeDriverManager();
        }
        return driverManager;
    }

}
