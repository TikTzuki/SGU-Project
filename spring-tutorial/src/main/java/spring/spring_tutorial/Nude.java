package spring.spring_tutorial;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Nude implements Outfit{
public void wear() {
	System.out.println("Nhuy is naked");
}
}
