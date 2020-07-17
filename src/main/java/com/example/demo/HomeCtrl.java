package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeCtrl {
    public ArrayList<Guestbook> Guestbooks = new ArrayList<>();

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String addPost(Model model) {
        model.addAttribute("guestbook", new Guestbook());
        return "guestbook";
    }

}
//
//       @PostMapping("/list")
//      public String listPost(@ModelAttribute Guestbook guestbook, Model model) {
//        model.addAttribute("Guestbooks", Guestbooks);
//        return "list";
//    }
//
//}
//
//
//
//    public String listGuestbooks(Model model){
//       model.addAttribute("guestbook", new Guestbook());
//       return "guestbook";
//    }
//
//    @GetMapping("/add")
//    public String guestbookForm(Model model) {
//        model.addAttribute("guestbook", new Guestbook());
//        model.addAttribute("message", "New Employee");
//        return "guestbook";
//    }
//
//    @PostMapping("/list")
//    public String list(@ModelAttribute Guestbook guestbook, Model model){
//
//        allGuestbooks.add(guestbook);
//        return "redirect:/show";
//    }
//
//
//    @RequestMapping("/show")
//    public String showAll(Model model){
//
//        model.addAttribute("guestbooks", allGuestbooks);
//        return "list";
//    }
//
//    @RequestMapping("/update/{id}")
//    public String updateList(@PathVariable("id") long id, Model model){
//
//        Guestbook guestbook = new Guestbook();
//        for (Guestbook one : Guestbooks) {
//            if (one.getId() == id){
//                guestbook = one;
//                Guestbooks.remove(one);
//                break;
//            }
//        }
//
//        model.addAttribute("guestbook", guestbook);
//        model.addAttribute("message", "Update Guestbook");
//        return "guestbook";
//    }
//
//    @RequestMapping("/delete/{id}")
//    public String deleteList(@PathVariable("id") long id, Model model){
//
//        for (Guestbook guestbook : allGuestbooks) {
//            if (guestbook.getId() == id){
//                allGuestbooks.remove(guestbook);
//                break;
//            }
//        }
//
//        return "redirect:/show";
//    }
//
//
//}
//
//
//
//
//
////
//    @GetMapping("/guestbook")
//////    public String loadFormPage(Model model){
//////        model.addAttribute("guestbook", new Guestbook());
//////        return "guestbook";
//////    }
//////    @PostMapping("/guestbook")
//////    public String loadFromPage(@ModelAttribute Guestbook guestbook, Model model) {
//////        model.addAttribute("guestbook, guestbook");
//////        allGuestbooks.add(guestbook);
//////            return "redirect:/list";
//////        }
//////    @GetMapping("/list")
//////    public String list(@ModelAttribute Guestbook guestbook, Model model){
//////        model.addAttribute("allGuestbooks", allGuestbooks);
//////        return "list";
//////
//////
//////    }
//}