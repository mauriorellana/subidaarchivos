package com.subidaarchivos.springboot.web.app;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@SpringBootApplication
public class SubidaarchivosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubidaarchivosApplication.class, args);
		
		try{
			String user = "usuario1";
			String pass = "123456";
			//String port = "22";
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			String host = "192.168.2.162";
			
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			//session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(pass);
			session.setConfig(config);
			System.out.println("conectando");
			session.connect();
			System.out.println("conectando2");
			
			ChannelSftp channelsftp = (ChannelSftp) session.openChannel("sftp");
			System.out.println("Session Conectada: " +session.isConnected());
			channelsftp.disconnect();
			session.disconnect();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
