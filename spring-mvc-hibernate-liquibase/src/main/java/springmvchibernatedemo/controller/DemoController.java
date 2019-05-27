package springmvchibernatedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springmvchibernatedemo.business.SchoolManager;
import springmvchibernatedemo.model.SchoolModel;
import springmvchibernatedemo.model.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chiennghe
 */
@Controller
public class DemoController {
    @Autowired
    private SchoolManager schoolManager;

    @RequestMapping(value="/viewBatch")
    public ModelAndView viewBatch(@ModelAttribute("model") SchoolModel schoolModel){
        ModelAndView mav = new ModelAndView("index", "model", schoolModel);
        schoolManager.getBatchInfo(schoolModel);
        return mav;
    }

    /*@GetMapping(value="/home")
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        Student student = new Student();
        student.setName("Coder Tien Sinh");

        List<String> books = new ArrayList<String>();
        books.add("book1");
        books.add("book2");
        student.setBooks(books);

        ModelAndView mav = new ModelAndView("index", "model", student);

        return mav;
    }

    @PostMapping(value="/submitStudentInfo")
    public ModelAndView submitStudentInfo(ModelMap model, @ModelAttribute("model") Student student){

        List<String> listBooks = student.getBooks();
        boolean bookSameName = checkSameBookName(listBooks);

        String message = "Update success !!!";
        if(bookSameName){
            message = "Books must have different name !!!";
        }
        model.addAttribute("message", message);

        ModelAndView mav = new ModelAndView("index", "model", student);
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
    }*/
}
