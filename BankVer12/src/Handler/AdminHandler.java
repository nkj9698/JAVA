package Handler;



import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import Handler.LoginHandler;

public class AdminHandler {
	
	public static Scanner scan = new Scanner(System.in);

	public static void ShowMenu()
	{
		System.out.println("1.조회");
		System.out.println("2.활동/휴면수정");
		System.out.println("3.관리자 메뉴 종료");
	}
	
	public static void ModifyNormalUser() throws InputMismatchException
	{
		System.out.print("ID를 입력해주세요 : ");
		String ID = scan.next();
		int flag = 0;
		try
		{
			for(int i = 0;i<LoginHandler.Normalcnt;i++)
			{
				
				if(LoginHandler.user[i].getID().equals(ID))
				{
					flag++;
					System.out.print("현재 상태(1.활동  2.휴면) : " + LoginHandler.user[i].getNum());	
					System.out.print("1.활동유저로 변경  2.휴면유저로 변경 : ");
						
					int num = scan.nextInt();
					
					if(num == 1)
					{
						LoginHandler.user[i].setNum(num);
						System.out.println("활동 상태로 변경완료");
						break;
					}
						
					else if(num == 2)
					{
						LoginHandler.user[i].setNum(num);
						System.out.println("휴면 상태로 변경완료");
						break;
					}
				}
				
			}
			if(flag == 0)
			{
				System.out.println("없는 아이디 입니다");
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}
	
	public static void ShowAll() throws InputMismatchException
	{
		try
		{
			while(true)
			{	
				System.out.println("1.ID 부분검색  2.가입일 범위 검색  3.종료");
				System.out.print("선택 : ");
				int num = scan.nextInt();
				
				switch(num)
				{
				case 1:
					IDsearch();
					break;
				case 2:
					Daysearch();
					break;
				case 3 :
					System.out.println("종료");
					return;
				default:
					System.out.println("잘못된 입력입니다");
					break;
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}
	
	public static void IDsearch()
	{
		System.out.print("Id(부분 가능)를 입력해 주세요 : ");
		String str = scan.next();
		int flag = 0;
		
		for(int i = 0;i<LoginHandler.Normalcnt;i++)
		{
			if(LoginHandler.user[i].getID().contains(str))
			{	
					System.out.println("-----------회원정보-------------");
					System.out.println("회원 ID : " + LoginHandler.user[i].getID());
					System.out.println("회원비밀번호 : " + LoginHandler.user[i].getPW());
					System.out.println("활동상태(1.활동유저  2.휴면유저): " +LoginHandler.user[i].getNum());
					System.out.println("가입일 : " + LoginHandler.user[i].getDate());
					System.out.println();
					flag = 1;
			}
			
		}
		if(flag == 0)
		{
			System.out.println("ID가 업습니다");
		}
	}
	
	public static void Daysearch() throws InputMismatchException
	{
		try
		{
			System.out.println("시작년도를 입력하세요");
			int year = scan.nextInt();
			System.out.println("월를 입력하세요");
			int month = scan.nextInt();
			System.out.println("일를 입력하세요");
			int day = scan.nextInt();
			LocalDate start = LocalDate.of(year,month,day);
			
			System.out.println("끝년도를 입력하세요");
			int year1 = scan.nextInt();
			System.out.println("월를 입력하세요");
			int month1 = scan.nextInt();
			System.out.println("일를 입력하세요");
			int day1 = scan.nextInt();
			LocalDate end = LocalDate.of(year1,month1,day1);
			
			for(int i = 0;i<LoginHandler.Normalcnt;i++)
			{
				if(start.isBefore(LoginHandler.user[i].getDate()) && end.isAfter(LoginHandler.user[i].getDate()))
				{
					System.out.println("계좌 ID : " + LoginHandler.user[i].getID());
					System.out.println("계좌 pw : " + LoginHandler.user[i].getPW());
					System.out.println("활동여부(1.활동  2.휴면) : " + LoginHandler.user[i].getNum());
					System.out.println("가입일 : " + LoginHandler.user[i].getDate());
				}
			}
		}	
		catch(InputMismatchException e) {
		System.out.println("잘못된 입력입니다");
		}
	}

		/*
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		System.out.println("yyyy-mm-dd형식으로 시작날짜를 입력해주세요");
		String Start = scan.next();
		System.out.println("yyyy-mm-dd형식으로 끝날짜를 입력해주세요");
		String End = scan.next();
		System.out.println(1);
		
			Date Start1 = format.parse(Start);
			Date End2 = format.parse(End);
			
				
			for(int i = 0;i<LoginHandler.Normalcnt;i++)
			{System.out.println(2);
				int compare1 = Start1.compareTo(LoginHandler.user[i].getDate());
				int compare2 = End2.compareTo(LoginHandler.user[i].getDate());
				
				if(compare1 <=0 && compare2 >= 0)
				{
					System.out.println("계좌 ID : " + LoginHandler.user[i].getID());
					System.out.println("계좌 pw : " + LoginHandler.user[i].getPW());
					System.out.println("활동여부(1.활동  2.휴면) : " + LoginHandler.user[i].getNum());
					System.out.println("가입일 : " + LoginHandler.user[i].getDate());
				}
				else
				{
					return;
				}
			}
			
			return;
		}	
		*/
		
}
