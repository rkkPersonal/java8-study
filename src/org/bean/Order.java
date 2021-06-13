package org.bean;

/**
 * @author Steven
 */
public class Order {

    private String orderId;

    private String orderInfo;

    public Order(){

    }

    public Order(String orderId, String orderInfo) {
        this.orderId = orderId;
        this.orderInfo = orderInfo;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderInfo='" + orderInfo + '\'' +
                '}';
    }
}
