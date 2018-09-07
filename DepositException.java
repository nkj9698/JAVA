package Exception;

@SuppressWarnings("serial")
public class DepositException extends AccountException 
{
	private int money;
	
	public DepositException(int cash)
	{
		this.money = cash;
	}

	public void ShowExceptionReason() {
		// TODO Auto-generated method stub
		System.out.println("[예외 메시지 : " + money + "원은 입급불가]");
	}
}
