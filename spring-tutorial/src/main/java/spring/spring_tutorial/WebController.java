package spring.spring_tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.spring_tutorial.RequestParamNToDo.Todo;
import spring.spring_tutorial.ThymeleafNExpression.Info;
@Controller
public class WebController {
        List<Todo> todoList = new CopyOnWriteArrayList<>();

        @GetMapping("/")
        public String index() {
            System.out.println("indexxxxx");
            return "index.html";
        }
        @GetMapping("/about")
        public String about() {
            return "about";
        }
        @GetMapping("/hello")
        public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            // Model là một object của Spring Boot, được gắn vào trong mọi request.
            Model model) {
            
            model.addAttribute("name", name);
            return "hello";
        }
        @GetMapping("/profile")
        public String profile(Model model){
            List<Info> profile = new ArrayList<>();
            profile.add(new Info("fullname", "Tran Thanh Long"));
            profile.add(new Info("nickname", "TikTzuki"));
            profile.add(new Info("gmail", "tranphanthanhlong18@gmail.com"));

            model.addAttribute("myProfile", profile);
            
            return "profile";
        }

        @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
        public String addTodo(Model model){
            return "addTodo";
        }
        @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
        public String addTodo(@ModelAttribute Todo todo) {
            return "success";
        }

        @GetMapping("/listTodo")
        public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit){
            // Trả về đối tượng todoList.
            // Nếu người dùng gửi lên param limit thì trả về sublist của todoList
            model.addAttribute("todoList", limit != null ? todoList.subList(0, limit) : todoList);
        
            return "listTodo";
        }
}
