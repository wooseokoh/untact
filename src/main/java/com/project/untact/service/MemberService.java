package com.project.untact.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.untact.dto.Article;
import com.project.untact.dao.MemberDao;
import com.project.untact.dto.Member;
import com.project.untact.dto.ResultData;
import com.project.untact.util.Util;

@Service
public class MemberService {

	@Autowired
	private GenFileService genFileService;
	
	@Autowired
	private MemberDao memberDao;
	
	// static 시작

		public static String getAuthLevelName(Member member) {
			switch ( member.getAuthLevel() ) {
			case 7:
				return "관리자";
			case 3:
				return "일반";
			default:
				return "유형정보없음";
			}
		}

		public static String getAuthLevelNameColor(Member member) {
			switch ( member.getAuthLevel() ) {
			case 7:
				return "red";
			case 3:
				return "gray";
			default:
				return "";
			}
		}

		// static 끝
	
	public ResultData join(Map<String, Object> param) {
		memberDao.join(param);

		int id = Util.getAsInt(param.get("id"), 0);
		
		genFileService.changeInputFileRelIds(param, id);

		return new ResultData("S-1", String.format("%s님 환영합니다.", param.get("nickname")), "id", id);
	}

	public Member getMember(int id) {
		return memberDao.getMember(id);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public ResultData modifyMember(Map<String, Object> param) {
		memberDao.modifyMember(param);

		return new ResultData("S-1", "회원정보가 수정되었습니다.");
	}
	
	public boolean isAdmin(Member actor) {
		return actor.getAuthLevel() == 7;
	}

	public Member getMemberByAuthKey(String authKey) {
		return memberDao.getMemberByAuthKey(authKey);
	}

	public List<Member> getForPrintMembers(String searchKeywordType, String searchKeyword, int page, int itemsInAPage, Map<String, Object> param) {
		int limitStart = (page - 1) * itemsInAPage;
		int limitTake = itemsInAPage;

		param.put("searchKeywordType", searchKeywordType);
		param.put("searchKeyword", searchKeyword);
		param.put("limitStart", limitStart);
		param.put("limitTake", limitTake);

		return memberDao.getForPrintMembers(param);
	}

	public Member getForPrintMember(int id) {
		return memberDao.getForPrintMember(id);
	}
}
