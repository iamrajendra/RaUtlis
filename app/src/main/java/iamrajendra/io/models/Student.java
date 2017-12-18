package iamrajendra.io.models;

import android.support.annotation.NonNull;

import iamrajendra.io.RaUtils.Rpredicatable;

/**
 * Created by gwl on 18/12/17.
 */

public class Student  extends Rpredicatable {
  public  String name;
  public Integer age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
