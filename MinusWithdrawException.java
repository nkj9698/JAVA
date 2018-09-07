package Exception;

@SuppressWarnings("serial")
public class MinusWithdrawException extends AccountException 
{
	private int money;
	
	public MinusWithdrawException(int cash)
	{
		this.money = cash;
	}

	public void ShowExceptionReason() {
		// TODO Auto-generated method stub
		System.out.println("[예외 메시지 : 출금액" + money + ", 잔액부족]");
		
	}

}
