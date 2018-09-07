package Exception;

@SuppressWarnings("serial")
public class LoginException extends AccountException{

	@Override
	public void ShowExceptionReason() {
		// TODO Auto-generated method stub
		System.out.println("잘못된/없는 아이디입니다");
	}

}
