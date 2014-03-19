package com.kokal.one;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionOneTest {

    @Mock private CartDao mockCartDao;
    @InjectMocks QuestionOne q1 = new QuestionOne();

    @Test
    public void testGetCustomersFromCartsOriginal() throws Exception {
        // setup
        Collection<Cart> carts = new ArrayList<Cart>();
        carts.add(new Cart(new Customer("123")));
        carts.add(new Cart(new Customer("234")));
        carts.add(new Cart(new Customer("123")));
        carts.add(new Cart(new Customer("234")));
        carts.add(new Cart(new Customer("345")));

        when(mockCartDao.findBy(any(Date.class))).thenReturn(carts);

        // execute
        Collection<Customer> customers = q1.getCustomersFromCarts(new Date());

        // verify
        assertEquals(5, customers.size());
    }

    @Test
    public void testGetCustomersFromCartsRefactored() throws Exception {
        // setup
        Collection<Cart> carts = new ArrayList<Cart>();
        carts.add(new Cart(new Customer("123")));
        carts.add(new Cart(new Customer("234")));
        carts.add(new Cart(new Customer("123")));
        carts.add(new Cart(new Customer("234")));
        carts.add(new Cart(new Customer("345")));

        when(mockCartDao.findBy(any(Date.class))).thenReturn(carts);

        // execute
        Collection<Customer> customers = q1.getCustomersFromCartsRefactored(new Date());

        // verify
        assertEquals(3, customers.size());
        // check that order is preserved
        Customer[] customerArray = customers.toArray(new Customer[]{});
        assertEquals("123", customerArray[0].getId());
        assertEquals("234", customerArray[1].getId());
        assertEquals("345", customerArray[2].getId());
    }
}
