package com.pk.dto;

import lombok.Data;

@Data
public class ReservationDto {
	
	private String userid;
	private int rtCode;
	private String usertel; 
	private String rtAddr1;
	private String rtAddr2;
	private String rtTel;
	private String rtName;
	private int resNum;
	private int role;
	
	public ReservationDto() {}
}
