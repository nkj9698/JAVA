package Exception;

@SuppressWarnings("serial")
public class WithdrawException extends AccountException 
{
	private int money;
	
	public WithdrawException(int cash)
	{
		this.money = cash;
	}

	public void ShowExceptionReason() {
		// TODO Auto-generated method stub
		System.out.println("[예외 메시지 : " + money + "원은 출금불가]");
		
	}

}