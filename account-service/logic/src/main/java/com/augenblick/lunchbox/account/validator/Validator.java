package com.augenblick.lunchbox.account.validator;

import java.util.List;

public interface Validator<T> {
	
	public abstract List<ValidationError> validate(T object);

}
