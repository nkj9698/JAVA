package Exception;

@SuppressWarnings("serial")
public class pwException extends AccountException {

	@Override
	public void ShowExceptionReason() {
		// TODO Auto-generated method stub
		System.out.println("잘못된 패스워드 입니다");

	}
}