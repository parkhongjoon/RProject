package com.pk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pk.dao.ReservationDao;
import com.pk.dto.ReservationDto;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationDao dao;

    @Override
    public int AllCount(ReservationDto dto) throws Exception {
    	
        return dao.AllCount(dto);
        
    }

	@Override
	public int resCount(ReservationDto dto) throws Exception {
		return dao.resCount(dto);
	}
	
	@Override
	public int RCount(ReservationDto dto) throws Exception {
		return dao.RCount(dto);
	}
	
	@Override
	public int VCount(ReservationDto dto) throws Exception {
		return dao.VCount(dto);
	}
	
	@Override
	public int CCount(ReservationDto dto) throws Exception {
		return dao.CCount(dto);
	}
	
	@Override
	public List<ReservationDto> resList(ReservationDto dto) throws Exception {
		return dao.resList(dto);
	}
}
