package com.ericsson.nms.fm.fm_communicator;

import java.io.Serializable;

/**
 * @author tcsbosr
 *
 */
public class FMSInfo implements Serializable{


	private static final long serialVersionUID = 8902184529980921062L;
	private  String ip;
	private  String lookUp;

	
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}


	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}


	/**
	 * @return the lookUp
	 */
	public String getLookUp() {
		return lookUp;
	}


	/**
	 * @param lookUp the lookUp to set
	 */
	public void setLookUp(String lookUp) {
		this.lookUp = lookUp;
	}


	public String toString() {
		return "FMSInfo [ip=" + getIp() + ", Lookup="
				+ getLookUp() + "]";
	}


}