package Entity;

import Exception.AccountException;

public class NormalAccount extends Account
{
	private int rate;
	
	public NormalAccount(int id,int bal,int pw,String name,int idx,int num)
	{
		super(id,bal,pw,name,idx);
		this.rate = num;
	}
	
	public void Deposit(int money) throws AccountException
	{
		super.Deposit(money);
		super.Deposit((int) (money * (rate/100.0)));
	}
}