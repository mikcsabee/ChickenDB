package org.chickendb.logic;

import org.chickendb.model.IModel;

public interface IFilter<M extends IModel<?>> {
	boolean validate(M item);
}
