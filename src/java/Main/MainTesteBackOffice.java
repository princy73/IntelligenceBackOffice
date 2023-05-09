package Main;

import daohibernate.HibernateDao;
import java.util.ArrayList;
import java.util.List;
import models.Article_Contenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTesteBackOffice {
    
    
    public static List<Article_Contenu> listArticle(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/resources/applicationContext.xml");
        HibernateDao dao = null;
        List<Article_Contenu> list = null;
        try{
            dao = context.getBean(HibernateDao.class);
            System.out.println(dao);
            list = new ArrayList<>();
            list = dao.findAll(Article_Contenu.class);
            
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getDescription());
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }return list;
    }
    
    public static Article_Contenu getArticleById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/resources/applicationContext.xml");
        HibernateDao dao = null;
        Article_Contenu ac = null;
        try{
            dao = context.getBean(HibernateDao.class);
            System.out.println(dao);
            ac = new Article_Contenu();
            ac = dao.findById(Article_Contenu.class, 1);
            System.out.println("h1 = " + ac.getTitre());
        }catch(Exception e){
            e.printStackTrace();
        }return ac;
    }
    
    public static void main(String[] args){
        listArticle();
    }
}
