package com.sono.myproj.proc;

import java.io.IOException;

import org.springframework.stereotype.Component;

/**
 * <pre>
 * メインプロセスのインタフェース.
 * 実行メソッド及びメインから渡されるパラメータの処理メソッドを定義する.
 * </pre>
 * 
 * @author entakuya
 */
@Component
public interface MainProc {
	public void execute(String[] parameters) throws IOException;

	public void executeParameters(String[] parameters);
}
