package Demo.Profiles.Controller;

import Demo.Profiles.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/msg")
    public String getMessage() {
        return messageService.getMessage();
    }
}
