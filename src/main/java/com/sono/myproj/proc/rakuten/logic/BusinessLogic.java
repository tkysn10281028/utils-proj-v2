package com.sono.myproj.proc.rakuten.logic;

import java.io.IOException;

import org.springframework.stereotype.Component;

/**
 * <pre>
 * ビジネスロジックのインタフェース.
 * 事前、メイン、事後のプロセス及びプロセス全体の実行メソッドを定義.
 * </pre>
 * 
 * @author entakuya
 *
 */
@Component
public interface BusinessLogic {

	public void beforeProcess() throws IOException;

	public void mainProcess();

	public void afterProcess();

	public void executeBusinessLogic() throws IOException;
}
