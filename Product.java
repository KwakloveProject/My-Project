package 나혼자실헝할프로그램.copy12;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product implements Comparable<Product>, Serializable
{
	private String product;
	private int price;
	private int code;
	private int count;
	private boolean flag =false;
	
	public Product( int code, String product, int price ,int count) 
	{
		super();
		this.code=code;
		this.product = product;
		this.price = price;
		this.count =count;
	}

		public static List<Product> ProductList() 
		{
			List<Product> productList = new ArrayList<>();
			productList.add(new Product(1,"뉴욕티셔츠",10000,0));
			productList.add(new Product(2,"뉴저지 티셔츠",20000,0));
			productList.add(new Product(3,"코리아 티셔츠",30000,0));
			return productList;
		}
	public int getCode() {
		return code;
	}


	public int getCount() {
		return count;
	}


	public void setCount() {
		this.count = count;
	}
	public void addCount() 
	{
		this.count++;
	}
	public void minusCount() 
	{
		if(this.count>=1) 
		{
			this.count--;
		}
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) 
	{
		this.price=price;
	}

	@Override
	public String toString() 
	{
		return "code=" + code +" product=" + product + " price=" + price +"\n";
	}
	public String toString2() 
	{
		return "code=" + code +" product=" + product + " price=" + price +"개수"+count+"\n";
	}
	public String toString3() 
	{
		return "code=" + code +" product=" + product + " price=" + price +"개수"+count+"\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return code == other.code;
	}


	@Override
	public int compareTo(Product o) 
	{
		return this.code-o.count ;
	}


	
}