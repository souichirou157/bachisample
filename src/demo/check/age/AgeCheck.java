package demo.check.age;

import java.util.List;

import demo.app.main.model.AcountRegist;
import demo.app.warning.InputMissmatchException;

public interface AgeCheck {
	public abstract void agecheck(List<AcountRegist> usertable,int index) throws InputMissmatchException;
}
