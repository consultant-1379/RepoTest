package com.ericsson.nms.fm.fm_communicator;



/**
 * @author tcsjapa
 *
 */
public interface FMServiceRemote  {	
	
	/**
	 * @param fdn
	 */
	int startSupervision(String fdn,FmNeProperties fmNeProperties,RIAData riaData);
	/**
	 * @param fdn
	 */
	int stopSupervision(String fdn);
	/**
	 * @param fdn
	 */
	int startSync(String fdn);
	/**
	 * @param ackRequest
	 */
	int ackAlarm(AckRequest ackRequest);
}
