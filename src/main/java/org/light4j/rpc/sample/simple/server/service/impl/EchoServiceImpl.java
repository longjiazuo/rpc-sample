package org.light4j.rpc.sample.simple.server.service.impl;

import org.light4j.rpc.sample.simple.server.service.EchoService;

public class EchoServiceImpl implements EchoService {

	@Override
	public String echo(String ping) {
		return ping != null ? ping + "--> I am ok." : "I am ok";
	}
}
