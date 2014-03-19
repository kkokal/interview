package com.kokal.four;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

/**
 * Describe at least two steps that you would take to improve the cohesion
 * and reduce the coupling of this data model class.
 *
 * 1. Encapsulate the calls to QBPPurchasingRuleDao and QBPPurchasingRuleEngine behind a single facade method. Combining
 *    these calls will result in a more cohesive component, and reduces the need for client code to sequence multiple calls
 *    properly (as shown below) in order to accomplish its goals.
 * 2. Refactor the data access logic into a data access object (DAO). This will decouple the model from the
 *    underlying database representation, and even enable the Model to be reused with a different database by
 *    delegating to a different DAO implementation (one impl for Oracle, another for Riak, for example).
 */
public class CartModel {
    int customerId;
    int cartId;

    public boolean addProductToCart(String product, int quantity) {
        final Collection<String> purchasingRules =
                QBPPurchasingRuleDao.getInstance().getRulesForCustomer(customerId);
        final boolean canPurchaseProduct =
                QBPPurchasingRuleEngine.getInstance()
                        .canPurchaseProduct(product, quantity, purchasingRules);
        if (!canPurchaseProduct) {
            return false;
        }
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = ConnectionManager.getInstance().getConnection();
            statement = conn.prepareStatement(
                    "insert into cart_entry (product,quantity) values (?,?) where cart_id = ?");
            statement.setString(1, product);
            statement.setInt(2, quantity);
            statement.setInt(3, cartId);
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            JdbcUtils.close(statement, conn);
        }
    }
}
