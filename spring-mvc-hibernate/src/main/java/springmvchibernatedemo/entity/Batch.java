package springmvchibernatedemo.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author chiennghe
 */
//@Entity
//@org.hibernate.annotations.Entity
//@Table(name = "BATCH")
public class Batch {
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Column(name = "BATCH_ID")
    private Integer id;
//    @Column(name = "BATCH_NAME")
    private String name;

//    @OneToMany(mappedBy = "batch", cascade = CascadeType.PERSIST)
//    @PrimaryKeyJoinColumn
    private Set<Student> students;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Student> getStudents() {
        return students;
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
