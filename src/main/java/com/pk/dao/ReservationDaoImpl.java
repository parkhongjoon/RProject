package com.pk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pk.dto.ReservationDto;
import com.pk.dto.ReviewDto;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	private SqlSession sqlSession;
		
	@Autowired
    public  ReservationDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

	@Override
	public int AllCount(ReservationDto dto) throws Exception {
		System.out.println(dto.getUserid());
		Integer totalCount = sqlSession.selectOne("reservation.AllCount", dto.getUserid());
	    System.out.println("total. "+totalCount);
	    return totalCount != null ? totalCount : 0;
	}
	
	@Override
	public int resCount(ReservationDto dto) throws Exception {
		Integer totalCount = sqlSession.selectOne("reservation.resCount", dto.getUserid());
	    System.out.println("res. "+totalCount);
	    return totalCount != null ? totalCount : 0;
	}
	
	@Override
	public int RCount(ReservationDto dto) throws Exception {
		Integer totalCount = sqlSession.selectOne("reservation.RCount", dto.getUserid());
	    System.out.println("RC. "+totalCount);
	    return totalCount != null ? totalCount : 0;
	}
	
	@Override
	public int VCount(ReservationDto dto) throws Exception {
		Integer totalCount = sqlSession.selectOne("reservation.VCount", dto.getUserid());
	    System.out.println("VC. "+totalCount);
	    return totalCount != null ? totalCount : 0;
	}
	
	@Override
	public int CCount(ReservationDto dto) throws Exception {
		Integer totalCount = sqlSession.selectOne("reservation.CCount", dto.getUserid());
	    System.out.println("CC. "+totalCount);
	    return totalCount != null ? totalCount : 0;
	}
	
	@Override
	public List<ReservationDto> resList(ReservationDto dto) throws Exception {
	    List<ReservationDto> resList = sqlSession.selectList("reservation.resList", dto);
	    return resList;
	}
	
}