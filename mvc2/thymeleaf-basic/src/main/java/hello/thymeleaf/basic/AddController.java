package hello.thymeleaf.basic;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static hello.thymeleaf.basic.BasicController.*;

@Controller
public class AddController {

    @GetMapping("/variablePractice")
    public String variablePractice(Model model) {
        model.addAttribute("message", "안녕 스프링");
        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User("홍길동", 10));
        userArrayList.add(new User("김길동", 20));
        userArrayList.add(new User("이길동", 30));

        model.addAttribute("users", userArrayList);

        return "varablePractice";
    }

    @GetMapping("/checkbox")
    public String checkbox(Model model) {
        addMembers(model);
        return "checkedPractice";
    }

    @PostMapping("/checkbox")
    public String checkboxPost(ModelAttribute Member, Model model) {

        addMembers(model);
        return "checkedPractice";
    }

    @GetMapping("/listPractice")
    public String listPractice(Model model) {
        addUsers(model);
        return "listPractice";
    }

    @PostMapping("/listPractice")
    public String listPracticePost(@RequestParam("username") String username,
                                   @RequestParam("age") int age) {

        System.out.println(">>>>>");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "redirect:/" + "basic/text-basic";
    }

    @GetMapping("/listOutputPractice")
    public String listOutputPractice(Model model) {
        addItems(model);
        return "listOutputPractice";
    }

    @PostMapping("/listOutputPractice")
    public String listOutputPracticePost(@RequestParam("selectedItems") List<Integer> selectedItems) {
        System.out.println(">>>>>");
        System.out.println("selectedItems = " + selectedItems);

        return "basic/text-basic";
    }

    @GetMapping("/form")
    public String home(Model model) {
        PersonsCreationDto personsForm = new PersonsCreationDto();

        personsForm.addPerson(new Person());
        personsForm.addPerson(new Person());
        personsForm.addPerson(new Person());
        model.addAttribute("form", personsForm);

        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("persons") ArrayList<Person> persons,
                      Model model) {

        return "redirect:/form";
    }


    private void addUsers(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User("UserA", 10));
        list.add(new User("UserB", 20));
        list.add(new User("UserC", 30));
        list.add(new User("UserD", 40));

        model.addAttribute("users", list);
    }

    private void addMembers(Model model) {
        List<Member> list = new ArrayList<>();
        list.add(new Member("MemberA", 10, true));
        list.add(new Member("MemberB", 20, false));
        list.add(new Member("MemberC", 30, true));

        model.addAttribute("members", list);
    }

    private void addItems(Model model) {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, "itemA"));
        list.add(new Item(2, "itemB"));
        list.add(new Item(3, "itemC"));

        model.addAttribute("items", list);
    }


    @Data
    static class Member {
        private String name;
        private int age;
        private Boolean isSelected;

        public Member(String name, int age, Boolean isSelected) {
            this.name = name;
            this.age = age;
            this.isSelected = isSelected;
        }
    }

    @Data
    static class Item {
        private int id;
        private String name;

        public Item(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Data
    static public class Person {
        private String name;
        private int age;
        // getters and setters

        public Person() {}

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    static public class PersonsCreationDto {
        private List<Person> persons;

        public PersonsCreationDto() {
            this.persons = new ArrayList<>();
        }

        public PersonsCreationDto(List<Person> persons) {
            this.persons = persons;
        }

        public List<Person> getPersons() {
            return persons;
        }

        public void setPersons(List<Person> persons) {
            this.persons = persons;
        }

        public void addPerson(Person person) {
            this.persons.add(person);
        }
    }
}
