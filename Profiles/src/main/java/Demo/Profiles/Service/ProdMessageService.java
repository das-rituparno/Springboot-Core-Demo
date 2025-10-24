package Demo.Profiles.Service;

import Demo.Profiles.MessageService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdMessageService implements MessageService {
    @Override
    public String getMessage() {
        return "Hello from PROD environment";
    }
}
