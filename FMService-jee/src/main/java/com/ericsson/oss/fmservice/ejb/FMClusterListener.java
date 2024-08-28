/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.oss.fmservice.ejb;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.ericsson.oss.itpf.sdk.cluster.MembershipChangeEvent;
import com.ericsson.oss.itpf.sdk.cluster.annotation.ServiceCluster;

@ApplicationScoped
public class FMClusterListener {
	public static boolean isMaster = false;
	@Inject
	private Logger logger;

	public void listenForMembershipChange(
			@Observes @ServiceCluster("FMServiceCluster") final MembershipChangeEvent mce) {
		logger.trace(" listenForMembershipChange " + mce.isMaster());
		this.logger.trace("in cluster bean -->");
		if (mce.isMaster()) {
			isMaster = true;
		} else {
			isMaster = false;
		}
	}
}
