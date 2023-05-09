package controller;

import daohibernate.HibernateDao;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.Admin;
import models.Article_Contenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BackOfficeController {

    @Autowired
    HibernateDao dao;
    
    //Fonction pour lister dans FrontOffice
    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String getListArticlesFront(Model model) {
        List<Article_Contenu> list = null;
        try {
            list = new ArrayList<>();
            list = dao.findAll(Article_Contenu.class);
            model.addAttribute("listArticle", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "news";
    }
    
    //Fonction pour avoir l'idArticle
    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public String getArticleOne(@PathVariable("id") int idArticle, Model model) {
        Article_Contenu article = dao.findById(Article_Contenu.class, idArticle);
        model.addAttribute("article", article);
        return "article";
    }
    
    @RequestMapping(value = "/insertcontenu", method = RequestMethod.GET)
    public String pageAddArticleContenu(Model model) {
        return "ajoutcontenu";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String pageindexboss(Model model) {
        return "loginn";
    }

    @RequestMapping(value = "/afficherArticlesContenu", method = RequestMethod.GET)
    public String afficherArticlesContenu(Model model) {
        List<Article_Contenu> list = null;
        try {
            list = new ArrayList<>();
            list = dao.findAll(Article_Contenu.class);
            model.addAttribute("listArticleContenu", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "actualite";
    }

    @RequestMapping(value = "/addArticleContenu", method = RequestMethod.POST)
    public RedirectView addArticleContenu(HttpServletRequest request, @ModelAttribute Article_Contenu article_contenu) {
        String titre = "";
        String description = "";
        Date date = null;
        try {
            titre = request.getParameter("titre");
            description = request.getParameter("description");
            date = Date.valueOf(request.getParameter("date"));
            article_contenu = new Article_Contenu();
            article_contenu.setTitre(titre);
            article_contenu.setDescription(description);
            article_contenu.setDate(date);
            dao.create(article_contenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("/afficherArticlesContenu", true);
    }

    @RequestMapping(value = "/modificationTitreContenu/{id}", method = RequestMethod.POST)
    public String modificationArticleContenu(HttpServletRequest request, @PathVariable("id") int idArticle_contenu) {
        String titre = "";
        String description = "";
        Date date = null;
        try {
            titre = request.getParameter("titre");
            description = request.getParameter("description");
            Article_Contenu article_contenu = dao.findById(Article_Contenu.class, idArticle_contenu);
            article_contenu.setTitre(titre);
            article_contenu.setDescription(description);
            dao.update(article_contenu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/afficherArticlesContenu";
    }

    @RequestMapping(value = "/modifierArticles/{id}", method = RequestMethod.GET)
    public String afficherFormulaireModification(@PathVariable("id") int idArticle, Model model) {
        Article_Contenu article = dao.findById(Article_Contenu.class, idArticle);
        model.addAttribute("article", article);
        return "modifierArticle";
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView loginBoss(HttpServletRequest request, @ModelAttribute Admin admin, Model model) {
        String email = null;
        String password = null;
        int idAdmin = 1;
        try {
            email = request.getParameter("email");
            password = request.getParameter("password");
            admin = new Admin();
            admin = dao.findById(Admin.class, idAdmin);
            if (email.equals("Boss@gmail.com") && password.equals("boss")) {
                return new RedirectView("/afficherArticlesContenu", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("/index", true);
    }
}
