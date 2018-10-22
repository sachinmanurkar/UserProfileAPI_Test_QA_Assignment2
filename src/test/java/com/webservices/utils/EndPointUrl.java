package com.webservices.utils;

public enum EndPointUrl {

	ADD_NEW_PROFILE("/profile/new"), UPDATE_PROFILE("/profile/update"), DELETE_PROFILE("/profile/delete"),
	GET_PROFILE("/profiles"), GET_PROFILE_BY_ID("/profile/");

	String resourcepath;

	EndPointUrl(String resourcepath) {
		this.resourcepath = resourcepath;
	}

	public String getresourcepath() {
		return this.resourcepath;
	}

	public String getresourcepath(String data) {
		return this.resourcepath + data;
	}

	public static void main(String[] args) {
		System.out.println(EndPointUrl.ADD_NEW_PROFILE.getresourcepath());

		System.out.println("Comeplete url");
		System.out.println(URL.fixedUrl + EndPointUrl.ADD_NEW_PROFILE.getresourcepath());
	}
}
