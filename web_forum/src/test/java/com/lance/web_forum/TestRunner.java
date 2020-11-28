package com.lance.web_forum;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		// 測試結果回傳 Result 物件，JUnitCore 擷取 AppTest 中有 @Test 註解的方法
		Result result =JUnitCore.runClasses(DaoTestMain.class);
		
		// 迴圈將 result 每個失敗結果印出
		for (Failure failure : result.getFailures()) {
			// 印出錯誤訊息
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());
	}
}
