package jdbc;

import lombok.AllArgsConstructor;
import lombok.Builder;


public class Employee {
    Integer id;
    String name;
    String lastName;
    String job;

   private Employee(Integer id, String name, String lastName, String job) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.job = job;
    }

    public static class Builder{
       private Integer id;
        private String name;
        private String lastName;
        private String job;

        public Builder() {
        }

        public Employee build() {
            return new Employee(id, name, lastName, job);
        }
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder job(String job) {
            this.job = job;
            return this;
        }
    }


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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
