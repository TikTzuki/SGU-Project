package spring.spring_tutorial;

import spring.spring_tutorial.AppCongfigNValue.DatabaseConnector;
import spring.spring_tutorial.others.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //SpringApplication.run(App.class, args);
    	// ApplicationContext chính là container, chứa toàn bộ các Bean
    	 //System.out.println("> Trước khi IoC Container được khởi tạo");
    	ApplicationContext context = SpringApplication.run(App.class, args);
    	/* LifeCircle
    	System.out.println("> Sau khi IoC Container được khởi tạo");
        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.
        Girl girl = context.getBean(Girl.class);
        System.out.println("Girl instance: " + girl);
        System.out.println("> Trước khi IoC Container destroy Girl");
        ((ConfigurableApplicationContext) context).getBeanFactory().destroyBean(girl);
        System.out.println("> Sau khi IoC Container destroy Girl");
        System.out.println("Girl Outfit: " + girl.outfit);
        girl.outfit.wear();
        */
    	
    	/* ComponentsScan
    	Girl girl = context.getBean(Girl.class);
    	System.out.println("Bean " + girl.toString());
    	
    	OtherGirl otherGirl = context.getBean(OtherGirl.class);
    	System.out.println("Bean " + otherGirl.toString());
    	*/

    }
}