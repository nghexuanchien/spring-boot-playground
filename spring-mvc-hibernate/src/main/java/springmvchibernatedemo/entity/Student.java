package springmvchibernatedemo.entity;

import javax.persistence.*;

/**
 * @author chiennghe
 */
//@Entity
//@org.hibernate.annotations.Entity
//@Table(name = "STUDENT")
public class Student {
//    @Id
//    @Column(name = "STUDENT_ID")
    private String id;

//    @Column(name = "STUDENT_NAME")
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "BATCH_ID")
    private Batch batch;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Batch getBatch() {
        return batch;
    }
    public void setBatch(Batch batch) {
        this.batch = batch;
    }
}
