package Entity;

import java.util.Date;

@SuppressWarnings("unused")
public class Adminuser extends User
{
	private String ID;
	private String PW;
	private int authority;
	
	public Adminuser(String id,String pw,int n) {
		// TODO Auto-generated constructor stub
		this.ID = id;
		this.PW = pw;
		this.authority = n;
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




	/**
	 * @return the authority
	 */
	public int getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(int authority) {
		this.authority = authority;
	}
}
