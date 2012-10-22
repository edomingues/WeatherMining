package com.weathermining;

import java.io.IOException;

public interface IDataSource<T> {
	public T read() throws IOException;
}
