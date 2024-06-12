package com.pk.dao;

import java.util.List;

import com.pk.dto.ReservationDto;

public interface ReservationDao {
	
	public int AllCount(ReservationDto dto) throws Exception;
	
	public int resCount(ReservationDto dto) throws Exception;
	
	public int RCount(ReservationDto dto) throws Exception;

	public int VCount(ReservationDto dto) throws Exception;

	public int CCount(ReservationDto dto) throws Exception;

	public List<ReservationDto> resList(ReservationDto dto) throws Exception;
}