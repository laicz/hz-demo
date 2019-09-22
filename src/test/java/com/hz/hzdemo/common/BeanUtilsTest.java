package com.hz.hzdemo.common;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学习common包下的BeanUtils类
 * Create by zhoumingbing on 2019-08-28
 */
public class BeanUtilsTest {

    @Test
    public void populateTest() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "name1");
        map.put("password", "password1");
        List<Order> orders = ImmutableList.of(new Order("product1"), new Order("product2"));
        map.put("orders", orders);
        BeanUtils.populate(user, map);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class User {
        private String name;
        private String password;
        private List<Order> orders;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }
    }

    @Data
    @AllArgsConstructor
    class Order {
        private String product;

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }
    }

}
