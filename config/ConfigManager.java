package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class ConfigManager {
    public static Map<String, String> load(String path) {
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream(path)) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config: " + e.getMessage());
        }

        return Map.of(
            "stripe_endpoint", props.getProperty("stripe_endpoint"),
            "paypal_endpoint", props.getProperty("paypal_endpoint")
        );
    }
}
