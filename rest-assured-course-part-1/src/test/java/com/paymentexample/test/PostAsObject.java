package com.paymentexample.test;

import com.jayway.restassured.http.ContentType;
import com.paymentexample.base.BaseClass;
import com.paymentexample.pojo.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class PostAsObject extends BaseClass {

    static String payment_id;

    @Test
    public void createPayment() {

        Redirect_urls redirect_urls = new Redirect_urls();
        redirect_urls.setCancel_url("http://www.hawaii.com");
        redirect_urls.setReturn_url("http://www.amazon.com");


        Details details = new Details();
        details.setHandling_fee("1.022");
        details.setInsurance("1.022");
        details.setShipping("1.022");
        details.setShipping_discount("1.022");
        details.setSubTotal("1.022");
        details.setTax("1.022");

        Amount amount = new Amount();

        amount.setCurrency("USD");
        amount.setDetails(details);
        amount.setTotal("21313");

        ShippingAdress shippingAdress = new ShippingAdress();

        shippingAdress.setCity("Sane Jose");
        shippingAdress.setCountry_code("1231");
        shippingAdress.setLine1("21");
        shippingAdress.setLine2("2112");
        shippingAdress.setPhone("2121");
        shippingAdress.setPostal_code("221");
        shippingAdress.setRecipent_name("Marius");
        shippingAdress.setState("Louisiana");

        Items item = new Items();
        item.setCurrency("s");
        item.setDescription("s");
        item.setName("s");
        item.setPrice("s");
        item.setQuantity("s");
        item.setSku("s");
        item.setTax("S");

        Items item2 = new Items();
        item2.setCurrency("s");
        item2.setDescription("s");
        item2.setName("s");
        item2.setPrice("s");
        item2.setQuantity("s");
        item2.setSku("s");
        item2.setTax("s");

        List<Items> items = new ArrayList<>();
        items.add(item2);
        items.add(item2);


        Item_list item_list = new Item_list();
        item_list.setItems(items);
        item_list.setShippingAdress(shippingAdress);


        Payment_Options payment_options = new Payment_Options();
        payment_options.setAllowed_payment_method("INSTANT_FUNDING_SOURCE");


        Transactions transactions = new Transactions();
        transactions.setAmount(amount);
        transactions.setCustom("EBAY_EMS_900003131324");
        transactions.setDescription("This is the payment");
        transactions.setInvoice_number("53915139513");
        transactions.setItem_list(item_list);
        transactions.setPayment_options(payment_options);
        transactions.setSoft_descriptor("ECSAH@");


        Payer payer = new Payer();
        payer.setPayment_method("Paypal");

        PostObject postObject = new PostObject();

        List<Transactions> transactions1 = new ArrayList<>();

        transactions1.add(transactions);

        postObject.setTypes(transactions1);


        payment_id = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(accessToken)
                .when()
                .body(postObject)
                .post("payments/payment")
                .then()
                .log()
                .all()
                .extract()
                .path("id");

    }


    @Test
    public void getPaymentDetails() {

                given()
                        .auth()
                        .oauth2(accessToken)
                        .when()
                        .get("/payments/payment" + payment_id)
                        .then()
                        .log()
                        .all();
    }
}
