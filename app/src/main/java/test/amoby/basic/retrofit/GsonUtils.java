package test.amoby.basic.retrofit;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;

/**
 * 自定义的Gson
 */
public class GsonUtils {

	public static Gson newInstance() {
		GsonBuilder builder = new GsonBuilder();

		builder.setFieldNamingStrategy(new AnnotateNaming());

		return builder.create();
	}

	private static class AnnotateNaming implements FieldNamingStrategy {

		@Override
		public String translateName(Field field) {
			ParamName a = field.getAnnotation(ParamName.class);
			return a != null ? a.value() : FieldNamingPolicy.IDENTITY
					.translateName(field);
		}
	}
}