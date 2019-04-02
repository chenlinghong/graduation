package com.chenlinghong.graduation.repository.dao;


import com.chenlinghong.graduation.repository.domain.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartDaoTest {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Test
    public void insert() {
        ShoppingCart shoppingCart = new ShoppingCart(1L, 2L);
        int result = shoppingCartDao.insert(shoppingCart);
        Assert.assertEquals(1, result);
    }

    @Test
    public void listByUser() {
        List<ShoppingCart> shoppingCartList = shoppingCartDao.listByUser(2L, 0L, 10L);
        System.out.println(shoppingCartList);
    }

}