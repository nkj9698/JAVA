package Main;



import java.util.InputMismatchException;

import Exception.AccountException;

import Handler.LoginHandler;

public class BankingSystemVer11 {

	public static void main(String[] args) throws AccountException {
		// TODO Auto-generated method stub
		try {
		while(true)
		{
			LoginHandler.ShowMenu();
			int num = LoginHandler.scan.nextInt();
			
			
			switch(num)
			{
				case 1:
					LoginHandler.NormalLogin();
					break;
				case 2:
					LoginHandler.MakeNormalUser();
					break;
				case 3:
					LoginHandler.AdminLogin();
					break;
				case 4:
					LoginHandler.MKPossAdmin();
					break;
				case 5:
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
			}
		}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다");
		}
	}
}