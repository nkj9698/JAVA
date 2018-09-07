package Handler;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.Adminuser;
import Entity.NormalUser;
import Exception.AccountException;
import Exception.LoginException;
import Exception.pwException;

public class LoginHandler {
	
	public static int Normalcnt;
	public static int Admincnt;
	public static Scanner scan = new Scanner(System.in);
	public static NormalUser[] user = new NormalUser[100];
	public static Adminuser[] user2 = new Adminuser[5];
	
	
			
	public static void ShowMenu()
	{
		System.out.println("선택해주세요");
		System.out.println("1.일반유저 로그인   2.일반유저 회원가입   3.관리자로그인  4.관리자유저등록  5.종료");
		System.out.print("선택 : ");
	}
	
	public static void NormalLogin() throws AccountException,InputMismatchException 
	{
		System.out.print("id: ");
		String Id = scan.next();
		System.out.print("password: ");
		String pw = scan.next();
		int index;
		
		try
		{
				index = normalIdcheck(Id);
					if(normalPwcheck(pw,index))
					{
						if(user[index].getNum() == 1)
						{	
							System.out.println("로그인에 성공하였습니다.");
							try
							{
							while(true)
							{
								NormalHandler.ShowMenu();
								System.out.print("선택 : ");
								int choice = NormalHandler.scan.nextInt();
							
								switch(choice) {
								case 1:
									NormalHandler.MakeAccount(index);
									break;
								case 2:
									NormalHandler.DepositMoney();
									break;
								case 3:
									NormalHandler.WithdrawMoney();
									break;
								case 4:
									NormalHandler.tranfer();
									break;
								case 5:
									NormalHandler.ShowAllAccount(index);
									break;
								case 6:
									LoginHandler.ModifyInformation();
									break;
								case 7:
									return;
								default :
									System.out.println("잘못된 입력입니다");
									break;
								}
							}
							}
							catch(InputMismatchException e) {
								System.out.println("잘못된 입력입니다");
							}
						
						}
						else
						{
							System.out.println("휴면 유저라 계좌를 생성할 수 없습니다.");
						}
					}
				
			
		}
		catch(AccountException e)
		{
			e.ShowExceptionReason();
		}
	}

		
	
	public static int normalIdcheck(String Id) throws AccountException
	{
		int flag = -1;
		for(int i = 0; i<Normalcnt; i++)
		{
			if(Id.equals(user[i].getID()))
			{
				flag = i;
			}
		}
		
		if(flag == -1)
			throw new LoginException();
		
		return flag;
	}
	
	public static boolean normalPwcheck(String pw,int num) throws AccountException
	{
		boolean flag = false;
	
		if(pw.equals(user[num].getPW()))
		{
			flag = true;
		}
		
		if(flag == false)
			throw new pwException();
		
		return flag;
	}
	
	public static int adminIdcheck(String Id) throws AccountException
	{
		int flag = -1;
		for(int i = 0; i<Admincnt; i++)
		{
			if(Id.equals(user2[i].getID()))
			{
				flag = i;
			}
		}
		
		if(flag == -1)
			throw new LoginException();
		return flag;
	}
	
	public static boolean adminPwcheck(String pw,int num) throws AccountException
	{
		boolean flag = false;
			if(pw.equals(user2[num].getPW()))
			{
				flag = true;
			}

		if(flag == false)
			throw new pwException();
		return flag;
	}
	
	public static void MakeNormalUser()
	{
		
		System.out.println("[회원가입]");
		
		while(true)
		{
			int flag = 0;
			System.out.print("ID를 입력해주세요 :");
			String id = scan.next();
			for(int i = 0;i<Normalcnt;i++)
			{
				if(id.equals(user[i].getID()))
				{
					System.out.println("동일한 ID가 있습니다.다시 입력해주세요");
					flag = 1;
					break;
				}
			}
			if(flag == 0)
			{
				System.out.print("pw :");
				String pw = scan.next();
				System.out.print("활동 여부(1.YES  2.NO) : ");
				int num2 = scan.nextInt();
				
				user[Normalcnt++] = new NormalUser(id,pw,num2);
				return;
			}
		}
	}
	
	
	public static void AdminLogin() throws AccountException,InputMismatchException
	{
		System.out.print("id: ");
		String Id = scan.next();
		System.out.print("password: ");
		String pw = scan.next();
		int index;
		
		try
		{
			
				index = adminIdcheck(Id);
				
					if(adminPwcheck(pw,index))
					{
						try
						{
						System.out.println("로그인에 성공하였습니다.");
						
						
						while(true)
						{
							AdminHandler.ShowMenu();
							System.out.print("선택 : ");
							int choice = NormalHandler.scan.nextInt();
							
							switch(choice) {
							case 1:
								AdminHandler.ShowAll();
								break;
							case 2:
								if(user2[index].getAuthority() == 2)
								{
									AdminHandler.ModifyNormalUser();
									break;
								}
								else
								{
									System.out.println("권한이 없습니다");
									break;
								}
							case 3:
								System.out.println("관리자 메뉴 종료");
								return;
							default :
								System.out.println("잘못된 입력입니다");
								break;
						}
					}
				}
				catch(InputMismatchException e) {
					System.out.println("잘못된 입력입니다");
				}
			}
		}
		catch(AccountException e)
		{
			e.ShowExceptionReason();
		}
	}
	
	
	public static void MKPossAdmin()
	{
		String passWord = "1111";
		String inPassword;
		System.out.println("[관리자등록(최대 5명까지 가능합니다.   현재 :" + Admincnt +"명" + ")]");
		System.out.print("[password를 입력해주세요] : ");
		inPassword = scan.next();

		if(passWord.equals(inPassword))
		{
			while(true)
			{
				int flag = 0;
				System.out.print("ID를 입력해주세요 :");
				String id = scan.next();
				for(int i = 0;i<Admincnt;i++)
				{
					if(id.equals(user2[i].getID()))
					{
						System.out.println("동일한 ID가 있습니다.다시 입력해주세요");
						flag = 1;
						break;
					}
				}
				if(flag == 0)
				{
					System.out.print("비밀번호 :");
					String pw = scan.next();
					System.out.print("1.조회만 가능  2.조회 및 수정가능 : ");
					int num2 = scan.nextInt();
					
					user2[Admincnt++] = new Adminuser(id,pw,num2);
					System.out.println("관리자 등록이 완료되었습니다");
					return;
				}
			}
		}
		else
		{
			System.out.println("잘못된 패스워드입니다. 초기화면으로 돌아갑니다");
			return;
		}
	}
	
	public static void ModifyInformation() throws InputMismatchException
	{
		int flag = 0;
		try 
		{
			System.out.println("1.아이디 수정  2.비밀번호 수정 3.Menu");
			System.out.print("선택 : ");
			int n = scan.nextInt();
			if(n == 1)
			{
				int id_flag = 0;
				System.out.print("수정 하고 싶은 Id를 입력해주세요(현재 ID) : ");
				String ID = scan.next();
				
				for(int i = 0;i<Normalcnt;i++)
				{
					if(ID.equals(user[i].getID()))
					{
						id_flag++;
						System.out.print("비밀번호를 입력해주세요 : ");
						String Password = scan.next();
						if(Password.equals(user[i].getPW()))
						{
							System.out.println("수정 할  Id를 입력해주세요(변경하고 싶은 ID): ");
							String ID2 = scan.next();
							for(int j=0;j<Normalcnt;j++)
							{
								if(ID2.equals(user[j].getID()))
								{
									flag++;
								}
								
							}
							if(flag == 0)
							{
								user[i].setID(ID2);
								System.out.println("수정완료");
								return;
							}
							else
							{
								System.out.println("중복된 아이디가 있습니다");
							}
						}
						else
						{
							System.out.println("비밀번호가 맞지 않습니다");
							return;
						}
					}
				}
				if(id_flag == 0)
				{
					System.out.println("잘못된/없는 아이디입니다.");
					return;
				}
			}
			else if(n == 2)
			{
				System.out.print("id를 입력해주세요 : ");
				String ID = scan.next();
				int flag1 = 0;
				
				for(int i = 0;i<Normalcnt;i++)
				{
					if(ID.equals(user[i].getID()))
					{
						flag1++;
						System.out.println("수정 하고 싶은 pw를 입력해주세요: ");
						String pw = scan.next();
						
						user[i].setPW(pw);
						System.out.println("수정완료");
						return;
					}
				}
				if(flag1 == 0)
				{
					System.out.println("잘못된/없는 아이디입니다.");
					return;
				}
			}
			else
			{
				System.out.println();
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}
}