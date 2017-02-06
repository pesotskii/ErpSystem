package erpsystem.controller;

import erpsystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    Hello hello;
    @Autowired
    Bye bye;
    @Autowired
    HelloAlex helloAlex;
    @Autowired
    CreateTable createTable;
    @Autowired
    CreateProjects createProjects;
//    @Autowired
//    Zhilkin_bean helloZhilkin;
    @Autowired
    TableManagers tableManagers;


    @RequestMapping("/")
    public String hello(Model model){
        model.addAttribute("hello", hello.getHelloMessage());
        model.addAttribute("bye", bye.getBye());
        return "hello";
    }

    @RequestMapping("/TruninAlex")
    public String helloAlex(Model model){
        model.addAttribute("helloAlex", helloAlex.getMessage());
        return "helloAlex";
    }

//    @RequestMapping("/ZhilkinAlex")
//    public  String Zhilkin(Model erpsystem.model){
//        erpsystem.model.addAttribute("helloZhilkin", helloZhilkin.getMessage());
//        return "Zhilkin_page";
//    }

    @RequestMapping("/confidential/page")
    public String secureTable(Model model){
        model.addAttribute("secure", "This is a very secure place");
        return "secure";
    }

    @RequestMapping(value = {"hello/{name}"}, method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("encode");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(name));
        return modelAndView;
    }

    @RequestMapping("/create")
    public String createTableCompany(Model model) {
        model.addAttribute("create", createTable.tableCreation());
        return "create";
    }

    @RequestMapping("/insert")
    public String insertInTableCompany(Model model) {
        model.addAttribute("create", createTable.insert());
        return "create";
    }

    @RequestMapping("/allCompany")
    public String selectAllCompany(Model model) {
        List<Company> componies = createTable.selectAll();
        model.addAttribute("allCompany", componies);
        return "allCompany";
    }

    @RequestMapping("/createPr")
    public String createTableProjects(Model model) {
        model.addAttribute("create", createProjects.tableCreation());
        return "create";
    }

    @RequestMapping("/insertPr")
    public String insertInTableProjects(Model model) {
        model.addAttribute("create", createProjects.insert());
        return "create";
    }

    @RequestMapping("/allPr")
    public String selectAllProjects(Model model) {
        List<Project> projects = createProjects.selectAll();
        model.addAttribute("allProjects", projects);
        return "allProjects";
    }

    @RequestMapping(value = {"remove/{name}"}, method = RequestMethod.GET)
    public ModelAndView removePr(@PathVariable("name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("rmResult");
        modelAndView.addObject("result", createProjects.rmProject(name));
        return modelAndView;
    }


    @RequestMapping("/createManagers")
    public String createTableManagers(Model model) {
        model.addAttribute("create", tableManagers.createTable());
        return "create";
    }

    @RequestMapping("/insertManagers")
    public String insertInTableManagers(Model model) {
        model.addAttribute("create", tableManagers.insertManagers());
        return "create";
    }

    @RequestMapping("/selectManagersByOffice")
    public String selectManagersByOffice(@ModelAttribute Office office, Model model) {
        List<Manager> managers = tableManagers.selectManagersByOffice(office);
        model.addAttribute("managers", managers);
        return "managersTable";
    }

    @RequestMapping("/selectManagers")
    public String selectManagers(Model model) {
        List<Manager> managers = tableManagers.selectManagers();
        model.addAttribute("managers", managers);
        return "managersTable";
    }

    @RequestMapping("/rest")
    public String rest() {
        return "rest";
    }


    @RequestMapping("/restOffice")
    public String restOffice() {
        return "restManagersTable";
    }

}
