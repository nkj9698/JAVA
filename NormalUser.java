package Entity;


import java.time.LocalDate;

public class NormalUser 
{
	private String ID;
	private String PW;
	private int num;
	LocalDate date = LocalDate.now();
	
	
	public NormalUser(String id,String pw,int num) 
	{
		this.ID = id;
		this.PW = pw;
		this.num = num;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}


	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}


	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}


	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}


	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}


	/**
	 * @return the pW
	 */
	public String getPW() {
		return PW;
	}


	/**
	 * @param pW the pW to set
	 */
	public void setPW(String pW) {
		PW = pW;
	}
}
