/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HibernateDao;
import javax.servlet.http.HttpServletRequest;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Fanjava
 */
@Controller
public class RegionController {
    @Autowired
    HibernateDao dao;
    
    @RequestMapping(value="/regions")
    public ModelAndView formulaireCommune(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("regions");
        mv.addObject("regions",dao.findAll(Region.class));
        return mv;
    }
    
    @RequestMapping(value="/")
    public String Index(Model model,HttpServletRequest req){
        model.addAttribute("test", "test");
        return "Home";
    }
    
    @RequestMapping(value="/Login")
    public String Login(Model model,HttpServletRequest req){
        String email=req.getParameter("email");
        String pwd=req.getParameter("email");
        return "Login";
    }
}
