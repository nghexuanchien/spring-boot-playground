package springmvcdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import springmvcdemo.model.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chiennghe
 */
@Controller
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping(value="/home")
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        logger.debug("Requesting to /home");
        Student student = new Student();
        student.setName("Coder Tien Sinh");

        List<String> books = new ArrayList<String>();
        books.add("book1");
        books.add("book2");
        student.setBooks(books);

        ModelAndView mav = new ModelAndView("index", "model", student);
        logger.debug("/home returns to the view");
        return mav;
    }

    @PostMapping(value="/submitStudentInfo")
    public ModelAndView submitStudentInfo(ModelMap model, @ModelAttribute("model") Student student){
        logger.debug("Requesting to /submitStudentInfo");
        List<String> listBooks = student.getBooks();
        boolean bookSameName = checkSameBookName(listBooks);

        String message = "Update success !!!";
        if(bookSameName){
            message = "Books must have different name !!!";
        }
        model.addAttribute("message", message);

        ModelAndView mav = new ModelAndView("index", "model", student);
        logger.debug("/submitStudentInfo returns to the view");
        return mav;
    }

    private boolean checkSameBookName(List<String> listBooks) {
        for(int i =0; i<listBooks.size(); i++){
            String firstBookName = listBooks.get(i);
            for(int j = i+1; j<listBooks.size(); j++){
                String secondBookName = listBooks.get(j);
                if(firstBookName.equalsIgnoreCase(secondBookName)){
                    return true;
                }
            }
        }
        return false;
    }
}
