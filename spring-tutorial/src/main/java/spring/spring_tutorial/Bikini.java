package spring.spring_tutorial;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Bikini implements Outfit{
	public void wear() {
		System.out.println("Mac bikini");
	};
}
