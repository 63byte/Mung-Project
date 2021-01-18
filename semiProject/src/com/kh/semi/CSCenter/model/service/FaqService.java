package com.kh.semi.CSCenter.model.service;
import static com.kh.semi.common.JDBCTemplate.*;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.kh.semi.CSCenter.model.dao.FaqDAO;
import com.kh.semi.CSCenter.model.exception.FileInsertFailedException;
import com.kh.semi.CSCenter.model.vo.Faq;
import com.kh.semi.CSCenter.model.vo.FaqAttachment;
import com.kh.semi.CSCenter.model.vo.PageInfo;


public class FaqService {

	private FaqDAO dao = new FaqDAO();
	
	
	/** faq 목록 조회
	 * @param pInfo 
	 * @return bList
	 * @throws Exception
	 */
	public List<Faq> selectFaqList(PageInfo pInfo) throws Exception {
		Connection conn = getConnection();
 
		List<Faq> bList = dao.selectFaqList(conn,pInfo);

		
		close(conn);
		return bList;
	}


	/** faq 글 등록 
	 * @param map
	 * @return result
	 * @throws Exception
	 */
	public int insertFaq(Map<String, Object> map) throws Exception{
	
		Connection conn =getConnection();
		
		int result = 0;
		
		// faq 게시글 번호 얻어오기
		int faqNo = dao.selectFaqNextNo(conn);
		
		if(faqNo > 0) {
			
			map.put("faqNo",faqNo);
			
			// 크로스 사이트 스크립팅 방지 처리
			
			String faqTitle =(String)map.get("faqTitle");
			String faqContent =(String)map.get("faqContent");
			
			faqTitle =replaceParameter(faqTitle);
			faqContent =replaceParameter(faqContent);

			// 3. 글 내용 개행문자  \r\n -> <br> 변경 처리
			faqContent.replaceAll("\r\n", "<br>");
			
			map.put("faqTitle",faqTitle);
			map.put("faqContent",faqContent);
			
		
		
		try {
			
			result = dao.insertFaq(conn,map);
			
			List<FaqAttachment> fList = (List<FaqAttachment>)map.get("fList");

			
			if(result > 0 && !fList.isEmpty()) {
				
				result = 0;
				
				
				
				for(FaqAttachment at : fList) {
					
					at.setParentfaqNo(faqNo);
					

					result = dao.insertFaqAttachment(conn,at);

					
					if(result == 0) {
						
						
						throw new FileInsertFailedException("파일 정보 삽입 실패");

						
					}
					
				}
				
			}
			
			
		} catch(Exception e) {
			
		 List<FaqAttachment> fList = (List<FaqAttachment>)map.get("fList");

			
		 if(!fList.isEmpty()) {
			 
			 for(FaqAttachment at : fList ) {
				 
				 String filePath = at.getFaqFilePath();
				 String fileName = at.getFaqFileName();
				 
				 File deleteFile = new File(filePath + fileName);
				 
				 
				 if(deleteFile.exists()) {
					 // 해당 경로에 해당 파일이 존재하면 
					 deleteFile.delete();
					 
				 	}
			 	}
				 
			 }	
			
		 	throw e;
			
		}
		
		if(result > 0) {
			commit(conn);
			
			// 삽입 성공 시 상세 조회 화면으로 이동해야되기 때문에
			// 글번호를 반환할 수 있도록 result에 boardNo를 대입
			result = faqNo;
			
		}else {
			rollback(conn);
		}
		
	}
	close(conn);
	
	return result;
			

}
	
	private String replaceParameter(String param) {
		
		String result = param;
		
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
			
		}
		
		return result;
		
		
	}


	/** 페이징 처리를 위한 값 계산 Service
	 * @param cp
	 * @return pInfo
	 * @throws Exception
	 */
	public PageInfo getPageInfo(String cp) throws Exception{
		
		Connection conn = getConnection();
		
		int currentPage = cp ==null ? 1:Integer.parseInt(cp);
		
		
		// DB에서 전체 게시글 수를 조회하여 반환 받기
		int listCount = dao.getListCount(conn);

		
		close(conn);

		
		// 얻어온 현재페이지와 , DB에서 조회한 전체 게시글 수를 이용하여
		// PageInfo 객체를 생성함
		return new PageInfo(currentPage,listCount);
				
	}

}
