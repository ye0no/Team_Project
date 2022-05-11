package net.webplate.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.webplate.vo.FoodVO;


@Repository
public class FoodDAOImpl implements FoodDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int getListCount(FoodVO food) {
		return sqlSession.selectOne("food_cnt",food);
	}

	@Override
	public List<FoodVO> getBoardList(FoodVO food) {
		return sqlSession.selectList("food_list",food);
	}
	
	
	/* 총 갯수 */
	@Override
	public int getTotalCount(FoodVO food) {
		return sqlSession.selectOne("food_count",food);
	}
    
	
	// 검색 개수
	@Override
	public int getSerachCount(FoodVO food) {
		return sqlSession.selectOne("search_cnt",food);
	}
    
	
	// 검색 리스트
	@Override
	public List<FoodVO> getSearchList(FoodVO food) {
		return sqlSession.selectList("search_List",food);
	}
     
	// 지역별 리스트
	@Override
	public List<FoodVO> getAddrCont(String divide) {
		return sqlSession.selectList("food_Area",divide);
	}
	
    // 지역별 개수
	@Override
	public int foodAreaCount(String divide) {
		return sqlSession.selectOne("food_Area_cnt",divide);
	}

	@Override
	public int foodArea_Hit(String divide) {
		return sqlSession.selectOne("food_Area_hit",divide);
	}
	
	// 돼지고기 맛집 탑 8

	@Override
	public List<FoodVO> getTop_8(String pig) {
		return sqlSession.selectList("top_pig8",pig);
	}

	// 음식 종류 분류
	@Override
	public List<FoodVO> getCondList(String eat) {
		return sqlSession.selectList("cond_divide",eat);
	}
	
	// 믿고 보는 맛집 리스트 조회수
	@Override
	public int getContHit(String eat) {
		return sqlSession.selectOne("cond_hit",eat);
	}	
	
	
	// 믿고 보는 맛집 리스트 개수
	@Override
	public int getCont_Count(String eat) {
		return sqlSession.selectOne("cond_count",eat);
	}
	
	// 평점 탑 8 리스트
	@Override
	public List<FoodVO> getTop_8() {
		return sqlSession.selectList("Grade_Top8");
	}
	
	// 좋아요 구분
	@Override
	public List<FoodVO> getLike_state(String Sid) {
		return  sqlSession.selectList("food_like_state",Sid);
	}

	@Override
	public List<FoodVO> getCondList2(FoodVO food) {	
		return sqlSession.selectList("food_cont_like",food);
	}

	// 좋아요 구분하기 위한 지역별 맛집리스트
	@Override
	public List<FoodVO> getAddrCont2(FoodVO food) {
		return sqlSession.selectList("food_addr_like",food);
	}
	
	// 메뉴별 조회수
	@Override
	public int getTotal_MenuContHit(String eat2) {
		return sqlSession.selectOne("food_menu_hit",eat2);
	}
	
	// 로그인 상태시 메뉴별 조회
	@Override
	public List<FoodVO> getMenuList2(FoodVO food) {
		return sqlSession.selectList("food_menu_List",food);
	}
	
	// 비회원 메뉴별 조회
	@Override
	public List<FoodVO> getMenuList(String eat2) {
		return sqlSession.selectList("food_getMenuList2",eat2);
	}
	






	

	

}
