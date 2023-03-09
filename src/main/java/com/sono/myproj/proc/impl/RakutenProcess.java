package com.sono.myproj.proc.impl;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sono.myproj.proc.MainProc;
import com.sono.myproj.proc.rakuten.logic.BusinessLogic;

/**
 * <pre>
 * methodutil機能の実行クラス.
 * アプリケーションに渡されたパラメータを処理.
 * パラメータ処理後にビジネスロジックを実行する.
 * ビジネスロジックで発生した例外の処理を行う.
 * </pre>
 * 
 * @author entakuya
 */
@Component
public class RakutenProcess implements MainProc {
	Logger logger = LoggerFactory.getLogger(RakutenProcess.class);
	@Autowired
	BusinessLogic businessLogic;

	@Override
	public void execute(String[] parameters) throws IOException {
		businessLogic.executeBusinessLogic();
	}

	@Override
	public void executeParameters(String[] parameters) {
		Arrays.asList(parameters).forEach((parameter) -> {
			logger.info("Do Not Use Argument : {}", parameter);
		});
	}
}
