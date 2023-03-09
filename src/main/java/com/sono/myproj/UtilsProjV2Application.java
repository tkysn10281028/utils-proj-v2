package com.sono.myproj;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sono.myproj.execute.ExecuteMainProcess;

@SpringBootApplication
public class UtilsProjV2Application {

	public static void main(String[] args) {
		var app = new SpringApplication(UtilsProjV2Application.class);
		app.setBannerMode(Banner.Mode.LOG);
		var context = app.run(args);
		var dto = context.getBean(ExecuteMainProcess.class);
		dto.executeMainProcess(args);
		context.close();
	}
}
