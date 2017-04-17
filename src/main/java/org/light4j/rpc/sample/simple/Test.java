package org.light4j.rpc.sample.simple;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.light4j.rpc.sample.simple.client.service.RpcImporter;
import org.light4j.rpc.sample.simple.server.service.EchoService;
import org.light4j.rpc.sample.simple.server.service.RpcExporter;
import org.light4j.rpc.sample.simple.server.service.impl.EchoServiceImpl;

public class Test {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					RpcExporter.exporter("localhost", 8088);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
		EchoService echo = importer.importer(EchoServiceImpl.class,
				new InetSocketAddress("localhost", 8088));
		System.out.println(echo.echo("Are you ok?"));
	}
}