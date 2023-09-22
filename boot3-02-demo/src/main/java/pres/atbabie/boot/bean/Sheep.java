package pres.atbabie.boot.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sheep")
public class Sheep {
    private String name;
    private Long id;
    private Integer age;

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
