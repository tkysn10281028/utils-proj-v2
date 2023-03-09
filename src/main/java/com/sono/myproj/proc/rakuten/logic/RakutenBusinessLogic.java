package com.sono.myproj.proc.rakuten.logic;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * DataAccessUtilsのビジネスロジック実行クラス.
 * </pre>
 * 
 * @author entakuya
 */
@Component
public class RakutenBusinessLogic implements BusinessLogic {
	Logger logger = LoggerFactory.getLogger(RakutenBusinessLogic.class);
	String url = "/Users/entakuya/money/enavi202303(0789).csv";
	String url2 = "/Users/entakuya/money/202303050911_01.csv";
	String url3 = "/Users/entakuya/money/statement-301-1-2099570.csv";
	Charset charsetUTF8 = Charset.forName("UTF-8"); // 文字コード
	Charset charsetSJIS = Charset.forName("Shift_JIS"); // 文字コード

	@Override
	public void executeBusinessLogic() throws IOException {
		beforeProcess();
		mainProcess();
		afterProcess();
	}

	@Override
	public void beforeProcess() throws IOException {
		logger.info("beforeProcess started.");
		var result = Files.readAllLines(Paths.get(url), charsetUTF8);
		System.out.println(result);
		var result2 = Files.readAllLines(Paths.get(url2), charsetSJIS);
		System.out.println(result2);
		var result3 = Files.readAllLines(Paths.get(url3), charsetSJIS);
		System.out.println(result3);

	}

	@Override
	public void mainProcess() {
		logger.info("mainProcess started.");
	}

	@Override
	public void afterProcess() {
		logger.info("afterProcess.started");
		System.out.println("rakuten process done.");
	}
}
