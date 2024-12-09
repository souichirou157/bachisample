package demo.app.main.model.message;

import demo.app.main.model.AcountRegist;

public abstract class InvalidCatchmessage {
	
	public void invalidCatchMessage(AcountRegist usertable) {
		System.out.println();
		System.out.println(usertable+"のデータから不正な値を検出");
	}
}
