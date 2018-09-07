package Handler;



import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import Handler.LoginHandler;

public class AdminHandler {
	
	public static Scanner scan = new Scanner(System.in);

	public static void ShowMenu()
	{
		System.out.println("1.��ȸ");
		System.out.println("2.Ȱ��/�޸����");
		System.out.println("3.������ �޴� ����");
	}
	
	public static void ModifyNormalUser() throws InputMismatchException
	{
		System.out.print("ID�� �Է����ּ��� : ");
		String ID = scan.next();
		int flag = 0;
		try
		{
			for(int i = 0;i<LoginHandler.Normalcnt;i++)
			{
				
				if(LoginHandler.user[i].getID().equals(ID))
				{
					flag++;
					System.out.print("���� ����(1.Ȱ��  2.�޸�) : " + LoginHandler.user[i].getNum());	
					System.out.print("1.Ȱ�������� ����  2.�޸������� ���� : ");
						
					int num = scan.nextInt();
					
					if(num == 1)
					{
						LoginHandler.user[i].setNum(num);
						System.out.println("Ȱ�� ���·� ����Ϸ�");
						break;
					}
						
					else if(num == 2)
					{
						LoginHandler.user[i].setNum(num);
						System.out.println("�޸� ���·� ����Ϸ�");
						break;
					}
				}
				
			}
			if(flag == 0)
			{
				System.out.println("���� ���̵� �Դϴ�");
			}
		}
		catch(InputMismatchException e) {
			System.out.println("�߸��� �Է��Դϴ�");
		}
	}
	
	public static void ShowAll() throws InputMismatchException
	{
		try
		{
			while(true)
			{	
				System.out.println("1.ID �κа˻�  2.������ ���� �˻�  3.����");
				System.out.print("���� : ");
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
					System.out.println("����");
					return;
				default:
					System.out.println("�߸��� �Է��Դϴ�");
					break;
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("�߸��� �Է��Դϴ�");
		}
	}
	
	public static void IDsearch()
	{
		System.out.print("Id(�κ� ����)�� �Է��� �ּ��� : ");
		String str = scan.next();
		int flag = 0;
		
		for(int i = 0;i<LoginHandler.Normalcnt;i++)
		{
			if(LoginHandler.user[i].getID().contains(str))
			{	
					System.out.println("-----------ȸ������-------------");
					System.out.println("ȸ�� ID : " + LoginHandler.user[i].getID());
					System.out.println("ȸ����й�ȣ : " + LoginHandler.user[i].getPW());
					System.out.println("Ȱ������(1.Ȱ������  2.�޸�����): " +LoginHandler.user[i].getNum());
					System.out.println("������ : " + LoginHandler.user[i].getDate());
					System.out.println();
					flag = 1;
			}
			
		}
		if(flag == 0)
		{
			System.out.println("ID�� �����ϴ�");
		}
	}
	
	public static void Daysearch() throws InputMismatchException
	{
		try
		{
			System.out.println("���۳⵵�� �Է��ϼ���");
			int year = scan.nextInt();
			System.out.println("���� �Է��ϼ���");
			int month = scan.nextInt();
			System.out.println("�ϸ� �Է��ϼ���");
			int day = scan.nextInt();
			LocalDate start = LocalDate.of(year,month,day);
			
			System.out.println("���⵵�� �Է��ϼ���");
			int year1 = scan.nextInt();
			System.out.println("���� �Է��ϼ���");
			int month1 = scan.nextInt();
			System.out.println("�ϸ� �Է��ϼ���");
			int day1 = scan.nextInt();
			LocalDate end = LocalDate.of(year1,month1,day1);
			
			for(int i = 0;i<LoginHandler.Normalcnt;i++)
			{
				if(start.isBefore(LoginHandler.user[i].getDate()) && end.isAfter(LoginHandler.user[i].getDate()))
				{
					System.out.println("���� ID : " + LoginHandler.user[i].getID());
					System.out.println("���� pw : " + LoginHandler.user[i].getPW());
					System.out.println("Ȱ������(1.Ȱ��  2.�޸�) : " + LoginHandler.user[i].getNum());
					System.out.println("������ : " + LoginHandler.user[i].getDate());
				}
			}
		}	
		catch(InputMismatchException e) {
		System.out.println("�߸��� �Է��Դϴ�");
		}
	}

		/*
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		System.out.println("yyyy-mm-dd�������� ���۳�¥�� �Է����ּ���");
		String Start = scan.next();
		System.out.println("yyyy-mm-dd�������� ����¥�� �Է����ּ���");
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
					System.out.println("���� ID : " + LoginHandler.user[i].getID());
					System.out.println("���� pw : " + LoginHandler.user[i].getPW());
					System.out.println("Ȱ������(1.Ȱ��  2.�޸�) : " + LoginHandler.user[i].getNum());
					System.out.println("������ : " + LoginHandler.user[i].getDate());
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