import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriver {                                                     //allows you to test the site on saucelabs.com

    static public RemoteWebDriver getRemoteDriver(){
        final String USERNAME = "romanrozborsky";                               //login on saucelabs
        final String ACCESS_KEY = "b7481b3f-3d3e-48a0-b5b0-8d35cf3657b0";       //key, given on saucelabs

        try {
            DesiredCapabilities capabilities = DesiredCapabilities.safari();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "safari");
//            capabilities.setCapability(CapabilityType.VERSION, "51.0");
            capabilities.setCapability(CapabilityType.PLATFORM, "MAC");

            return new RemoteWebDriver(
                    new URL("http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failure forming the URL to create a web driver", e);
        }
    }
}
