package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Greeting greeting() {
        return new Greeting(123, "hello 123");
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestBody Greeting greeting) {

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, greeting.getContent()));
    }
}
