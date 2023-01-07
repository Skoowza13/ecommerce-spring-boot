package com.ecom.app.ws.requests;

import java.math.BigDecimal;

public class CartShopRequest {

    private BigDecimal GrandTotal;

    public BigDecimal getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        GrandTotal = grandTotal;
    }
}
