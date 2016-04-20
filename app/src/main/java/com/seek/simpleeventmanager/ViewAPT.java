/**  

 * @Title: ViewAPT.java 

 * @Description: annotation processing tools

 * @author seek 951882080@qq.com  

 * @version V1.0  

 */

package com.seek.simpleeventmanager;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * 提取我们自定义的Annotation的工具类
 * 
 */
public class ViewAPT {

	private ViewAPT() {
	}

	public static void init(Activity context) {
		init(context, context.getWindow().getDecorView());
	}

	public static void init(Object context, View parent) {
		Field[] fields = context.getClass().getDeclaredFields();
		if (fields == null || fields.length <= 0)
			return;
		for (Field f : fields) {
			try {
				f.setAccessible(true);
				if (f.get(context) != null)
					continue;
				Bind injection = f.getAnnotation(Bind.class);
				if (injection != null) {
					int viewId = injection.value();
					f.set(context, parent.findViewById(viewId));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}