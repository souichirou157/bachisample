package demo.check.address;

import java.util.List;

import demo.app.main.model.AcountRegist;
import demo.app.warning.InputMissmatchException;
public interface AddressCheck {
	public   abstract  void addresscheck(List<AcountRegist> usertable,int index)throws  InputMissmatchException;
}
