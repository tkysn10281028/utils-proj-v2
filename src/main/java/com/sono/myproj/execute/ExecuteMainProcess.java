package com.sono.myproj.execute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sono.myproj.proc.MainProc;

/**
 * <pre>
 * メインプロセスの実行クラス.
 * アプリケーションのエントリポイントから遷移してメインプロセスを実行するクラス.
 * Qualifierで実行するbean名を指定する.
 * </pre>
 * 
 * @author entakuya
 */
@Component
public class ExecuteMainProcess {
	Logger logger = LoggerFactory.getLogger(ExecuteMainProcess.class);
	@Autowired
	MainProc mainProc;

	public void executeMainProcess(String[] args) {
		try {
			mainProc.execute(args);
		} catch (Exception e) {
			var msg = "プロセス実行時に異常を検知しました.システム管理者にお問合せください。";
			informErrorMsgStdout(msg);
		}
	}

	/**
	 * 標準出力にエラーメッセージを出力.
	 * 
	 * @param msg
	 */
	private void informErrorMsgStdout(String msg) {
		System.out.println(msg);
	}
}
