package com.efeozer.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

    public class Driver {

        private Driver() {
        }

        private static final InheritableThreadLocal<WebDriver> driverPool =
                new InheritableThreadLocal<>();

        public static WebDriver getDriver() {

            if (driverPool.get() == null) {

                String browser = ConfigurationReader.getProperty("browser");

                switch (browser.toLowerCase()) {

                    case "chrome":

                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--remote-allow-origins=*");

                        driverPool.set(new ChromeDriver(options));

                        break;

                    default:
                        throw new RuntimeException("Invalid browser name in configuration.properties");
                }

                driverPool.get().manage().window().maximize();

                driverPool.get().manage().timeouts()
                        .implicitlyWait(Duration.ofSeconds(10));
            }

            return driverPool.get();
        }

        public static void closeDriver() {

            if (driverPool.get() != null) {

                driverPool.get().quit();

                driverPool.remove();
            }
        }

    }

