package com.kokal.one;

import java.util.*;

public class QuestionOne {

    private CartDao cartDao;


    public Collection<Customer> getCustomersFromCartsRefactored(final Date createdOn) {
        assert (createdOn != null) : "param createdOn cannot be null";

        final Set<Customer> customers = new LinkedHashSet<Customer>(); // this line changed

        final Collection<Cart> carts = cartDao.findBy(createdOn);
        for (final Cart cart : carts) {
            customers.add(cart.getCustomer());
        }

        return customers;
    }

    /**
     * #1
     * This method currently returns a Collection that contains duplicate Customers,
     * refactor it to return a Collection containing unique results.
     * Can you also retain the insertion order on the data collection?
     * @param createdOn
     * @return
     */
    public Collection<Customer> getCustomersFromCarts(final Date createdOn) {
        assert (createdOn != null) : "param createdOn cannot be null";

        final List<Customer> customers = new ArrayList<Customer>();

        final Collection<Cart> carts = cartDao.findBy(createdOn);
        for (final Cart cart : carts) {
            customers.add(cart.getCustomer());
        }

        return customers;
    }

    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public CartDao getCartDao() {
        return cartDao;
    }
}
