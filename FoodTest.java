package upgradefirst;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FoodTest 
{
	public static List<String> list =new ArrayList<>();
	public static Scanner sc =new Scanner(System.in);
	public static void main(String[] args) throws IOException 
	{
		boolean flag =false;
		while(!flag)
		{
			int menu =inputMenu();
			switch(menu) 
			{
			case 1:koreanFood();
			break;
			case 2:dietFood();
			break;
			case 3:WesternstyleFood();
			break;
			case 4:Chinesefood();
			break;
			case 5:SojuBeerinfiniteFood();
			break;
			case 6:flag=true;
			break;
			default:
			break;
			}
			
		}
		
		
	}
	public static int inputMenu() 
	{
		String regExp ="^[0-9]*$";
		String strNum =null;
		int menu=0;
		boolean flag =false;
		while(!flag) 
		{
			System.out.println("~~내가 먹어본 역삼역 근처 맛집들 알려줄게~~");
			System.out.println("    1.#한식 2.#다이어트식 3.#양식 \n    4.#중식 5.#술 무한리필 골라봐~!\n             6.종료");
			strNum =sc .nextLine();
			if(strNum.matches(regExp)) 
			{
				menu=Integer.parseInt(strNum);
				if(menu>=0 && menu<=10) 
				{
					flag=true;
				}
				else 
				{
					System.out.println("숫자 1부터 5까지만 입력해주세요");
				}
			}
			else 
			{
				System.out.println("숫자만 입력가능!");
			}
		}
		return menu;
	}
	

	private static List<String> loading() throws IOException 
	{
		
		FileReader fis = new FileReader("Food.txt");
		BufferedReader bis = new BufferedReader(fis);
		String a =null;
		while((a = bis.readLine()) != null) 
		{
			list.add(a);
		}
		return list;
	}
	public static void Log(String obj) 
	{
		ArrayList<String> sublist =null;
		sublist = (ArrayList<String>) list.stream()
			.filter((t) -> t.contains(obj))
			.collect(Collectors.toList());
			int i =(int)(Math.random()*((sublist.size()-1)-0+1)+0);
			System.out.println(sublist.get(i));
	}
	
	private static void koreanFood() throws IOException 
	{
		loading();
		Log("#한식");
	}
	private static void dietFood() throws IOException 
	{
		loading();
		Log("#다이어트");
	}
	private static void WesternstyleFood() throws IOException 
	{
		loading();
		Log("#양식");
	}
	private static void Chinesefood() throws IOException 
	{
		loading();
		Log("#중식");
	}
	private static void SojuBeerinfiniteFood() throws IOException 
	{
		loading();
		Log("#술 무한리필");
	}
}
	
	
	
	
	
	
	
	

