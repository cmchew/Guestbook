package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeCtrl {
    public ArrayList<Post> book = new ArrayList<>();

    //View homepage
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    //Add a new post
    @GetMapping("/newpost")
    public String add(Model model) {
        model.addAttribute("post", new Post());
        return "newpost";
    }

    //Get a listing of posts
    @PostMapping("/newpost")
    public String loadFromPage(@ModelAttribute Post post, Model model) {
        model.addAttribute("post", post);
        book.add(post);
        return "redirect:/listpost";
    }
    //Add guest posts to list of posts
    @GetMapping("/listpost")
    public String listPost(@ModelAttribute Post post, Model model) {
        model.addAttribute("book", book);
        return "listpost";
    }

//    //Map viewpost back to list post
//    @GetMapping("/viewpost")
//    public String viewSinglePost(@ModelAttribute Post post, Model model) {
//        model.addAttribute("post", post);
//        model.addAttribute("book", book);
//        return "redirect:/listpost";
//    }

    //View single post
    @RequestMapping("/view/{id}")
    public String viewBookPost(@PathVariable("id") long id, Model model) {
        Post post = new Post();
        for (Post one : book) {
            if (one.getId() == id) {
                post = one;
//                book.remove(one);
                break;
            }
        }
        model.addAttribute("post", post);
        return "viewpost";
    }
    // Update Post
    @RequestMapping("/update/{id}")
    public String updateBookPost(@PathVariable("id") long id, Model model) {
        Post post = new Post();
        for (Post one : book) {
            if (one.getId() == id) {
                post = one;
                book.remove(one);
                break;
            }
        }
        model.addAttribute("post", post);
        model.addAttribute("book", book);
        return "newpost";
    }
    // Delete post
    @RequestMapping("/delete/{id}")
    public String deleteBookPost(@PathVariable("id") long id, Model model) {
//        Post post = new Post();
        for (Post post : book) {
            if (post.getId() == id) {
                book.remove(post);
                break;
            }
        }

        return "redirect:/newpost";
    }

}

