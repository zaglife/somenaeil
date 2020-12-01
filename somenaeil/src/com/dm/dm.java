package com.dm;

import java.util.Date;

public class dm {
	private int num;
	private String other;
	private String context;
	private Date time;
	private int cert;
	
	public dm() {}
	public dm(	int num,
				String other,
				String context,
				Date time,
				int cert	) {
		this.num= num;
		this.other= other;
		this.context= context;
		this.time= time;
		this.cert= cert;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getCert() {
		return cert;
	}
	public void setCert(int cert) {
		this.cert = cert;
	}
}
