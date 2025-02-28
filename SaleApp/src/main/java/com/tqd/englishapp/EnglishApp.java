/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tqd.englishapp;

import com.tqd.pojo.Category;
import com.tqd.services.ProductServices;

import java.sql.SQLException;
import org.hibernate.Session;


/**
 *
 * @author admin
 */
public class EnglishApp {

    public static void main(String[] args) throws SQLException {

        ProductServices ps = new ProductServices();
        ps.getProducts().forEach(p -> System.out.println(p.getName()));
        

        
        
        
//        Scanner sc = new Scanner(System.in);
//        QuestionServices s = new QuestionServices();
//        s.getQuestions(2).forEach(x -> {
//            System.out.println(x);
//            
//            try {
//                List<Choice> c = s.getChoices(x.getId());
//                for (int i = 0; i< c.size(); i++)
//                    System.out.printf("%d. %s\n", i + 1, c.get(i));
//                
//                System.out.print("Lua chon la : ");
//                
//                int idx = sc.nextByte();
//                
//                if(c.get(idx - 1).isCorrect() == true){
//                    System.out.println("Exactly!");
//                }else System.out.println("WrongLy!");
//            
//            } catch (SQLException ex) {
//                Logger.getLogger(EnglishApp.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//
//        StatsServices sr = new StatsServices();
//        sr.getQuestionCategoryChoice(4).forEach(s -> System.out.printf("%d - %s - %d\n", s[0], s[1], s[2] ));
    }
}
