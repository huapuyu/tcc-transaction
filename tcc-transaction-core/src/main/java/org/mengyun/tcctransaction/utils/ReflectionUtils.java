package org.mengyun.tcctransaction.utils;

import java.lang.reflect.Method;

public class ReflectionUtils {

	public static Class<?> getDeclaringType(Class<?> clazz, String methodName, Class<?>[] parameterTypes) {
		Method method = null;
		Class<?> findClass = clazz;

		do {
			Class<?>[] clazzes = findClass.getInterfaces();

			for (Class<?> c : clazzes) {
				try {
					method = c.getDeclaredMethod(methodName, parameterTypes);
				} catch (NoSuchMethodException e) {
					method = null;
				}

				if (method != null) {
					return c;
				}
			}
			findClass = findClass.getSuperclass();
		} while (!findClass.equals(Object.class));

		return clazz;
	}
}
