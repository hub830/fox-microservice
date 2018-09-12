package com.baidu.fsg.uid.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "uid.generator")
public class UidProperties {

	/**
	 * 提前创建好存储Seq的"/createSeq"结点 CreateMode.PERSISTENT
	 */
	private String workerNodePath = "/uid/generator/workerNode";

	/**
	 * connection连接时间
	 */
	private int zkConnectionTimeout =3000;

	private String zkHost = "192.168.1.1:2181";

	public String getWorkerNodePath() {
		return workerNodePath;
	}

	public void setWorkerNodePath(String workerNodePath) {
		this.workerNodePath = workerNodePath;
	}

	public int getZkConnectionTimeout() {
		return zkConnectionTimeout;
	}

	public void setZkConnectionTimeout(int zkConnectionTimeout) {
		this.zkConnectionTimeout = zkConnectionTimeout;
	}

	public String getZkHost() {
		return zkHost;
	}

	public void setZkHost(String zkHost) {
		this.zkHost = zkHost;
	}

	@Override
	public String toString() {
		return "UidProperties [workerNodePath=" + workerNodePath + ", zkConnectionTimeout=" + zkConnectionTimeout
				+ ", zkHost=" + zkHost + "]";
	}
}
