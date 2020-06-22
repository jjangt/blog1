package com.green.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.board.ImgBoardService;
import com.green.biz.board.ImgBoardVO;
import com.green.biz.member.MemberVO;
import com.green.biz.reply.ImgBoardReplyService;
import com.green.biz.reply.ImgBoardReplyVO;

@Controller
public class ImgBoardController {

	@Autowired
	private ImgBoardService imgBoardService;
	
	@RequestMapping(value="/img_board_list", method=RequestMethod.GET)
	public String imgBoardListAll(HttpSession session, ImgBoardReplyVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			
			List<ImgBoardVO> imgBoardList = imgBoardService.listAllImgBoard();
			
			model.addAttribute("message", "등록된 게시글이 없습니다.");
			model.addAttribute("imgBoardList", imgBoardList);
			
			return "img_board/imgBoardList";
		}
	}
	
	
	@RequestMapping(value="/img_board_view")
	public String imgBoardView(@RequestParam(value="ibseq") int ibseq,
							   HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";	// 로그인 페이지 호출
		} else {
			
			imgBoardService.plusImgHit(ibseq);
			ImgBoardVO imgBoardVO = imgBoardService.getImgBoard(ibseq);
			
			model.addAttribute("loginUser", loginUser);
			model.addAttribute("imgBoardVO", imgBoardVO);
			
			
			return "img_board/imgBoardView";
		}
	}
	
	@RequestMapping(value="/img_board_write_form")
	public String imgBoardWriteView(HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			return "img_board/imgBoardWrite";
		}
	}
	
	// 이거 대체 어떻게하냐...
	@RequestMapping(value="img_board_write")
	public String imgBoardWrite(@RequestParam (value="thum_img1") MultipartFile thumFile,
								@RequestParam (value="image11") MultipartFile image1,
								@RequestParam (value="image22") MultipartFile image2,
								@RequestParam (value="image33") MultipartFile image3,
								ImgBoardVO vo, HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			String thumFileName = "";
			String imgFileName1 = "";
			String imgFileName2 = "";
			String imgFileName3 = "";
			
			if(!thumFile.isEmpty()) {	// 상품 이미지가 지정되어 있으면
				// session.getServletContext)까지가 = webapp 폴더 까지 지정
				// getRealPath() 괄호안 주소
				String root_path
					= session.getServletContext().getRealPath("WEB-INF/resources/images/thum_img/");
				
				System.out.println("ROOT 경로 = " + root_path);
				
				thumFileName = thumFile.getOriginalFilename();
				
				try {
					File file = new File(root_path + thumFileName);
					thumFile.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			if(!image1.isEmpty()) {	// 상품 이미지가 지정되어 있으면
				// session.getServletContext)까지가 = webapp 폴더 까지 지정
				// getRealPath() 괄호안 주소
				String root_path
					= session.getServletContext().getRealPath("WEB-INF/resources/images/img_board/");
				
				System.out.println("ROOT 경로 = " + root_path);
				
				imgFileName1 = image1.getOriginalFilename();
				
				try {
					File file = new File(root_path + imgFileName1);
					image1.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			if(!image2.isEmpty()) {	// 상품 이미지가 지정되어 있으면
				// session.getServletContext)까지가 = webapp 폴더 까지 지정
				// getRealPath() 괄호안 주소
				String root_path
					= session.getServletContext().getRealPath("WEB-INF/resources/images/img_board/");
				
				System.out.println("ROOT 경로 = " + root_path);
				
				imgFileName2 = image2.getOriginalFilename();
				
				try {
					File file = new File(root_path + imgFileName2);
					image2.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
			if(!image3.isEmpty()) {	// 상품 이미지가 지정되어 있으면
				// session.getServletContext)까지가 = webapp 폴더 까지 지정
				// getRealPath() 괄호안 주소
				String root_path
					= session.getServletContext().getRealPath("WEB-INF/resources/images/img_board/");
				
				System.out.println("ROOT 경로 = " + root_path);
				
				imgFileName3 = image3.getOriginalFilename();
				
				try {
					File file = new File(root_path + imgFileName3);
					image3.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
				
			vo.setThum_img(thumFileName);	// image 컬럼에 이미지 파일명 저장
			vo.setImage1(imgFileName1);
			vo.setImage2(imgFileName2);
			vo.setImage3(imgFileName3);
			vo.setM_id(loginUser.getId());
			System.out.println(vo);
			
			imgBoardService.insertImgBoard(vo);
			
			return "redirect:/img_board_list";
		}
	}
	
	@RequestMapping(value="/img_board_delete")
	public String imgBoardDelete(@RequestParam(value="ibseq") int ibseq,
								 HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			imgBoardService.deleteImgBoardReply(ibseq);
			imgBoardService.deleteImgBoard(ibseq);
			
			return "redirect:/img_board_list";
		}					
	}
	
	@RequestMapping(value="/img_board_update_form")
	public String imgBoardUpdateView(HttpSession session, ImgBoardVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			
			ImgBoardVO imgBoardVO = imgBoardService.getImgBoard(vo.getIbseq());
			model.addAttribute("imgBoardVO", imgBoardVO);
			
			return "img_board/imgBoardUpdate";
		}
	}
	
	@RequestMapping(value="img_board_update")
	public String imgBoardUpdate(@RequestParam (value="thum_img1") MultipartFile thumFile,
								 @RequestParam (value="image11") MultipartFile image1,
								 @RequestParam (value="image22") MultipartFile image2,
								 @RequestParam (value="image33") MultipartFile image3,
								 ImgBoardVO vo, HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {			
			String thumFileName = "";
			String imgFileName1 = "";
			String imgFileName2 = "";
			String imgFileName3 = "";
			
			if(!thumFile.isEmpty()) {	// 상품 이미지가 지정되어 있으면
				// session.getServletContext)까지가 = webapp 폴더 까지 지정
				// getRealPath() 괄호안 주소
				String root_path
					= session.getServletContext().getRealPath("WEB-INF/resources/images/thum_img/");
				
				System.out.println("ROOT 경로 = " + root_path);
				
				thumFileName = thumFile.getOriginalFilename();
				
				try {
					File file = new File(root_path + thumFileName);
					thumFile.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				vo.setThum_img(thumFileName);
			}
			
			if(!image1.isEmpty()) {	// 상품 이미지가 지정되어 있으면
				// session.getServletContext)까지가 = webapp 폴더 까지 지정
				// getRealPath() 괄호안 주소
				String root_path
					= session.getServletContext().getRealPath("WEB-INF/resources/images/img_board/");
				
				System.out.println("ROOT 경로 = " + root_path);
				
				imgFileName1 = image1.getOriginalFilename();
				
				try {
					File file = new File(root_path + imgFileName1);
					image1.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				vo.setImage1(imgFileName1);
			}
			
			if(!image2.isEmpty()) {	// 상품 이미지가 지정되어 있으면
				// session.getServletContext)까지가 = webapp 폴더 까지 지정
				// getRealPath() 괄호안 주소
				String root_path
					= session.getServletContext().getRealPath("WEB-INF/resources/images/img_board/");
				
				System.out.println("ROOT 경로 = " + root_path);
				
				imgFileName2 = image2.getOriginalFilename();
				
				try {
					File file = new File(root_path + imgFileName2);
					image2.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				vo.setImage2(imgFileName2);
			}
			
			if(!image3.isEmpty()) {	// 상품 이미지가 지정되어 있으면
				// session.getServletContext)까지가 = webapp 폴더 까지 지정
				// getRealPath() 괄호안 주소
				String root_path
					= session.getServletContext().getRealPath("WEB-INF/resources/images/img_board/");
				
				System.out.println("ROOT 경로 = " + root_path);
				
				imgFileName3 = image3.getOriginalFilename();
				
				try {
					File file = new File(root_path + imgFileName3);
					image3.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				vo.setImage3(imgFileName3);
			}
				
			vo.setThum_img(thumFileName);	// image 컬럼에 이미지 파일명 저장
			vo.setImage1(imgFileName1);
			vo.setImage2(imgFileName2);
			vo.setImage3(imgFileName3);
//			vo.setM_id(loginUser.getId());
			System.out.println("업데이트 정보: " + vo);
			
			imgBoardService.updateImgBoard(vo);
			
			return "redirect:/img_board_view?ibseq="+vo.getIbseq();
			
		}
	}
}
