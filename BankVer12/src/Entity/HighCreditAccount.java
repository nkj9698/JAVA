package Entity;

import Exception.AccountException;

public class HighCreditAccount extends NormalAccount
{
	private int rate2;
	
	public HighCreditAccount(int id,int bal,int pw,String name,int idx,int num,int num2)
	{
		super(id,bal,pw,name,idx,num);
		this.rate2 = num2;
	}
	
	public void Deposit(int money) throws AccountException
	{
		super.Deposit(money);
		this.setBalance(this.getBalance() + ((int) (money * (rate2/100.0))));
	}
}
