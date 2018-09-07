package Handler;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.Account;
import Entity.NormalAccount;
import Entity.HighCreditAccount;


import Exception.AccountException;
//import Exception.MinusWithdrawException;
//import Exception.WithdrawException;



public class NormalHandler
{
	public static Scanner scan = new Scanner(System.in);
	static Account[] Acc1 = new Account[10000];
	static int cnt;
	
	public static void ShowMenu()
	{
		System.out.println("----------menu----------");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.이체");
		System.out.println("5.계좌 정보 전체 출력");
		System.out.println("6.회원정보수정");
		System.out.println("7.종료");
	}
	
	public static void MakeAccount(int idx) throws InputMismatchException
	{
		try
		{
			System.out.println("[계좌종류선택]");
			System.out.println("1.보통예금계좌   2.신용신뢰계좌");
			System.out.print("선택 : ");
			int num = scan.nextInt();
			
			if(num == 1)
			{
				MakeNormalAccount(idx);
			
			}
			else if(num == 2)
			{
				MakeHighCreditAccount(idx);
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}
	
	public static void MakeNormalAccount(int idx) throws InputMismatchException
	{
		try
		{
			System.out.println("[보통예금계좌 개설]");
			
			while(true)
			{
				int flag = 0;
				System.out.print("계좌 ID :");
				int id = scan.nextInt();
				
				for(int i = 0;i<cnt;i++)
				{
					if(id == Acc1[i].getAccID())
					{
						System.out.println("동일한 계좌번호가 있습니다. 다시입력해주세요");
						flag++;
						break;
					}
				}
				
				if(flag == 0)
				{
					System.out.print("계좌 비밀번호 : ");
					int pw = scan.nextInt();
					System.out.print("이름 :");
					String name = scan.next();
					System.out.print("입금액 :");
					int bal = scan.nextInt();
					System.out.print("이자율 :");
					int rate = scan.nextInt();
					
					Acc1[cnt++] = new NormalAccount(id,bal,pw,name,idx,rate);
					System.out.println("일반계좌가 생성되었습니다.");
					return;
				}	
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}
	
	public static void MakeHighCreditAccount(int idx) throws InputMismatchException
	{
		try
		{
			System.out.println("[신용신뢰계좌 개설]");
			
			while(true)
			{
				int flag = 0;
				System.out.print("계좌 ID :");
				int id = scan.nextInt();
				
				for(int i = 0;i<cnt;i++)
				{
					if(id == Acc1[i].getAccID())
					{
						System.out.println("동일한 계좌번호가 있습니다. 다시입력해주세요");
						flag++;
						break;
					}
				}
				
				if(flag == 0)
				{
					System.out.print("계좌 비밀번호 : ");
					int pw = scan.nextInt();
					System.out.print("이름 :");
					String name = scan.next();
					System.out.print("입금액 :");
					int bal = scan.nextInt();
					System.out.print("이자율 :");
					int rate = scan.nextInt();
					System.out.print("신용등급(1toA, 2toB, 3toC) :");
					int rate2 = scan.nextInt();
					
					switch(rate2) {
					case 1 :
						Acc1[cnt++] = new HighCreditAccount(id,bal,pw,name,idx,rate,7);
						System.out.println("신용계좌가 생성되었습니다.");
						return;
					case 2:
						Acc1[cnt++] = new HighCreditAccount(id,bal,pw,name,idx,rate,4);
						System.out.println("신용계좌가 생성되었습니다.");
						return;
					case 3:
						Acc1[cnt++] = new HighCreditAccount(id,bal,pw,name,idx,rate,2);
						System.out.println("신용계좌가 생성되었습니다.");
						return;
					}
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}
	
	/*public static void MakeAccount()
	{
		System.out.println("계좌번호를 입력해주세요");
		int acc = scan.nextInt();
		
		System.out.println("이름을 입력해주세요");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.println("입금액을 입력해주세요");
		int money = scan.nextInt();
		
		Acc1[cnt++] = new Account(acc,money,name);
		System.out.println("계좌를 생성하였습니다");
	}*/
	
	public static void tranfer() throws AccountException,InputMismatchException
	{
		try
		{
			System.out.print("출금할 통장의 계좌번호를 입력해주세요 : ");
			int id = scan.nextInt();
			int flag = 0;
			int id_flag = 0;
			int pw_flag = 0;
			
			try
			{
				for(int i=0;i<cnt;i++)
				{
					if(Acc1[i].getAccID() == id)
					{
						id_flag++;
						System.out.print("비밀번호를 입력해주세요 : ");
						int pw = scan.nextInt();
						if(Acc1[i].getAccPW() == pw)
						{
							pw_flag = 1;
							System.out.print("이체할 통장의 계좌번호를 입력해주세요 : ");
							int r_id = scan.nextInt();
							for(int i2 = 0;i2<cnt;i2++)
							{
								if(r_id == Acc1[i2].getAccID())
								{
									if(Acc1[i].getAccID() != Acc1[i2].getAccID())
									{
										if(LoginHandler.user[(Acc1[i2].getIndex())].getNum() == 1) {
										flag++;
										System.out.print("이체금액을 입력해주세요 : ");
										int money = scan.nextInt();
										Acc1[i].Withdraw(money);
										Acc1[i2].setBalance(Acc1[i2].getBalance() + money);
										System.out.println("이체가 완료되었습니다.");
										return;
										}
										else
										{
											System.out.println("휴면계좌로는 이체가 불가합니다.");
											return;
										}
									}
									else
									{
										System.out.println("동일계좌로는 이체가 불가능합니다");
										return;
									}
								}
							}
							if(flag == 0)
							{
								System.out.println("잘못된/없는 계좌번호 입니다");
								return;
							}
						}
						if(pw_flag == 0)
						{
							System.out.println("잘못된 패스워드 입력입니다.");
							return;
						}
					}	
				}
				if(id_flag == 0)
				{
					System.out.println("잘못된/없는 계좌번호 입니다");
					return;
				}
			}
			
			catch(AccountException e) 
			{
				e.ShowExceptionReason();
			}
		}
		
		catch(InputMismatchException e) 
		{
			System.out.println("잘못된 입력입니다");
		}
			
	}
		


	public static void DepositMoney() throws AccountException,InputMismatchException
	{
		try
		{
			System.out.print("계좌번호를 입력해주세요 : ");
			int id = scan.nextInt();
			int id_flag = 0;
			int pw_flag = 0;
			
			try
			{
				for(int i=0;i<cnt;i++)
				{
					if(Acc1[i].getAccID() == id)
					{
						id_flag++;
						System.out.print("비밀번호를 입력해주세요 : ");
						int pw = scan.nextInt();
						if(Acc1[i].getAccPW() == pw)
						{
							pw_flag++;
							System.out.print("입금액을 입력해주세요 : ");
							int money = scan.nextInt();
							Acc1[i].Deposit(money);
							System.out.println("입금완료");
							return;
						}
						else if(pw_flag == 0)
						{
							System.out.println("잘못된 패스워드입니다.");
							return;
						}
					}
					
				}
				if(id_flag == 0)
				{
					System.out.println("잘못된/없는 계좌번호 입니다.");
					return;
				}
			
			}
			
			catch(AccountException e) {
				e.ShowExceptionReason();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}

	@SuppressWarnings("unused")
	public static void WithdrawMoney() throws AccountException,InputMismatchException
	{
		try
		{
			System.out.print("계좌번호를 입력해주세요 : ");
			int id = scan.nextInt();
			int id_flag = 0;
			int pw_flag = 0;
			
			
			try
			{
				for(int i=0;i<cnt;i++)
				{
					if(Acc1[i].getAccID() == id)
					{
						id_flag++;
						System.out.print("비밀번호를 입력해주세요 : ");
						int pw = scan.nextInt();
						
						if(Acc1[i].getAccPW() == pw)
						{
							pw_flag++;
							System.out.print("출금액을 입력해주세요 : ");
							int money = scan.nextInt();
							
							Acc1[i].Withdraw(money);
							System.out.println("출금완료");
							return;
							
						}
						else if(pw_flag == 0)
						{
							System.out.println("잘못된 패스워드입력입니다.");
							return;
						}
					}
				}
				if(id_flag == 0)
				{
					System.out.println("잘못된/없는 계좌번호입니다.");
					return;
				}	
			}
			
			catch(AccountException e) {
				e.ShowExceptionReason();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
		
		/*
		catch(MinusWithdrawException e) {
			e.ShowExceptionReason();
		}
		*/

	}
	
	public static void ShowAllAccount(int idx)
	{
		int flag = 0;
		
		for(int i=0;i<cnt;i++)
		{
			if(idx == Acc1[i].getIndex())
			{
				System.out.println();
				Acc1[i].ShowInfo();
				System.out.println();
				flag++;
			}
		}
		if(flag == 0)
		{
			System.out.println("계좌가 없습니다");
		}
		
	}
}