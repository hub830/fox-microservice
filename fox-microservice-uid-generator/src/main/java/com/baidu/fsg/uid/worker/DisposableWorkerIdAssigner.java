/*
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserve.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.fsg.uid.worker;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.fsg.uid.exception.UidGenerateException;
import com.baidu.fsg.uid.properties.UidProperties;

/**
 * Represents an implementation of {@link WorkerIdAssigner}, the worker id will
 * be discarded after assigned to the UidGenerator
 * 
 * @author yutianbao
 */
public class DisposableWorkerIdAssigner implements WorkerIdAssigner {

	@Autowired
	private UidProperties uidProperties;

	/**
	 * Assign worker id base on database.
	 * <p>
	 * If there is host name & port in the environment, we considered that the node
	 * runs in Docker container<br>
	 * Otherwise, the node runs on an actual machine.
	 * 
	 * @return assigned worker id
	 */
	@Transactional
	public long assignWorkerId() {

		return znodeSeq();
	}

	/**
	 * 通过znode数据版本实现分布式seq生成
	 * 
	 * @throws Exception
	 */
	public long znodeSeq() {
		CuratorFramework client = CuratorFrameworkFactory.newClient(uidProperties.getZkHost(),
				new RetryNTimes(10, uidProperties.getZkConnectionTimeout()));
		client.start();
		try {

			Stat stat = client.checkExists().forPath(uidProperties.getWorkerNodePath());
			if (stat == null) {
				client.create().forPath(uidProperties.getWorkerNodePath(), "".getBytes());
				stat = client.checkExists().forPath(uidProperties.getWorkerNodePath());
			}
			return stat.getVersion();
		} catch (Exception e) {
			e.printStackTrace();
			throw new UidGenerateException("连接 zookeeper获取 workId时发生异常", e);
		} finally {
			CloseableUtils.closeQuietly(client);
		}
	}

}
