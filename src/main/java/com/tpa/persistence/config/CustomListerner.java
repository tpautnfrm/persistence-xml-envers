package com.tpa.persistence.config;

import org.hibernate.envers.RevisionListener;

import com.tpa.persistence.audit.Revision;

public class CustomListerner implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		// TODO Auto-generated method stub
		
		Revision a= (Revision)revisionEntity;
		
	}

}
