package com.example.demo.service;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gson.Gson;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;


@Component
public class PayPalClient {

	String clientId = "AWCom8B-27Z6PA7DvE6WyZHiD8USWhJqlkCskmtro2oS-orJ-tmMUddbX2Bn5EEzN_fktGjQhsK5Sm_i";
	String clientSecret = "EM4ERnEF_w7J3HyeRIupJmmgkpx9MXAZVMbnXuxjYhujYzh1h1cVJGNGXoCnqmdt0hbZnh3WFf71BPVQ";

	APIContext context = new APIContext(clientId, clientSecret, "sandbox");
	
	public Map<String, Object> createPayment(String totalPrice) {
		Map<String, Object> response = new HashMap<String, Object>();
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(totalPrice);
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		Payment payment = new Payment();
		//Payment intent; 
		//Must be set to sale for immediate payment or authorize for a delayed payment to be captured at a later time. 
		//Required.
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);

		RedirectUrls redirectUrls = new RedirectUrls();
		payment.setRedirectUrls(redirectUrls);
		Payment createdPayment;
		try {
			String redirectUrl = "";
			redirectUrls.setCancelUrl("http://localhost:4200/checkout");
			redirectUrls.setReturnUrl("http://localhost:4200/payment/execution");
			APIContext context = new APIContext(clientId, clientSecret, "sandbox");
			createdPayment = payment.create(context);

			if (createdPayment != null) {
				List<Links> links = createdPayment.getLinks();
				for (Links link : links) {
					if (link.getRel().equals("approval_url")) {
						redirectUrl = link.getHref();
						break;
					}
				}
				response.put("status", "success");
				response.put("redirect_url", redirectUrl);
			}
		} catch (PayPalRESTException e) {
			System.out.println("Error happened during payment creation!");
			e.printStackTrace();
		}
		return response;
	}
	
	public Map<String, Object> completePayment(HttpServletRequest req) {
		Map<String, Object> response = new HashMap<String, Object>();
		Payment payment = new Payment();
		payment.setId(req.getParameter("paymentId"));
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(req.getParameter("payerId"));
		try {
			APIContext context = new APIContext(clientId, clientSecret, "sandbox");
			Payment createdPayment = payment.execute(context, paymentExecution);
			Gson gson = new Gson();
			String createdPaymentJson = gson.toJson(createdPayment);
			if (createdPayment != null) {
				response.put("status", "success");
				response.put("payment", gson.fromJson(createdPaymentJson, Object.class));


			}
		} catch (PayPalRESTException e) {
			response.put("status", "failure");
			response.put("issue", e.getDetails());
			System.err.println(e.getDetails());
		}
		return response;
	}

}
