package springmvcdemo.monitoring;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author chiennghe
 */
@Component
public class BuildInfoContributor implements InfoContributor{
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("buildInfo", Map.of("build.version", "2.0.0.0"));
    }
}
