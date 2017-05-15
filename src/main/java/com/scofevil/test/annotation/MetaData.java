package com.scofevil.test.annotation;

import lombok.Data;

@Data
public class MetaData {
    @Feild(id = 1, name = "slary")
    public String salary;
    @Feild(id = 2, name = "sex")
    public String sex;
    @Feild(id = 3, name = "age")
    public int    age;
}
