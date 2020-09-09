package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;

public class OrderRequest {

public OrderInfos infos;
public OrderPids items;

 public OrderRequest(OrderInfos orderinfos, OrderPids orderitems) {
	//super();
	this.infos = orderinfos;
	this.items = orderitems;
}
 
public OrderInfos getOrderinfos() {
	return infos;
}
public void setOrderinfos(OrderInfos orderinfos) {
	this.infos = orderinfos;
}
public OrderPids getOrderitems() {
	return items;
}
public void setOrderitems(OrderPids orderitems) {
	this.items = orderitems;
}
 
}