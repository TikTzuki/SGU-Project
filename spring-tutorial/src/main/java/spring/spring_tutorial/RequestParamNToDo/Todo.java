package spring.spring_tutorial.RequestParamNToDo;

import lombok.Data;

@Data
public class Todo {
    private String title;
    private String detail;

    public Todo(){}

    public Todo(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
}
