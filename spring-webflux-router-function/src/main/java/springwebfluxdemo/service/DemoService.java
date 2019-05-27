package springwebfluxdemo.service;

import org.springframework.stereotype.Service;
import springwebfluxdemo.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chiennghe
 */
@Service
public class DemoService {
    public Map<String, Object> home(){

        Student student = new Student();
        student.setName("Coder Tien Sinh");

        List<String> books = new ArrayList<String>();
        books.add("book1");
        books.add("book2");
        student.setBooks(books);

        return Map.of("model", student);
    }

    public Map<String, Object> submitStudentInfo(Student student){
        List<String> listBooks = student.getBooks();
        boolean bookSameName = checkSameBookName(listBooks);

        String message = "Update success !!!";
        if(bookSameName){
           message = "Books must have different name !!!";
        }

        return Map.of("model", student, "message", message);
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