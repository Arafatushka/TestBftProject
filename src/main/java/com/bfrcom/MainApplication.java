package com.bfrcom;

import com.bfrcom.DAO.BookDAO;
import com.bfrcom.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MainApplication {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args){

        SpringApplication.run(MainApplication.class, args);


        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        /*BookDAO bookDAO = context.getBean("BookDAOImplement", BookDAO.class);

        for(Book b : bookDAO.findAll())
            System.out.println(b);*/
    }
}
