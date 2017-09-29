package org.chickendb;

public interface IFilter<M extends IModel<?>> {
	boolean validate(M item);
}
