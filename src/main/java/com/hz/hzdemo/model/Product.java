package com.hz.hzdemo.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Product {
    private String id;
    private String name;
    private String catagory;

}
