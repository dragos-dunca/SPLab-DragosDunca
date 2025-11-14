package ro.uvt.info.lab3.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.info.lab3.Components.ClientComponent;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final ApplicationContext context;

    @GetMapping("/one")
    public String one() {
        ClientComponent c = context.getBean(ClientComponent.class);
        return "Instance: " + c;
    }

    @GetMapping("/two")
    public String twogit() {
        ClientComponent c = context.getBean(ClientComponent.class);
        return "Instance: " + c;
    }
}
