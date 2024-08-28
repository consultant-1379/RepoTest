package com.ericsson.oss.fmservice.ejb;

import java.net.InetAddress;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.slf4j.Logger;

import com.ericsson.nms.fm.fm_communicator.FMSInfo;

/**
 * @author tcsnahi This bean sends IP of FM Service to FM Communicator at
 *         startup
 * 
 */
@Startup
@Singleton
public class FMSStartupBean {

	@Inject
	private Logger logger;
	private static int retryCounter = 0;
	private static String localIP;
	private static final String queueName = "FMSIdQueue";
	private ActiveMQConnection connection = null;
	private Session queueSession = null;
	private MessageProducer queueProducer = null;
	private static final String OSS_IP = "masterservice";
	private static final String OSS_PORT = "50057";

	@Resource(lookup = "java:module/ModuleName")
	private String moduleName;

	@Resource(lookup = "java:app/AppName")
	private String appName;

	@PostConstruct
	public void init() {
		this.logger.trace("FMSStartupBean.init -->");
		this.logger.trace("Starting startup bean");
		createStartUpTimer();
		this.logger.trace("FMSStartupBean.init <--");
	}

	@Resource
	TimerService timerService;

	public void createStartUpTimer()

	{
		logger.trace("----------createStartUpTimer ----------");
		this.logger.trace("FMSStartupBean.createStartUpTimer -->");
		for (Object obj : timerService.getTimers()) {
			final Timer t = (Timer) obj;
			if (t.getInfo().equals("FMStartUpBean Timer")) {
				t.cancel();
			}
		}
		final Timer startUpTimer = timerService.createTimer(10000, 6000,
				"FMStartUpBean Timer");
		this.logger.trace("Created Startup timer -" + startUpTimer.toString());
		this.logger.trace("FMSStartupBean.createStartUpTimer <--");
	}

	@Timeout
	public void timeout(final Timer startUpTimer)

	{
		logger.trace("----------timeout ----------");
		this.logger.trace("FMSStartupBean.timeout -->");
		retryCounter++;
		this.logger.trace("Sending IP");
		this.logger.trace("Ip sending counter value = " + retryCounter);
		if (FMClusterListener.isMaster == false) {
			this.logger.trace("FMSStartupBean.timeout not master <--");
			return;
		}
		this.logger.trace("FMSStartupBean.timeout is master -->");
		try {
			localIP = InetAddress.getLocalHost().getHostAddress().toString();
			connection = ActiveMQConnection.makeConnection("failover://tcp://"
					+ OSS_IP + ":" + OSS_PORT);

			connection.start();

			queueSession = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			final Destination destination = queueSession.createQueue(queueName);

			queueProducer = queueSession.createProducer(destination);
			queueProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
			final FMSInfo fmsInfo = new FMSInfo();
			fmsInfo.setIp(localIP);
			fmsInfo.setLookUp("ejb:"
					+ appName
					+ "/"
					+ moduleName
					+ "/FMServiceBean!com.ericsson.nms.fm.fm_communicator.FMServiceRemote");
			final ObjectMessage message = queueSession.createObjectMessage();
			message.setObject(fmsInfo);
			logger.trace("messgae is ====" + message.getObject());

			queueProducer.send(message, DeliveryMode.PERSISTENT, 4, 0);
			this.logger.trace("IP sent to FM Communicator");
		} catch (Exception e) {
			this.logger
					.error("Exception occured while sending IP to FM Communicator -"
							+ e.getMessage());
		}
		this.logger.trace("FMSStartupBean.timeout <--");
	}
}