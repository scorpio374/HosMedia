package com.zhsj.hosmedia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

public class FileUtil {

	public static String getFileFromAssets(Context context, String fileName) {
		try {
			InputStream in = context.getResources().getAssets().open(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, "UTF-8"));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
