package spring.spring_tutorial;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Girl {
	private String name;
	
	// Đánh dấu để Spring inject một đối tượng Outfit vào đây
	@Autowired
	Outfit outfit;
	
	// Spring sẽ inject outfit thông qua Constructor trước
    public Girl() { }
    public Girl(String name) {
    	this.name = name;
    }
	public Girl(Outfit outfit) {
		this.outfit = outfit;
	}
	// Nếu không tìm thấy Constructor thoả mãn, nó sẽ thông qua setter
	public void setOutfit(Outfit outfit) {
		this.outfit = outfit;
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("\t>> Post");
	}
	@PreDestroy
	public void preDestroy() {
		System.out.println("\t>> Pre");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "zzzz";
	}
}
