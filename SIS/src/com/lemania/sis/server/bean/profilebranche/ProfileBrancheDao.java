package com.lemania.sis.server.bean.profilebranche;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import com.lemania.sis.server.bean.branche.Branche;
import com.lemania.sis.server.bean.profilesubject.ProfileSubject;
import com.lemania.sis.server.service.MyDAOBase;

public class ProfileBrancheDao extends MyDAOBase {
	/*
	 * 
	 * */
	public void initialize(){
		return;
	}
	
	/*
	 * 
	 * */
	public List<ProfileBranche> listAll(){
		Query<ProfileBranche> q = ofy().load().type(ProfileBranche.class).order("profileBrancheName");
		List<ProfileBranche> returnList = new ArrayList<ProfileBranche>();
		for (ProfileBranche profileBranche : q){
			profileBranche.setProfileBrancheName( ofy().load().key( profileBranche.getProfileBranche()).now().getBrancheName() );
			profileBranche.setProfileBrancheName2( ofy().load().key( profileBranche.getProfileBranche()).now().getBrancheName2() );
			returnList.add(profileBranche);
		}
		return returnList;
	}
	
	/*
	 * 
	 * */
	public List<ProfileBranche> listAllActive(){
		Query<ProfileBranche> q = ofy().load().type(ProfileBranche.class)
				.filter("isActive", true)
				.order("profileBrancheName");
		List<ProfileBranche> returnList = new ArrayList<ProfileBranche>();
		for ( ProfileBranche profileBranche : q ){
			profileBranche.setProfileBrancheName( ofy().load().key( profileBranche.getProfileBranche()).now().getBrancheName() );
			profileBranche.setProfileBrancheName2( ofy().load().key( profileBranche.getProfileBranche()).now().getBrancheName2() );
			returnList.add( profileBranche );
		}
		return returnList;
	}
	
	/*
	 * 
	 * */
	public List<ProfileBranche> listAll( String profileSubjectId ){
		Query<ProfileBranche> q = ofy().load().type(ProfileBranche.class)
				.filter("profileSubject",  Key.create(ProfileSubject.class, Long.parseLong(profileSubjectId)))
				.order("profileBrancheName");
		List<ProfileBranche> returnList = new ArrayList<ProfileBranche>();
		for ( ProfileBranche profileBranche : q ){
			profileBranche.setProfileBrancheName( ofy().load().key( profileBranche.getProfileBranche()).now().getBrancheName() );
			profileBranche.setProfileBrancheName2( ofy().load().key( profileBranche.getProfileBranche()).now().getBrancheName2() );
			returnList.add( profileBranche );
		}
		return returnList;
	}
	
	/*
	 * 
	 * */
	public void save(ProfileBranche profileBranche){
		ofy().save().entities( profileBranche );
	}
	
	/*
	 * 
	 * */
	public ProfileBranche saveAndReturn(ProfileBranche profile){
		Key<ProfileBranche> key = ofy().save().entities(profile).now().keySet().iterator().next();
		try {
			ProfileBranche ps = ofy().load().key(key).now();
			ps.setProfileBrancheName( ofy().load().key( ps.getProfileBranche()).now().getBrancheName() );
			ps.setProfileBrancheName2( ofy().load().key( ps.getProfileBranche()).now().getBrancheName2() );
			return ps;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 
	 * */
	public ProfileBranche saveAndReturn(String profileSubjectId, String brancheId, String brancheCoef ){
		//
		ProfileBranche ps = new ProfileBranche();
		ps.setProfileSubject(  Key.create( ProfileSubject.class, Long.parseLong(profileSubjectId)) );
		ps.setProfileBranche( Key.create( Branche.class, Long.parseLong(brancheId)) );
		ps.setProfileBrancheName( ofy().load().key( ps.getProfileBranche()).now().getBrancheName() );
		ps.setProfileBrancheName2( ofy().load().key( ps.getProfileBranche()).now().getBrancheName2() );
		ps.setBrancheCoef( Double.parseDouble(brancheCoef) );
		
		Key<ProfileBranche> key = ofy().save().entities( ps ).now().keySet().iterator().next();
		try {
			return ofy().load().key(key).now();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 
	 * */
	public void removeProfileBranche(ProfileBranche profileBranche){
		ofy().delete().entities( profileBranche );
	}
}
