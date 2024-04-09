package 나혼자실헝할프로그램.copy12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MarketMain 
{
	public static final int COUNT_NO=4;
	public static List<Players> playerlist =new ArrayList<>();
	public static List<Product> shopList= new ArrayList<Product>();
	public static Set<Product> shoppingbagList= new HashSet<>(); //데이터에 찍힐때 중복으로 찍히지않게 하기 위해서 set이용
	static int sum=0;//잔액
	public static Scanner sc =new Scanner(System.in);
	
	public static void main(String [] args) throws IOException, ClassNotFoundException 
	{
//		사용자로그인
		shopList=Product.ProductList();
		System.out.println("이름을 입력해주세요");
		String name =sc.nextLine();
		System.out.println("전화번호를 입력해주세요");
		String phone = sc.nextLine();
		playerlist=loadingFile();
		if(name.equals("관리자")&&phone.equals("1")) 
		{
			boolean flag=false;
			while(!flag) 
			{
				System.out.println("1.상품 추가 2.상품 삭제 3.손님정보확인 4.종료");
				int menu =sc.nextInt();
				switch(menu) 
				{
				case 1: insertShopList();
				break;
				case 2: deleteShopList();
				break;
				case 3:	showUserFile();
				break;
				case 4: flag =true;
				default:break;
				}
			}
			
		}
		else 
		{
			playerlist.add(new Players(name, phone));
			inputFile();
			boolean flag =false;
			while(!flag) 
			{
				int menu=userMenu();
				switch(menu) 
				{
				case 1: inputbagList();
				break;
				case 2: printBagList();
				break;
				case 3: clearBagList();
				break;
				case 4: deletebagList();
				break;
				case 5: buyBagList();
				break;
				case 6:flag =true;
				break;
				default:break;
				}
				
			}	
			
		}
		
		
		}

	

	private static List<Product> LoadingShopFile() 
	{
		 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("shopList.txt")))) {
			 ArrayList<Product>userList = (ArrayList<Product> ) ois.readObject();
	            return shopList;
	        } catch (Exception e) 
	        {
	        }
	        return new ArrayList<Product>() ;
		}

		private static void inputFile()
		{
			  ObjectOutputStream oos =null;
		        try 
		        {
		         oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("user.txt"))));
		         oos.writeObject(playerlist);
		        } 
		        catch(IOException e) 
		        {
		            System.out.println("오류가 발생"+ e.toString());
		        }
		        finally 
		        {
		        try 
		        {
		            oos.close();
		        }
		        catch (IOException e) 
		        {
		            System.out.println("오류가 발생"+ e.toString());
		        }

		        }
			
	}



	private static void showUserFile() 
	{
		System.out.println(playerlist);
	}



	private static void deleteShopList() 
	{
		System.out.println(shopList);
		System.out.println("삭제하실 상품의 코드를 기입하시오");
		int code =sc.nextInt();
		for(Product data : shopList) 
		{
			if(data.getCode()==code) 
			{
				shopList.remove(data);
				System.out.println(shopList);
				break;
			}
		}
	}



	private static void insertShopList() 
	{
			System.out.println("추가하실 상품의(코드, 옷이름 , 가격)을 순서대로 기입하시오");
			shopList.add(new Product(sc.nextInt(), sc.next(), sc.nextInt(), 0));
			System.out.println(shopList);
		
	}



	private static ArrayList<Players> loadingFile() throws IOException, ClassNotFoundException 
	{
	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("user.txt")))) {
	    	ArrayList<Players> userList = (ArrayList<Players> ) ois.readObject();
            return userList;
        } catch (Exception e) 
        {
        }
        return new ArrayList<Players>();
	}

	




																					
	private static void buyBagList() 
	{
		boolean flag =false;
		while(!flag) 
		{
			if(shoppingbagList.isEmpty()) 
			{
				System.out.println("0원이기 때문에 메뉴로 돌아갑니다");
				flag=true;
			}
			for(Product data : shoppingbagList) 
			{
				System.out.println("총 금액은"+sum);
				System.out.println("내실 금액을 입력하시오");
				int price =sc.nextInt();
				if(price >= data.getPrice()) 
				{
					//total =잔액
					int total=price-sum;
					System.out.println("결제가 완료되었습니다 남은 금액은"+total+"입니다");
					sc.nextLine();
					flag =true;
					break;
				}
				else 
				{
					System.out.println("다시입력하시오");
				}
			}	
		}
		
	}

	private static void deletebagList() 
{
	
	for(;;)
	{
		System.out.println("삭제하실 상품의 코드를 입력하시오 0을 누르면 메뉴로 나가짐");
			int code =sc.nextInt();
			sc.nextLine();
			if(shoppingbagList.isEmpty()) 
			{
				System.out.println("해당 상품없음");
			}
		for(Product data : shoppingbagList) 
		{
			if(code==data.getCode()) 
			{
				if(data.getCount()>0) 
				{
					data.minusCount();
				}
				System.out.println(data);
				if(sum>=data.getPrice()) 
				{
					sum=sum-data.getPrice();
				}
			}
		}
		if(code ==0) 
		{
			break;
		}
	}
}


	


	
	private static void clearBagList() 
	{
		shoppingbagList.clear();
		shopList.clear();
		sum=0;
	}

	private static void printBagList() {
		for(Product data : shoppingbagList) 
		{
			System.out.println(data.toString2());
		}
	}



	private static void printPlayersinfo(List<Players> playerlist2) 
	{
			System.out.println(playerlist);
	}
	
	private static  void inputbagList(  ) 
	{
			for(;;) 
			{
				if(shoppingbagList.isEmpty()) 
					{
						shopList= Product.ProductList();	
						System.out.println(shopList);
						 int code =0;
						 
						 code=Shopping();
						 if(code==0) 
						 { 
							sc.nextLine();
							 break; 
						 }
					}
					else 
					  	{
							int code =	Shopping();
							if(code==0) 
							{
								sc.nextLine();
								break;
							}
						}
			}
	}
	private static int Shopping() 
	{
		System.out.println("구매하실 상품의 코드를 입력바람 (0번 누르면 메뉴로 나가짐)");
		int code= sc.nextInt();
		for(Product data: shopList) 
		{
			if(data.getCode()==code) 
			{
				data.addCount();
				shoppingbagList.add(data);
				System.out.println(data.toString2());
				sum=sum+data.getPrice();
			}
		}
		return code;
	}
	private static int userMenu() 
	{
		
		String regExp ="^[1-7]*$";
	        String strNum =null;
	        int menu=0;
	        boolean flag =false;
	        while(!flag) 
	        {

	    		System.out.println("1.장바구니에 항목 추가하기  \t2.장바구니 상품목록보기");
	    		System.out.println("3.장바구니 비우기 \t4.장바구니의 항목 삭제하기");
	    		System.out.println("5.영수증 표시하기\t6.종료 "); 
	    		System.out.println("메뉴를 선택해주세요");
	    		strNum =sc .nextLine();
	            if(strNum.matches(regExp)) 
	            {
	                menu=Integer.parseInt(strNum);
	                if(menu>=1 && menu<=10) 
	                {
	                    flag=true;
	                }
	                else 
	                {
	                    System.out.println("숫자 1부터 7까지만 입력해주세요");
	                }
	            }
	            else 
	            {
	                System.out.println("숫자만 입력가능!");
	            }
	        }
	        return menu;
	}
}
